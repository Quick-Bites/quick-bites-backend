package tr.edu.ku.quickbites.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String locatedCity;

    private String address;

    private String phoneNumber;

    private String category;

    private String rating;

    private Integer capacity;

    @OneToMany
    private List<Reservation> reservations = new ArrayList<>();
}
