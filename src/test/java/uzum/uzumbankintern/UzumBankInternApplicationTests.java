package uzum.uzumbankintern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uzum.uzumbankintern.controller.CarController;
import uzum.uzumbankintern.controller.PersonController;
import uzum.uzumbankintern.dto.CarDto;
import uzum.uzumbankintern.dto.PersonDto;
import uzum.uzumbankintern.service.CarService;
import uzum.uzumbankintern.service.PersonService;

@SpringBootTest
class UzumBankInternApplicationTests {
    @Autowired
    private CarService carService;
    @Autowired
    private PersonService personService;

    @Test
    void contextLoads() {
    }

    @Test
    void createPerson() {
        personService.createPerson(
                new PersonDto("John-Doe", "10.10.2000"));
    }

    @Test
    void checkAgeLimit() {
        personService.checkAgeLimit(23L);
    }

    @Test
    void getPersonWithCars() {
        personService.getPersonWithCars(23L);
    }

    @Test
    void clearPersonsAndCars() {
        personService.clearPersonsAndCars();
    }

    @Test
    void getStatistics() {
        personService.getStatistics();
    }

    @Test
    void clearPersonById() {
        personService.clearPersonById(23L);
    }


    @Test
    void addCar() {
        carService.addCar(
                new CarDto(
                        "Chevrolet-Damas", 10, 23L));
    }

    @Test
    void checkHorsePower() {
        carService.checkHorsePower(5);
    }

    @Test
    void clearCarById() {
        carService.clearCarById(23L);
    }


}
