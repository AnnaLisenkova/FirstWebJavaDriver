package com.spbstu.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SimpleTest extends Init {

    @Test
    public void test1()
    {
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("spbstu" + Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='res']//div[@class='g']//cite"));
        String expected = "spbstu";
        Assert.assertTrue(elements.stream().anyMatch(e -> e.getText().contains(expected)));
    }

    @Test
    public void test2()
    {
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("fontanka" + Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='res']//div[@class='g']//cite"));
        String expected = "fontanka";
        Assert.assertTrue(elements.stream().anyMatch(e -> e.getText().contains(expected)));
    }

}