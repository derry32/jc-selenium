package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandingAlert {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        //Web Scraping

        js.executeScript("window.scrollBy(0,300)");
        String txtTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(txtTitle);

        driver.findElement(By.id("alertButton")).click();
        delay(1);
        driver.switchTo().alert().accept();
        System.out.println("Alert Button");

        driver.findElement(By.id("timerAlertButton")).click();
        delay(5);
        try {
            driver.switchTo().alert().accept();
            System.out.println("Timer Alert Button");
        } catch (Exception e){
            e.printStackTrace();
        }

        driver.findElement(By.id("confirmButton")).click();
        delay(2);
        driver.switchTo().alert().dismiss();
        System.out.println("Confirm Alert Button");

        driver.findElement(By.id("promtButton")).click();
        delay(2);
        driver.switchTo().alert().sendKeys("Indonesia");
        driver.switchTo().alert().accept();
        System.out.println("Prompt Button");

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
