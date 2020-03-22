package com.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/vbogaraj/Documents/practice/java_workspace/java-learning/seleniumTests/src/test/resources/chromedriver");
        // initialize chrome driver
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./target/screenshot.png"));
    }

    @Test
    public void takeScreenShot(){

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
