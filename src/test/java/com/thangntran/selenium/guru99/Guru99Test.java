/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.thangntran.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author thang
 */
public class Guru99Test {
    
    private static WebDriver myBrowser;
    private static String drivenPath = "chromedriver.exe";
    @BeforeAll //khoi dong trinh duyet here dung chung cho nhieu ham test o duoi
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", drivenPath);
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
        myBrowser.get("https://demo.guru99.com/v4/index.php");
    }
    
    @Test 
    public void testLogin() throws InterruptedException{
        WebElement userIdBox = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        userIdBox.sendKeys("mngr392601");
        WebElement password = myBrowser.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("Ebegaty");
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click();
        Thread.sleep(3000);
        WebElement helloMsg = myBrowser.findElement(By.xpath("//td[normalize-space()='Manger Id : mngr392601']"));
        assertEquals("Manger Id : mngr392601", helloMsg.getText());
    }
    
    @AfterAll
    public static void tearDownClass() { 
        myBrowser.quit();//tat trinh duyet 
    }
    
}
