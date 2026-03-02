import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionTest {

    @Test
    public void testAddition() throws InterruptedException {

        // Set path to msedgedriver
        System.setProperty("webdriver.edge.driver",
                "C:\\drivers\\msedgedriver.exe");

        // Create Edge options (NO headless)
        EdgeOptions options = new EdgeOptions();

        // Launch Edge browser visibly
        WebDriver driver = new EdgeDriver(options);

        try {

            // Maximize window
            driver.manage().window().maximize();

            // Load local HTML file dynamically
            String filePath = "file://" + System.getProperty("user.dir")
                    + "/src/main/webapp/index.html";

            driver.get(filePath);

            // Enter numbers
            driver.findElement(By.id("num1")).sendKeys("15");
            driver.findElement(By.id("num2")).sendKeys("25");

            // Click Add button
            driver.findElement(By.tagName("button")).click();

            // Wait 3 seconds so you can see result
            Thread.sleep(3000);

            // Get result text
            String result = driver.findElement(By.id("result")).getText();

            // Verify result contains 40
            Assert.assertTrue(result.contains("40"));

        } finally {

            // Wait 2 seconds before closing (optional)
            Thread.sleep(2000);

            driver.quit();
        }
    }
}