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

        // Create Edge options
        EdgeOptions options = new EdgeOptions();

        // ✅ IMPORTANT: Run in headless mode for Jenkins
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new EdgeDriver(options);

        try {

            driver.get("file://" + System.getProperty("user.dir")
                    + "/src/main/webapp/index.html");

            driver.findElement(By.id("num1")).sendKeys("15");
            driver.findElement(By.id("num2")).sendKeys("25");

            driver.findElement(By.tagName("button")).click();

            Thread.sleep(2000);

            String result = driver.findElement(By.id("result")).getText();

            Assert.assertTrue(result.contains("40"),
                    "Expected result to contain 40 but got: " + result);

        } finally {
            driver.quit();
        }
    }
}
