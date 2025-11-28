package hu.gamf.javalabproject.repositories;

import hu.gamf.javalabproject.models.Town;
import org.springframework.data.repository.CrudRepository;

public interface TownInterfaceRepo extends CrudRepository<Town, String> {
}
