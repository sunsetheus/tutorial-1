package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import id.ac.ui.cs.advprog.eshop.controller.ProductController;

@SpringBootTest
class EshopApplicationTests {

	@Autowired
	private ProductController productController;

	@Test
	void contextLoads() {
		EshopApplication.main(new String[]{});
		assertThat(productController).isNotNull();
	}

}
