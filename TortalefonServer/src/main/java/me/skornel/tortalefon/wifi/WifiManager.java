package me.skornel.tortalefon.wifi;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WifiManager {

    @Getter
    private boolean internetAccess = false;
    @Getter
    private String address;

    private String path;

    @Getter
    private List<Network> networks;

    private List<String> trash;

    @Autowired
    public WifiManager(@Value("${torta.ip}") String address, @Value("${torta.wpasupplicant}") String wpaPath) {
        this.address = address;
        networks = new ArrayList<>();
        trash = new ArrayList<>();
        path = wpaPath;
        loadWifiNetworks();
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void checkInternet(){
        try {
            int timeout = 2000;
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            internetAccess = addresses[0].isReachable(timeout);

        }catch (Exception ex){
            internetAccess = false;
        }
    }

    public void loadWifiNetworks(){
        networks.clear();
        trash.clear();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            List<HashMap<String, String>> networks = new ArrayList<>();
            int x = 0;
            String line;

            while (x < lines.size()){
                line = lines.get(x);
                if(line.equals("network={")){
                    HashMap<String, String> network = new HashMap<>();
                    do {
                        String[] split = line.split("=");
                        network.put(split[0], split[1]);
                        x++;
                        line = lines.get(x);
                    }while (!line.equals("}"));
                    network.remove("network");
                    networks.add(network);
                }else {
                    trash.add(line);
                }
                x++;
            }

            networks.forEach(network -> this.networks.add(new Network(network.get("ssid"), network.get("psk"))));

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void addNetwork(Network network){
        networks.add(network);
        saveToFile();
        loadWifiNetworks();
    }

    public void removeNetwork(String ssid){
        networks.removeIf(network -> network.getSSID().equals(ssid));
        saveToFile();
        loadWifiNetworks();
    }

    public void saveToFile(){
        try (FileWriter writer = new FileWriter(path, false)){
            for(String glitter : trash){
                writer.write(glitter + "\n");
            }
            for(Network network : networks){
                writer.write(
                        String.format(
                                "network={\n" +
                                        "ssid=\"%s\"\n" +
                                        "priority=20\n" +
                                        "key_mgmt=WPA-PSK\n" +
                                        "psk=\"%s\"\n" +
                                        "}",
                                network.getSSID(),
                                network.getPassword()));
                writer.write("\n");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
