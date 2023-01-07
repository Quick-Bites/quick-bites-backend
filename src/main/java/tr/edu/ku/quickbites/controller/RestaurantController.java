package tr.edu.ku.quickbites.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.ku.quickbites.dto.ReservationDto;
import tr.edu.ku.quickbites.dto.RestaurantNameDto;
import tr.edu.ku.quickbites.entity.Restaurant;
import tr.edu.ku.quickbites.response.CategoryResponse;
import tr.edu.ku.quickbites.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurant/categories")
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok().body(List.of(
                CategoryResponse.builder()
                        .name("Burger")
                        .build(),
                CategoryResponse.builder()
                        .name("Pizza")
                        .build(),
                CategoryResponse.builder()
                        .name("Sushi")
                        .build()));
    }

    @GetMapping("/restaurant/located-city/{city}")
    public ResponseEntity<List<Restaurant>> getRestaurantsWithCity(@PathVariable String city) {
        return ResponseEntity.ok().body(restaurantService.findRestaurantsByLocatedCity(city));
    }

    @PostMapping("/restaurant/details")
    public ResponseEntity<List<Restaurant>> getRestaurantDetail(@RequestBody RestaurantNameDto restaurantNameDto) {
        return ResponseEntity.ok().body(restaurantService.findRestaurantByNameAndLocatedCity(restaurantNameDto.getRestaurantName(), restaurantNameDto.getLocatedCity()));
    }

    @PostMapping("/restaurant/make-reservation")
    public ResponseEntity<?> makeReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok().body(restaurantService.makeReservation(reservationDto.getRestaurantId(), reservationDto.getStartTime(), reservationDto.getEndTime(), reservationDto.getNumGuests()));
    }

    @GetMapping("/restaurant/category/{category}/city/{city}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCategoryAndCity(@PathVariable String category, @PathVariable String city) {
        return ResponseEntity.ok().body(restaurantService.findRestaurantByCategoryAndLocatedCity(category, city));
    }
}
