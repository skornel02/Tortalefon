package me.skornel.tortalefon.wifi;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Network {

    private String SSID;
    private String password;

    public Network(String SSID, String password) {
        this.SSID = SSID.replace("\"", "");
        this.password = password.replace("\"", "");
    }

}
