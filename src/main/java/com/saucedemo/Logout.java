package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout {

    @Test
    public void saucedemoLogout() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("standard_user");

        Thread.sleep(1000);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys("secret_sauce");

        Thread.sleep(1000);

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        Assert.assertTrue(signInButton.isEnabled());
        signInButton.click();
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String homePageText = "Products";
        Assert.assertTrue(homePage.isDisplayed());
        Assert.assertTrue(homePage.getText().contains(homePageText));

        Thread.sleep(1000);

        WebElement menu = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        Assert.assertTrue(menu.isEnabled());
        menu.click();

        Thread.sleep(750);

        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        Assert.assertTrue(logoutButton.isEnabled());
        logoutButton.click();

        Thread.sleep(1000);

        driver.quit();
    }
}
