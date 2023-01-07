package tr.edu.ku.quickbites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.edu.ku.quickbites.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT restaurant_id FROM restaurant_reservations as r WHERE reservations_id = ?1", nativeQuery = true)
    Long getRestaurantIdFromReservationId(Long reservationId);
}
