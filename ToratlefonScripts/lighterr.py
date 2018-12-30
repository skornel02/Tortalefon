import RPi.GPIO as IO
import requests
import time

url = "http://localhost:8080"
status = "/callstatus"

IO.setmode(IO.BCM)

circlePins = [23, 24, 25, 8]
for pin in circlePins:
    IO.setup(pin, IO.OUT)

IO.setup(18, IO.OUT)
IO.setup(7, IO.OUT)

p = IO.PWM(18, 1000)
p.start(0)

errorLow = True
idleLow = True

p.ChangeDutyCycle(0)
IO.output(7, IO.LOW)
for pin in circlePins:
    IO.output(pin, IO.LOW)

try:
    while True:
        try:
            response = request = requests.get(url + status, timeout=1).content

            if "In call" in response or "In hold" in response:
                print "In a call"
                p.ChangeDutyCycle(0)
                IO.output(7, IO.HIGH)
                time.sleep(3)

            elif "Calling..." in response or "Ringing" in response:
                print "Ringing"
                IO.output(7, IO.LOW)
                p.ChangeDutyCycle(0)
                for x in range(0, 8, 1):
                    IO.output(circlePins[x % 4], IO.HIGH)
                    time.sleep(0.4)
                    IO.output(circlePins[x % 4], IO.LOW)

            else:
                print "Nothing"
                IO.output(7, IO.LOW)
                if idleLow:
                    for x in range(10, 90, 5):
                        p.ChangeDutyCycle(x)
                        time.sleep(0.1)
                else:
                    for x in range(90, 10, -5):
                        p.ChangeDutyCycle(x)
                        time.sleep(0.1)
                idleLow = not idleLow

        except (requests.exceptions.ConnectionError, requests.exceptions.ReadTimeout) :
            print "Error connecting"
            IO.output(7, IO.LOW)
            p.ChangeDutyCycle(0)
            if errorLow:
                for pin in circlePins:
                    IO.output(pin, IO.HIGH)
            else:
                for pin in circlePins:
                    IO.output(pin, IO.LOW)
            time.sleep(3)
except KeyboardInterrupt:
    p.stop()
    IO.cleanup()