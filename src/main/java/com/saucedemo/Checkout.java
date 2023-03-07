package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout {

    @Test
    public void checkout() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        username.sendKeys("standard_user");
        Assert.assertTrue(username.isDisplayed());

        Thread.sleep(500);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret_sauce");
        Assert.assertTrue(password.isDisplayed());

        Thread.sleep(500);

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        Assert.assertTrue(signInButton.isEnabled());
        signInButton.click();

        Thread.sleep(1000);

        WebElement openProductPage = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]"));
        Assert.assertTrue(openProductPage.isDisplayed());
        openProductPage.click();

        Thread.sleep(1000);

        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        Assert.assertTrue(cartButton.isDisplayed());
        cartButton.click();

        Thread.sleep(1000);

        WebElement viewCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        Assert.assertTrue(viewCart.isEnabled());
        viewCart.click();

        Thread.sleep(1000);

        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        Assert.assertTrue(checkoutButton.isEnabled());
        checkoutButton.click();

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        firstName.sendKeys("Catalin");
        Assert.assertTrue(firstName.isDisplayed());
        Thread.sleep(500);
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastName.sendKeys("Dobre");
        Assert.assertTrue(lastName.isDisplayed());
        Thread.sleep(500);
        WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        zipCode.sendKeys("408136");
        Assert.assertTrue(zipCode.isDisplayed());
        Thread.sleep(500);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        Assert.assertTrue(continueButton.isEnabled());
        continueButton.click();

        Thread.sleep(3000);

        WebElement checkoutOverview = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        Assert.assertTrue(checkoutOverview.isEnabled());
        checkoutOverview.click();

        Thread.sleep(2000);

        driver.quit();
    }
}
