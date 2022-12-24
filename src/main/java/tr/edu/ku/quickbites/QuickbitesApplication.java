package tr.edu.ku.quickbites;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tr.edu.ku.quickbites.entity.Role;
import tr.edu.ku.quickbites.entity.User;
import tr.edu.ku.quickbites.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class QuickbitesApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickbitesApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
    CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Kaan Turkmen", "kaan", "kaan", "kt@gmail.com", "12345", "N/A", new ArrayList<>()));
			userService.saveUser(new User(null, "Can Usluel", "can", "can", "cu@gmail.com", "12345", "N/A", new ArrayList<>()));
			userService.saveUser(new User(null, "Sefa Degirmenci", "roz", "roz", "sd@gmail.com", "12345", "N/A", new ArrayList<>()));
			userService.saveUser(new User(null, "Wololo Const", "wololo", "wololo", "wololo@gmail.com", "12345", "N/A", new ArrayList<>()));

			userService.addRoleToUser("kaan", "ROLE_ADMIN");
			userService.addRoleToUser("can", "ROLE_ADMIN");
			userService.addRoleToUser("roz", "ROLE_ADMIN");
			userService.addRoleToUser("wololo", "ROLE_USER");
		};
	}
}
