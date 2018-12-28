package me.skornel.tortalefon;

import com.sun.javafx.PlatformUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@EnableScheduling
public class TortalefonApplication {

	public static void main(String[] args) throws IOException, URISyntaxException {
		loadLibrary();

		SpringApplication.run(TortalefonApplication.class, args);
	}

	private static void loadLibrary() throws IOException{
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("win")){
			System.out.println("Loading windows library...");
			File tmpDir = new File(System.getProperty("java.io.tmpdir"), "pjsua2.dll");
			if(!tmpDir.exists()){
				InputStream resource = TortalefonApplication.class.getClassLoader().getResourceAsStream("lib/pjsua2.dll");
				System.out.println("creating new dll \n" + tmpDir.getAbsolutePath());
				Files.copy(resource, Paths.get(tmpDir.getPath()));
			}
			System.load(tmpDir.getAbsolutePath());
		}else {
			System.out.println("No prebuilt library found... forcing java loadLibrary for pjsua2...");
			System.loadLibrary("pjsua2");
		}
	}

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	@Bean
	public PasswordEncoder encoder(){
		return new BCryptPasswordEncoder(8);
	}

}
