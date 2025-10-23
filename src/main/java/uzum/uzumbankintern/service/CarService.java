package uzum.uzumbankintern.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzum.uzumbankintern.dto.CarDto;
import uzum.uzumbankintern.i18n.ResourceBundleService;
import uzum.uzumbankintern.model.Car;
import uzum.uzumbankintern.repository.CarRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {
    private final CarRepository repo;
    private final PersonService personService;
    private final ResourceBundleService resourceBundleService;

    @Transactional
    public ResponseEntity<Object> addCar(CarDto carDto) {
        var car = new Car();
        car.setModel(carDto.model());
        boolean bool = personService.checkAgeLimit(carDto.ownerId());
        if (bool) {
            car.setOwnerId(carDto.ownerId());
        } else {
            log.error("Attempted to add car for underage owner with ID: {}", carDto.ownerId());
            throw new IllegalArgumentException("Owner must be at least 18 years old to register a car");
        }

        var horsePower = checkHorsePower(carDto.horsePower());
        car.setHorsePower(horsePower);
        repo.save(car);
        return ResponseEntity.ok().build();
    }

    public Integer checkHorsePower(Integer horsePower) {
        if (horsePower <= 0) {
            log.error("Invalid horse power value: {}", horsePower);
            throw new IllegalArgumentException("Horse power must be greater than zero");
        }
        return horsePower;
    }

    // Extra method to clear person by id
    public String clearCarById(Long id) {
        var car = repo.findById(id).orElse(null);
        if (car == null) return "Car not found";
        car.setIsActive(Boolean.FALSE);
        repo.save(car);
        return "Car deleted successfully";
    }

}
