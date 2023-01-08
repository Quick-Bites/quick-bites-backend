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

            userService.addRoleToUser("kaan", "ROLE_ADMIN");
            userService.addRoleToUser("can", "ROLE_ADMIN");
            userService.addRoleToUser("roz", "ROLE_ADMIN");

            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Express", "Istanbul", "Taksim Square 1", "555123456", "Sushi", "4.8", 50, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Palace", "Istanbul", "Bosphorus Bridge 2", "555234567", "Pizza", "4.9", 60, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Barn", "Istanbul", "Galata Tower 3", "555345098", "Hamburger", "4.7", 70, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Sam's", "Izmir", "Cultural Park 4", "555456789", "Sushi", "4.6", 80, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Paradise", "Izmir", "Clock Tower 5", "555567890", "Pizza", "4.5", 90, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Brothers", "Izmir", "Aga Mosque 6", "555678901", "Hamburger", "4.4", 100, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Supreme", "Ankara", "Roman Baths 7", "555789012", "Sushi", "4.3", 110, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Pit", "Ankara", "Citadel 8", "555891012", "Pizza", "4.2", 120, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Bonanza", "Ankara", "Anitkabir 9", "555901234", "Hamburger", "4.1", 130, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Stop", "Istanbul", "Grand Bazaar 10", "555098765", "Sushi", "4.0", 140, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Planet", "Istanbul", "Galata Tower 11", "555198765", "Pizza", "3.9", 150, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Bonanza", "Istanbul", "Taksim Square 12", "555298765", "Hamburger", "3.8", 160, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Station", "Izmir", "Cultural Park 13", "555398765", "Sushi", "3.7", 170, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi House", "Istanbul", "Taksim Square 14", "555498765", "Sushi", "3.6", 180, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Plaza", "Istanbul", "Bosphorus Bridge 15", "555598765", "Pizza", "3.5", 190, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger BBQ", "Istanbul", "Galata Tower 16", "555698765", "Hamburger", "3.4", 200, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Spot", "Izmir", "Cultural Park 17", "555798765", "Sushi", "3.3", 210, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Point", "Izmir", "Clock Tower 18", "555898765", "Pizza", "3.2", 220, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Bowl", "Izmir", "Aga Mosque 19", "555998765", "Hamburger", "3.1", 230, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Summit", "Ankara", "Roman Baths 20", "555098765", "Sushi", "3.0", 240, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Paradise", "Ankara", "Citadel 21", "555198765", "Pizza", "2.9", 250, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Bar", "Ankara", "Anitkabir 22", "555298765", "Hamburger", "2.8", 260, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Sushi", "Istanbul", "Taksim Square 23", "555398765", "Sushi", "2.7", 270, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Palace", "Istanbul", "Bosphorus Bridge 24", "555498765", "Pizza", "2.6", 280, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Barn", "Istanbul", "Galata Tower 25", "555598765", "Hamburger", "2.5", 290, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Sam's", "Izmir", "Cultural Park 26", "555698765", "Sushi", "2.4", 300, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Paradise", "Izmir", "Clock Tower 27", "555798765", "Pizza", "2.3", 310, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Brothers", "Izmir", "Aga Mosque 28", "555898765", "Hamburger", "2.2", 320, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Supreme", "Ankara", "Roman Baths 29", "555998765", "Sushi", "2.1", 330, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Pizza Pit", "Ankara", "Citadel 30", "555098765", "Pizza", "2.0", 340, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Burger Bonanza", "Ankara", "Anitkabir 33", "555198765", "Hamburger", "1.9", 350, new ArrayList<>()));
            restaurantService.saveRestaurant(new Restaurant(null, "Sushi Stop", "Istanbul", "Grand Bazaar 32", "555298765", "Sushi", "1.8", 360, new ArrayList<>()));
        };
    }
}
