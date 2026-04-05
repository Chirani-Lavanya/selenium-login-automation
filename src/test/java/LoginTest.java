import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void testLogin() throws InterruptedException {

        // Open browser
        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://the-internet.herokuapp.com/login");

        // Maximize window (optional but better)
        driver.manage().window().maximize();

        // Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Click login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Get success message
        String message = driver.findElement(By.id("flash")).getText();

        // Validate result
        Assert.assertTrue(message.contains("You logged into a secure area!"));

        // Print in console
        System.out.println("Login test passed");

        // Wait 5 seconds so you can see result
        Thread.sleep(5000);

        // Close browser
        driver.quit();
    }
}