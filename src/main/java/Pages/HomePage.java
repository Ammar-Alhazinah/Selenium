package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By userIdTextBox = By.name("uid");
    private By passwordTextBox = By.name("password");
    private By loginButton = By.name("btnLogin");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserId(String userId){
        driver.findElement(userIdTextBox).sendKeys(userId);
    }
    public void setPassword(String password){
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginButton).click();

    }

}
