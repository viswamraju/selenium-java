package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/vbogaraj/Documents/practice/java_workspace/java-learning/seleniumTests/src/test/resources/chromedriver");
        // initialize chrome driver
        driver = new ChromeDriver();
        driver.get("http://guidebook.seleniumacademy.com/Window.html");
    }

    @Test
    public void windowHandleTest() throws InterruptedException{
        Thread.sleep(2000);
        String firstWindow = driver.getWindowHandle();
        System.out.println("First window handle is " + firstWindow);
        WebElement link = driver.findElement(By.linkText("Google Search"));
        link.click();
        Thread.sleep(10000);
        String secondWindow = driver.getWindowHandle();
        System.out.println("Second Window Handle is: " + secondWindow);
        System.out.println("Number of window handles so far " + driver.getWindowHandles().size());
        driver.switchTo().window(firstWindow);
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown() {
        // quits browser
        driver.quit();
    }

}
