package com.saucedemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @Test
    public void saucedemoLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        username.sendKeys("standard_user");
        Assert.assertTrue(username.isDisplayed());

        Thread.sleep(1000);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret_sauce");
        Assert.assertTrue(password.isDisplayed());

        Thread.sleep(1000);

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        Assert.assertTrue(signInButton.isEnabled());
        signInButton.click();

        Thread.sleep(1000);

        driver.quit();


    }


}
