/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.thangntran.selenium;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author thang
 */
public class Selenium {
    //test case nay le ra phai de trong testrail
    //test case 1: open GG search engine 
    //Step1 : open a certain browser, e.g. Chrome
    //step2 : type url: https://www.google.com
    //step3 : type ét o ét in the search box 
    //step4 : enter to see the result 
    
    //expected rresult 
    //multiple websites with the include keyword ét o ét are showed
    public static void testGoogleSearchEngine(){
        String drivenPath = "chromedriver.exe";
        // chi duong dan toi file driver 
        
        //bao may ao jv biet co tool phu tro se tuong tac vs trinh duyet 
        // bao jvm biet co plugin o tren de trieu goi khi can 
        System.setProperty("webdriver.chrome.driver", drivenPath);
        //tuong duong lenh Class.forName(de tai )
        
        WebDriver myBrowser;// xai selenium thi trinh duyet cung la mot object 
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang=vi");
        myBrowser = new ChromeDriver(opt);
        //khai bao cha new con; va trinh duyet se show 1/2 man hinh 
        // bung rong ra 100%
        myBrowser.manage().window().maximize();
        
        //duyet web 
        myBrowser.get("https://www.google.com");
        
        //di tim o search, name la "q", moi thanh phan cua trang web deu dc xem 
        // la 1 object goi chung la webElement 
        
        
        WebElement searchBox = myBrowser.findElement(By.name("q"));
        //sau khi search, neu thanh cong ta dinh vi dc o nhao 
        searchBox.sendKeys("Ét o Ét");
       //an enter
       searchBox.submit();
    }
    
    
     //Step1 : open a certain browser, e.g. Chrome
    //step2 : type url: https://demo.guru99.com/v4/index.php
    //step3 : input username/pass: mngr392601/Ebegaty
    //step4 : hit login button
    //Expect
    //step5 : the dashboard hello hien cai web thanh cong  
    public static void testGuru99() throws InterruptedException{
        String drivenPath = "chromedriver.exe";
        // chi duong dan toi file driver 
        
        //bao may ao jv biet co tool phu tro se tuong tac vs trinh duyet 
        // bao jvm biet co plugin o tren de trieu goi khi can 
        System.setProperty("webdriver.chrome.driver", drivenPath);
        //tuong duong lenh Class.forName(de tai )
        
        WebDriver myBrowser;// xai selenium thi trinh duyet cung la mot object 
        
       
        myBrowser = new ChromeDriver();
        //khai bao cha new con; va trinh duyet se show 1/2 man hinh 
        // bung rong ra 100%
        myBrowser.manage().window().maximize();
        
        //duyet web 
        myBrowser.get("https://demo.guru99.com/v4/index.php");
        
        //di tim o nhap username/ pass qua chuoi dinh vi xpath bang tool 
        //selector hub 
        
        
        WebElement userIdBox = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        userIdBox.sendKeys("mngr392601");
        WebElement password = myBrowser.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("Ebegaty");

        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click();
        //khi login thi se chuyen trang!
        //can 1 do tre de trang dc load ve local, cac cau lenh nay chay
        //ko can cho trang tai ve. ERROR vi tim ko thay tag, cho chua kip render
        //NGHE THUAT/TIP: WAIT/SLEEP CODE JAVA 1 CHUT
        //2 TIEN TRINH/2 THREAD KHAC NHAU: CODE JAVA VA TRINH DUYET
        
        Thread.sleep(3000);
        
        //kiem tra coi da chao dung chua: Manager Id: user-name login vao
        WebElement helloMsg = myBrowser.findElement(By.xpath("//td[normalize-space()='Manger Id : mngr392601']"));
        System.out.println("Hello msg: " + helloMsg.getText());
        //in dc nghia la login thanh cong 
        
    }
    
    public static void main(String[] args) {
        try {
            testGuru99();
        } catch (InterruptedException ex) {
            Logger.getLogger(Selenium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
