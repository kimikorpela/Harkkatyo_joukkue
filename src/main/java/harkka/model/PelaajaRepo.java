package harkka.model;

	import java.util.List;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface PelaajaRepo extends CrudRepository<Pelaaja, Long> {
		List<Pelaaja> findByNimi(String nimi);
}

