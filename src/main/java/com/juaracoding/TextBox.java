package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/text-box");
        System.out.println("Open Browser URL");

        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.id("userName"))
                .sendKeys("derry");

        driver.findElement(By.id("userEmail"))
                .sendKeys("derry32@gmail.com");

        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.id("currentAddress"))
                .sendKeys("Bogor");

        driver.findElement(By.id("permanentAddress"))
                .sendKeys("Bandung");

        driver.findElement(By.id("submit")).click();

        js.executeScript("window.scrollBy(0,300)");

        System.out.println("Input Data");

//        driver.quit();
//        System.out.println("Exit Browser");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
