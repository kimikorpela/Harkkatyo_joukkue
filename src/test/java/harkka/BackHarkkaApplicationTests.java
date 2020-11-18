package harkka;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import harkka.web.PelaajaController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BackHarkkaApplicationTests {

	@Autowired
	private PelaajaController controller;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		}
}