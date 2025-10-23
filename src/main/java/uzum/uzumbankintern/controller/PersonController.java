package uzum.uzumbankintern.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzum.uzumbankintern.dto.PersonDto;
import uzum.uzumbankintern.dto.PersonWithCars;
import uzum.uzumbankintern.dto.Statistics;
import uzum.uzumbankintern.service.PersonService;


@Tag(name = "Person Controller", description = "APIs for managing persons")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @Operation(summary = "Create a new person", description = "Creates a new person with the provided details.")
    @PostMapping("/person")
    public ResponseEntity<Object> createPerson(@Valid @RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @Operation(summary = "Get person with cars")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved person with cars")
    @GetMapping("/personwithcar")
    public ResponseEntity<PersonWithCars> getPersonWithCars(
            @RequestParam("personId") Long personId) {
        return personService.getPersonWithCars(personId);
    }

    @Operation(summary = "Clear all persons and cars")
    @DeleteMapping("/clear")
    public ResponseEntity<Object> clearPersonsAndCars() {
        return personService.clearPersonsAndCars();
    }

    @Operation(summary = "Get statistics", description = "Retrieves statistics about persons and cars.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics")
    })
    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getStatistics() {
        return personService.getStatistics();
    }

    // Extra method to clear person by id
    @Operation(summary = "Clear person by ID", description = "Deletes a person by their ID.")
    @DeleteMapping("/person/clear/{id}")
    public String clearPersonById(@PathVariable("id") Long id) {
        return personService.clearPersonById(id);
    }

}
