package tr.edu.ku.quickbites;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tr.edu.ku.quickbites.entity.Restaurant;
import tr.edu.ku.quickbites.entity.Role;
import tr.edu.ku.quickbites.entity.User;
import tr.edu.ku.quickbites.service.RestaurantService;
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
    CommandLineRunner run(UserService userService, RestaurantService restaurantService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Kaan Turkmen", "kaan", "kaan", "kt@gmail.com", "12345", "N/A", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Can Usluel", "can", "can", "cu@gmail.com", "12345", "N/A", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Sefa Degirmenci", "roz", "roz", "sd@gmail.com", "12345", "N/A", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Wololo Const", "wololo", "wololo", "wololo@gmail.com", "12345", "N/A", new ArrayList<>(), new ArrayList<>()));

			userService.addRoleToUser("kaan", "ROLE_ADMIN");
			userService.addRoleToUser("can", "ROLE_ADMIN");
			userService.addRoleToUser("roz", "ROLE_ADMIN");
			userService.addRoleToUser("wololo", "ROLE_USER");

			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant1", "Istanbul", "Koc Uni 2 35", "312123423", "Sushi", "4.9", 10, new ArrayList<>()));
			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant2", "Istanbul", "Koc Uni 2 34", "312123423", "Pizza", "4.3", 10, new ArrayList<>()));

			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant3", "Izmir", "Koc Uni 2 33", "312123423", "Burger", "2.4", 10, new ArrayList<>()));
			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant4", "Izmir", "Koc Uni 2 32", "312123413", "Burger", "3.6", 10, new ArrayList<>()));
			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant5", "Izmir", "Koc Uni 2 31", "322123423", "Pizza", "4.2", 10, new ArrayList<>()));

			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant6", "Ankara", "Koc Uni 2 30", "212123423", "Sushi", "3.2", 10, new ArrayList<>()));
			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant7", "Ankara", "Koc Uni 2 29", "342123423", "Sushi", "3.7", 10, new ArrayList<>()));
			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant8", "Ankara", "Koc Uni 2 28", "312623423", "Pizza", "4.5", 10, new ArrayList<>()));
			restaurantService.saveRestaurant(new Restaurant(null, "Restaurant9", "Ankara", "Koc Uni 2 27", "315123423", "Burger", "2.8", 10, new ArrayList<>()));

		};
	}
}
