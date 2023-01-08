package tr.edu.ku.quickbites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ku.quickbites.entity.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findRestaurantsByLocatedCity(String locatedCity);

    List<Restaurant> findRestaurantsByNameAndLocatedCity(String restaurantName, String locatedCity);

    List<Restaurant> findRestaurantsByCategoryAndLocatedCity(String category, String locatedCity);

    Restaurant findRestaurantById(Long restaurantId);
}
