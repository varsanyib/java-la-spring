package hu.gamf.javalabproject.repositories;

import hu.gamf.javalabproject.models.County;
import org.springframework.data.repository.CrudRepository;

public interface CountyInterfaceRepo extends CrudRepository<County, String> {
}
