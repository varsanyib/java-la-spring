package hu.gamf.javalabproject.repositories;

import hu.gamf.javalabproject.models.Radio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RadioInterfaceRepo extends CrudRepository<Radio, Number> {
    @Query(value = "SELECT * FROM radios ORDER BY created_at DESC LIMIT 1", nativeQuery = true)
    Radio findNewestRadio();
}
