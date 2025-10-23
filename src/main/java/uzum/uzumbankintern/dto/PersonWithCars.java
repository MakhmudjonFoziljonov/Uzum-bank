package uzum.uzumbankintern.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uzum.uzumbankintern.model.Car;
import uzum.uzumbankintern.model.Person;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonWithCars {
    private Person person;
    private List<Car> cars;
}
