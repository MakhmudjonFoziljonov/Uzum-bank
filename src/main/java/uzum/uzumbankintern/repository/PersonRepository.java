package uzum.uzumbankintern.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uzum.uzumbankintern.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query(value = "SELECT COUNT(*) FROM persons WHERE is_active = true", nativeQuery = true)
    Long getCount();
}
