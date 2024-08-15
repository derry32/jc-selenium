package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("Open Browser URL");

        driver.findElement(By.name("q"))
                .sendKeys("Youtube");

        driver.findElement(By.name("q"))
                .sendKeys(Keys.ENTER);

        System.out.println("Search Keyword");
        //dia hanya close 1 tab
        //driver.close();

        //exit
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