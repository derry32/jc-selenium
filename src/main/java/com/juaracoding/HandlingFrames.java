package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrames {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        js.executeScript("window.scrollBy(0,300)");

        //switch to frames
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);

        //sample Heading
        String txtTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(txtTitle);

        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        //default content
        driver.switchTo().defaultContent();


        delay(3);

        driver.quit();
        System.out.println("Exit Browser");
    }
    public static void delay(long detik) {
        try {
            Thread.sleep(detik + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}