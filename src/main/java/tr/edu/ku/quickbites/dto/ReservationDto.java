package tr.edu.ku.quickbites.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReservationDto {
    private Long restaurantId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer numGuests;
}
