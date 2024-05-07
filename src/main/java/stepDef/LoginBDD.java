package stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import config.env_target;
import java.time.Duration;


public class LoginBDD extends env_target {


    @Given("User is on Login Page")
    public void userIsOnLoginPage() {

        //Set web driver location path (download the driver according to your OS)
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        //Maximize the driver window
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Set the base URL
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }


    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click Login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }


    @Then("User will redirect to Products page")
    public void userWillRedirectToProductsPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );

        driver.quit();
    }

    @When("User fill wrong username and password")
    public void userFillWrongUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("joao");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @When("User fill username and wrong password")
    public void userFillUsernameAndWrongPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
    }

    @Then("An error message will appear")
    public void anErrorMessageWillAppear() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'error-message')]//h3[@data-test='error']"))
        );

        driver.quit();

    }
}