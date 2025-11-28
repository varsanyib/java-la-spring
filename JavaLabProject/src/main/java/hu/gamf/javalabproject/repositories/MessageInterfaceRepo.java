package hu.gamf.javalabproject.repositories;

import hu.gamf.javalabproject.models.MessageDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageInterfaceRepo extends CrudRepository<MessageDTO, Number> {
    @Query(value = "SELECT * FROM messages ORDER BY created_at DESC", nativeQuery = true)
    Iterable<MessageDTO> findAllOrderByCreatedAtDesc();
}
