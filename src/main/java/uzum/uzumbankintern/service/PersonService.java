package uzum.uzumbankintern.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzum.uzumbankintern.dto.PersonDto;
import uzum.uzumbankintern.dto.PersonWithCars;
import uzum.uzumbankintern.model.Car;
import uzum.uzumbankintern.model.Person;
import uzum.uzumbankintern.dto.Statistics;
import uzum.uzumbankintern.repository.CarRepository;
import uzum.uzumbankintern.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepo;
    private final CarRepository carRepo;

    @Transactional
    public ResponseEntity<Object> createPerson(PersonDto personDto) {
        var person = new Person();
        person.setName(personDto.name());
        person.setBirthDate(personDto.birthDate());
        personRepo.save(person);
        return ResponseEntity.ok().build();
    }

    public boolean checkAgeLimit(Long ownerId) {
        var owner = personRepo.findById(ownerId).orElseThrow(
                () -> new IllegalArgumentException("Owner not found"));
        var birthDate = owner.getBirthDate();
        var substring = birthDate.substring(birthDate.length() - 4);
        int birthYear = Integer.parseInt(substring);
        int year = LocalDate.now().getYear();

        return year - birthYear >= 18;
    }

    public ResponseEntity<PersonWithCars> getPersonWithCars(Long personId) {
        Optional<Person> personById = personRepo.findById(personId);
        if (personById.isEmpty() || personById.get().getIsActive().equals(Boolean.FALSE)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            List<Car> cars = carRepo.findByOwnerIdAndIsActiveTrue(personId);
            var personWithCars = new PersonWithCars(personById.get(), cars);
            return ResponseEntity.ok(personWithCars);
        }
    }

    public ResponseEntity<Object> clearPersonsAndCars() {
        personRepo.deleteAll();
        carRepo.deleteAll();
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Statistics> getStatistics() {
        Long totalPersons = personRepo.getCount();
        Long totalCars = carRepo.getCount();
        var statistics = new Statistics();
        statistics.setCarCount(totalCars);
        statistics.setPersonCount(totalPersons);
        // I do not fully understand the requirement of unique vendors.
        statistics.setUniqueVendorCount(totalPersons + totalCars);
        return ResponseEntity.ok(statistics);
    }

    // Extra method to clear person by id
    public String clearPersonById(Long id) {
        var person = personRepo.findById(id).orElse(null);
        if (person == null) return "Person not found";
        person.setIsActive(Boolean.FALSE);
        personRepo.save(person);
        return "Person deleted successfully";
    }
}
