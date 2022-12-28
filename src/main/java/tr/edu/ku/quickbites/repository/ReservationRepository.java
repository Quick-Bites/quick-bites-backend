package tr.edu.ku.quickbites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ku.quickbites.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
