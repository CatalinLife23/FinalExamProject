package com.aliexpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishList {
    WebDriver driver;

    @Test
    public void wishList(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://aliexpress.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement search = driver.findElement(By.id("search-key"));
        search.sendKeys("Global Version Xiaomi Mi 360° Home Security Camera 2K Pro 1296p HD WiFi Night Vision Smart Full Colour AI Human detection Came");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"form-searchbar\"]/div[1]/input"));
        searchButton.click();

        WebElement productSelect = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div[3]/a[1]"));
        productSelect.click();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement wishListButton = driver.findElement(By.cssSelector("#root > div > div.product-main > div > div.product-info > div.product-action > span.add-wishlist-wrap > div"));
        Assert.assertTrue(wishListButton.isDisplayed());
        wishListButton.click();

    }
}
