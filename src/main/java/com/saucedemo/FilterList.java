package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterList {

    @Test
    public void filterDropdown() throws InterruptedException {

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

        WebElement filterDropdown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
        Assert.assertTrue(filterDropdown.isDisplayed());
        filterDropdown.click();
        Thread.sleep(1000);
        WebElement priceLowToHighFilter = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]"));
        Assert.assertTrue(priceLowToHighFilter.isEnabled());
        priceLowToHighFilter.click();

        Thread.sleep(1000);

        driver.quit();
    }
}
