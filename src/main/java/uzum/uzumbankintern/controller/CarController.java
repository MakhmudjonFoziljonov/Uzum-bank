package uzum.uzumbankintern.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzum.uzumbankintern.dto.CarDto;
import uzum.uzumbankintern.service.CarService;

@Tag(name = "Car Controller", description = "APIs for managing cars")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @Operation(summary = "Add a new car", description = "Adds a new car to the system with the provided details.")
    @ApiResponse(responseCode = "200", description = "Car added successfully")
    @PostMapping("/car")
    public ResponseEntity<Object> addCar(@Valid @RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.addCar(carDto));
    }


    //Extra method to clear car by id
    @Operation(summary = "Clear car by ID", description = "Clears the car information for the specified car ID.")
    @ApiResponse(responseCode = "200", description = "Car cleared successfully")
    @DeleteMapping("/car/clear/{id}")
    public String clearCarById(@PathVariable("id") Long id) {
        return carService.clearCarById(id);
    }

}
