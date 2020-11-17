package harkka.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelipaikkaRepo extends CrudRepository<Pelipaikka, Long> {
	List<Pelipaikka> findByName(String name);
}
