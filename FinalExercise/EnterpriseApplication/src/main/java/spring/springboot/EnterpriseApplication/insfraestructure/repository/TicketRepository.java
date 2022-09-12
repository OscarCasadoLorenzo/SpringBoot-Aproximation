package spring.springboot.WebBackend.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.WebBackend.domain.TicketEntity;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
}
