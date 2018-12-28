package me.skornel.tortalefon.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CallbackManager {

    private List<Callback> callbacks;

    private ObjectMapper mapper = new ObjectMapper();
    private String path;

    @Autowired
    public CallbackManager(@Value("${torta.path}") String path) throws IOException {
        callbacks = new ArrayList<>();
        this.path = path;
        if(!(new File(path, "callbacks").exists()))
            new File(path, "callbacks").createNewFile();
        loadCallbacks();
    }

    private void loadCallbacks(){
        try {
            callbacks = new ArrayList<>();
            Stream.of(mapper.readValue(new File(path, "callbacks"), Callback[].class)).forEach(callbacks::add);
        } catch (IOException e) {
            callbacks = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveCallbacks(){
        try {
            mapper.writeValue(new File(path, "callbacks"), callbacks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Callback> getCallbacks() {
        return callbacks;
    }

    public void addCallback(Callback callback){
        callbacks.add(callback);
        saveCallbacks();
    }

    public void removeCallback(String name){
        callbacks.removeIf(callback -> callback.getName().equals(name));
        saveCallbacks();
    }
}
