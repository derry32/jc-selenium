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

        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);
        driver.findElement(By.id("addNewRecordButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-header > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("addNewRecordButton")).click();
        System.out.println("Berhasil membuka dan menutup Modal PopUp");


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

        Thread.sleep(2000);
        driver.findElement(By.id("edit-record-4")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-header > button")).click();
        System.out.println("Berhasil membuka dan menutup modal popup edit");

        Thread.sleep(2000);
        driver.findElement(By.id("edit-record-4")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("age")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("age")).sendKeys("31");
        Thread.sleep(1000);
        driver.findElement(By.id("salary")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("salary")).sendKeys("2000000");
        Thread.sleep(1000);
        driver.findElement(By.id("department")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("department")).sendKeys("SQA");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        System.out.println("Berhasil Edit Form");

        Thread.sleep(4000);
        driver.findElement(By.id("delete-record-4")).click();
        System.out.println("Berhasil menghapus");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Exit Browser");
    }
}
