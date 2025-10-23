package uzum.uzumbankintern.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uzum.uzumbankintern.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByOwnerIdAndIsActiveTrue(Long personId);

    @Query(value = "SELECT COUNT(*) FROM cars WHERE is_active = true", nativeQuery = true)
    Long getCount();
}
