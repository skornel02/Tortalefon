package me.skornel.tortalefon.user;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.skornel.tortalefon.callback.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserManager implements UserDetailsService {

    private List<User> users;

    private ObjectMapper mapper = new ObjectMapper();
    private String path;

    @Autowired
    public UserManager(@Value("${torta.path}") String path, PasswordEncoder encoder) throws IOException {
        users = new ArrayList<>();
        this.path = path;
        if(new File(path, "users").exists()){
            loadUsers();
        }else{
            new File(path, "users").createNewFile();
            users.add(new User("admin", encoder.encode("admin"), true));
            saveUsers();
        }
    }

    private void loadUsers(){
        try {
            users = new ArrayList<>();
            Stream.of(mapper.readValue(new File(path, "users"), User[].class)).forEach(users::add);
        } catch (IOException e) {
            users = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveUsers(){
        try {
            mapper.writeValue(new File(path, "users"), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
        saveUsers();
    }

    public void removeUser(String username){
        users.removeIf(user -> user.getUsername().equals(username));
        saveUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        return optionalUser.orElseThrow(() ->
                new UsernameNotFoundException(username));
    }
}
