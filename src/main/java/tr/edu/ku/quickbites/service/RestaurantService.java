package tr.edu.ku.quickbites.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.edu.ku.quickbites.entity.Reservation;
import tr.edu.ku.quickbites.entity.Restaurant;
import tr.edu.ku.quickbites.entity.User;
import tr.edu.ku.quickbites.repository.ReservationRepository;
import tr.edu.ku.quickbites.repository.RestaurantRepository;
import tr.edu.ku.quickbites.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findRestaurantsByLocatedCity(String locatedCity) {
        return restaurantRepository.findRestaurantsByLocatedCity(locatedCity);
    }

    public List<Restaurant> findRestaurantByNameAndLocatedCity(String restaurantName, String locatedCity) {
        return restaurantRepository.findRestaurantsByNameAndLocatedCity(restaurantName, locatedCity);
    }

    public boolean makeReservation(String username, Long restaurantId, LocalDateTime startTime, LocalDateTime endTime, int numGuests) {

        Restaurant restaurant = restaurantRepository.getById(restaurantId);
        User user = userRepository.findByUsername(username);

        if (restaurant.getReservations().size() + 1 > restaurant.getCapacity()) {
            return false;
        }

        if (numGuests > 4) {
            return false;
        }

        int activeReservations = (int) restaurant.getReservations().stream()
                .filter(reservation -> !reservation.getStartTime().isAfter(endTime) && !reservation.getEndTime().isBefore(startTime))
                .count();

        if (activeReservations > restaurant.getCapacity()) {
            return false;
        }

        Reservation reservation = new Reservation(null, startTime, endTime, numGuests);

        restaurant.getReservations().add(reservation);
        user.getReservations().add(reservation);

        reservationRepository.save(reservation);

        return true;
    }

    public List<Restaurant> findRestaurantByCategoryAndLocatedCity(String category, String locatedCity) {
        return restaurantRepository.findRestaurantsByCategoryAndLocatedCity(category, locatedCity);
    }

}