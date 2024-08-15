package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        js.executeScript("window.scrollBy(0,100)");

        String txtTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(txtTitle);

        WebElement btnNewTab = driver.findElement(By.id("tabButton"));
        btnNewTab.click();

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String currentUrl = driver.getCurrentUrl();//actual
        System.out.println(currentUrl);
        String expected = "https://demoqa.com/sample";
        delay(2);

        //Assert use If
        System.out.print("Test Result: ");

        if (currentUrl.equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        delay(2);
        driver.switchTo().window(newTab.get(0));
        String tabTitle = driver.getTitle(); //actual
        System.out.println(tabTitle);
        String expected2 = "DEMOQA";
        delay(3);
        customAssertEquals(tabTitle, expected2);

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

    public static void customAssertEquals(String actual, String expected){
        System.out.print("Test Result: ");
        if (actual.equals(expected)){
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }
}
