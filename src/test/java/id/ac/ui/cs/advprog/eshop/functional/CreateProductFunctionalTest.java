package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUpTest(){
        baseUrl=String.format("%s:%d",testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");
        String pageTitle = driver.getTitle();
        assertEquals("ADV: Product List", pageTitle);
    }
    @Test
    void createButton_isWork(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");
        driver.findElement(By.id("create-product-button")).click();
        String pageTitle = driver.getTitle();
        assertEquals("ADV: Create New Product", pageTitle);
    }

    @Test
    void createForm_isWork(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");

        String productName = "Sampo Lana del Rey";
        driver.findElement(By.id("nameInput")).sendKeys(productName);
        driver.findElement(By.id("quantityInput")).clear();
        driver.findElement(By.id("quantityInput")).sendKeys("100");

        driver.findElement(By.id("submit-button")).click();
        String pageTitle = driver.getTitle();
        assertEquals("ADV: Product List", pageTitle);

        WebElement productNameDisplay = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        WebElement productQuantityDisplay = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));

        assertEquals(productName, productNameDisplay.getText());
        assertEquals("100", productQuantityDisplay.getText());
    }
}