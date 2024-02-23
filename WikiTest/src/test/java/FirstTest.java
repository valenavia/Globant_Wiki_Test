//package dev.selenium.getting_started;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class FirstTest {

        @Test
        public void eightComponents() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://wikipedia.org");

            String title = driver.getTitle();
            assertEquals("Wikipedia", title);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            WebElement textBox = driver.findElement(By.id("searchInput"));
            WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));

            textBox.sendKeys("Globant");
            submitButton.click();

            String titleMicrosoft = driver.getTitle();
            assertEquals("Globant - Wikipedia, la enciclopedia libre", titleMicrosoft);

            // Obtener todos los enlaces ancla
            List<WebElement> anchors = driver.findElements(By.tagName("a"));

            // Imprimir el texto de cada enlace
            for (WebElement anchor : anchors) {
                System.out.println("hola " + anchor.getText());
            }
            driver.quit();
        }
    }