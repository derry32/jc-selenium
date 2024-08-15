package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/webtables");
        System.out.println("Open Browser URL");

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        driver.findElement(By.id("addNewRecordButton")).click();
        System.out.println("Berhasil membuka Modal PopUp");


        driver.findElement(By.id("firstName")).sendKeys("Derry");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys("Ahmad");
        Thread.sleep(1000);
        driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("age")).sendKeys("21");
        Thread.sleep(1000);
        driver.findElement(By.id("salary")).sendKeys("20000000");
        Thread.sleep(1000);
        driver.findElement(By.id("department")).sendKeys("QA");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        System.out.println("Berhasil Submit Form");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Exit Browser");
    }
}
