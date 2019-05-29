use rust_gpiozero::{LED, PWMLED, Button};
use std::thread::sleep;
use std::time::Duration;
use reqwest::Client;
use std::thread;

enum CallType{
    InCall,
    InitiatingCall,
    Idle,
}

static ADDRESS_INFO: &str = "http://localhost:8080/callstatus";
static ADDRESS_CALL: &str = "http://localhost:8080/ring";

fn main() {
    println!("Starting... ");

    thread::spawn(light_loop);

    let mut button_call = Button::new(1);

    let client = Client::builder()
        .timeout(Duration::from_secs(3))
        .connect_timeout(Duration:: from_secs(2))
        .build().unwrap();

    println!("Button loop started");
    loop{
        button_call.wait_for_press(None);

        match client.get(ADDRESS_CALL).send() {
            Err(x) => {
                println!("Error happened while sending request! {}", x);
            },
            Ok(_) => {
                println!("Pressed!");
            }
        }

        sleep(Duration::from_secs(5));
    }
}

fn light_loop(){
    println!("LED loop started");

    let mut led_call = LED::new(7);
    let mut led_idle = PWMLED::new(18);

    let mut red: Vec<LED> = Vec::new();
    red.push(LED::new(23));
    red.push(LED::new(24));
    red.push(LED::new(25));
    red.push(LED::new(8));

    led_idle.on();
    led_call.on();
    for i in 0..4{
        red[i].on();
    }

    sleep(Duration::from_millis(250));

    led_idle.off();
    led_call.off();
    for i in 0..4{
        red[i].off();
    }

    let client = Client::new();

    let mut last_call = false;
    let mut last_idle = false;
    let mut last_error = false;
    let mut last_calling = false;

    loop{
        let response = get_status(&client);

        match response {
            Ok(call) => {
                match call {
                    CallType::Idle => {
                        if !last_idle{
                            println!("Idle");

                            last_idle = true;
                            last_call = false;
                            last_error = false;
                            last_calling = false;

                            led_call.on();

                            led_idle.set_value(0.0);
                            led_idle.off();
                            for i in 0..4{
                                red[i].off();
                            }
                        }
                    },
                    CallType::InitiatingCall => {
                        if !last_calling{
                            println!("Initiating call");

                            last_calling = true;
                            last_idle = false;
                            last_call = false;
                            last_error = false;

                            for i in 0..4{
                                red[i].off();
                            }
                            led_call.off();
                            led_idle.set_value(0.0);
                            led_idle.off();

                            for i in 0..4{
                                red[i].blink(2.0, 2.0);
                                sleep(Duration::from_millis(250));
                            }
                        }
                    },
                    CallType::InCall => {
                        if !last_call{
                            println!("In call");

                            last_call = true;
                            last_idle = false;
                            last_error = false;
                            last_calling = false;

                            led_call.off();
                            for i in 0..4{
                                red[i].off();
                            }

                            led_idle.pulse(2.0, 2.0);
                        }
                    }
                }
            },
            Err(_) => {
                if !last_error{
                    println!("There was an error!");

                    last_error = true;
                    last_idle = false;
                    last_call = false;
                    last_calling = false;

                    for i in 0..4{
                        red[i].off();
                    }
                    led_call.off();
                    led_idle.off();

                    for i in 0..4{
                        red[i].blink(1.0, 1.0);
                    }
                }
            }
        }
        sleep(Duration::from_secs(5));
    }
}

fn get_status(client: &Client) -> Result<CallType, String>{
    println!("Sending status request...");
    let response = client.get(ADDRESS_INFO)
        .send().map_err(|_| { "Error sending"})?
        .text().map_err(|_| { "Error parsing response"})?;

    if response.contains("In call") || response.contains("In hold"){
        Ok(CallType::InCall)
    }else if response.contains("Calling...") || response.contains("Ringing"){
        Ok(CallType::InitiatingCall)
    }else{
        Ok(CallType::Idle)
    }
}