package harkka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import harkka.model.Pelaaja;
import harkka.model.PelaajaRepo;
import harkka.model.Pelipaikka;
import harkka.model.PelipaikkaRepo;
import harkka.model.User;
import harkka.model.UserRepo;

@EnableJpaRepositories
@SpringBootApplication
public class BackHarkkaApplication {
	private static final Logger log = LoggerFactory.getLogger(BackHarkkaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackHarkkaApplication.class, args);
	}

	@Bean
	public CommandLineRunner pelaajaDemo(PelaajaRepo prepository, PelipaikkaRepo pprepository,
			UserRepo urepository) {
		return (args) -> {

			log.info("save a couple players");
			pprepository.save(new Pelipaikka("Hyökkääjä"));
			pprepository.save(new Pelipaikka("Puolustaja"));
			pprepository.save(new Pelipaikka("Maalivahti"));

			prepository.save(new Pelaaja("Harri Hyökkääjä", 99, pprepository.findByName("Hyökkääjä").get(0)));
			prepository.save(new Pelaaja("Pekka Pakki", 4, pprepository.findByName("Puolustaja").get(0)));
			prepository.save(new Pelaaja("Matti Molari", 35, pprepository.findByName("Maalivahti").get(0)));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.deleteAll();
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all players");
			for (Pelaaja pelaaja : prepository.findAll()) {
				log.info(pelaaja.toString());
			}
		};
	}

}
