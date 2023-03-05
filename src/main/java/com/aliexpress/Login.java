package com.aliexpress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @Test
    public void aliexpressLogin(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.aliexpress.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement email = driver.findElement(By.xpath("//*[@id=\"fm-login-id\"]"));
        email.sendKeys("catalingamer93p@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"fm-login-password\"]"));
        password.sendKeys("AutomationTest");
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/button[2]"));
        signInButton.click();
        Assert.assertTrue(!signInButton.isSelected());


    }


}
