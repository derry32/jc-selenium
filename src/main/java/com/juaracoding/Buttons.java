package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buttons {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/buttons");
        System.out.println("Open Browser URL");

        js.executeScript("window.scrollBy(0,600)");
        Actions a = new Actions(driver);

        a.doubleClick(driver.findElement(By.id("doubleClickBtn"))).doubleClick().build().perform();
        System.out.println("Berhasil Double Click");

        a.contextClick(driver.findElement(By.id("rightClickBtn"))).contextClick().build().perform();
        Thread.sleep(1000);
        System.out.println("Berhasil Right Click");


        WebElement clickMeBtn = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
        a.click(clickMeBtn).build().perform();
        System.out.println("Berhasil Dynamic Click");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Exit Browser");
    }
}
