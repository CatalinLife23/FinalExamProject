package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShoppingCart {
    WebDriver driver;

    @Test
    public void shoppingCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret_sauce");

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        signInButton.click();

        Thread.sleep(1000);

        WebElement openProductPage = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]"));
        openProductPage.click();

        Thread.sleep(1000);

        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        cartButton.click();

        WebElement viewCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        viewCart.click();

        Thread.sleep(1000);

        driver.quit();



    }
}
