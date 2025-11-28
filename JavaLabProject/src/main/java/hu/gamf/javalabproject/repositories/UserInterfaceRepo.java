package hu.gamf.javalabproject.repositories;

import hu.gamf.javalabproject.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserInterfaceRepo extends CrudRepository<User, Number> {
    Optional<User> findByUsername(String username);
}
