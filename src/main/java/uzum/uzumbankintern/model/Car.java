package uzum.uzumbankintern.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ownerId;

    private String model;
    private Integer horsePower;

    private Boolean isActive = Boolean.TRUE;
}
