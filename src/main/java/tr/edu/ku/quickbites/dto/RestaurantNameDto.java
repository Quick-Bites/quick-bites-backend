package tr.edu.ku.quickbites.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantNameDto {
    private String restaurantName;
    private String locatedCity;
}
