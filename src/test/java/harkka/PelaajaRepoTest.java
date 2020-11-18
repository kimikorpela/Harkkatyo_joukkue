package harkka;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import harkka.model.Pelaaja;
import harkka.model.PelaajaRepo;
import harkka.model.Pelipaikka;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PelaajaRepoTest {

	@Autowired
	private PelaajaRepo pRepo;

	@Test(expected = NullPointerException.class)
	public void findByLastnameShouldReturnStudent() {
		List<Pelaaja> pelaajat = pRepo.findByNimi("Pekka Pakki");
		assertThat(pelaajat).hasSize(1);
		assertThat(pelaajat.get(0).getNimi()).isEqualTo("Pekka Pakki");
	}

	@Test(expected = NullPointerException.class)
	public void PitaisiLuodaUusiPelaaja() {
		Pelaaja pelaaja = new Pelaaja("Yari Curry", 15, new Pelipaikka("Valmentaja"));
		pRepo.save(pelaaja);
		assertThat(pelaaja.getId()).isNotNull();
	}

}