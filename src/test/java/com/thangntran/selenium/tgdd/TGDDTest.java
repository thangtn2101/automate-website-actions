/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.thangntran.selenium.tgdd;

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
public class TGDDTest {
    
    private static WebDriver myBrowser;
    private static String drivenPath = "chromedriver.exe";
    @BeforeAll //khoi dong trinh duyet here dung chung cho nhieu ham test o duoi
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", drivenPath);
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
        myBrowser.get("https://www.thegioididong.com/");
    }
    
    //Test case : check if the price of 1st phone in the search result page
    // and detail page are the same or not ? 
    // step 1: open a browser e.g chrome 
    // step 2: type the url https://www.thegioididong.com/
    // step 3: Type "z flip" in to the search box
    // step 4 hit the enter to see the list of phone 
    // step 5: store/remember the price of 1st phone 
    // step 6 click on this phone to view details 
    // step 7 : 
    @Test 
    public void testLogin() throws InterruptedException{
       
        // sau nay se tham so hoa 2 chuoi string nay 
        
        WebElement searchbox = myBrowser.findElement(By.xpath("//input[@id='skw']"));
        searchbox.sendKeys("z flip");
        searchbox.submit(); // buton thi moi dung click
        
        //tim dien thoai dau tien bao boi the <li> cointain hyperlink 
        //sau co the click 
        WebElement phoneBriElement = myBrowser.findElement(By.xpath("//ul[@class='listsearch item2020 listproduct']//li[3]"));
        //in thu toan bo ifo 
        System.out.println("1st phone: " + phoneBriElement.getText());
        //crawler, cao data va in ra !
        
        //ta di tim tag chua gia tien, tag nay deu xuat hien o moi. dien thoai 
        // nen se trung -> ko tim tu dau trang 
        // query tu tag cua dien thoai dau tien 
        WebElement phonePrice = phoneBriElement.findElement(By.className("price"));
        System.out.println("Price only: "+phonePrice.getText());
        String brifPrice = phonePrice.getText();

        //click chuyen trang detail luon 
        phoneBriElement.click();
        
        //nho wait 
        Thread.sleep(3000);
        
        //tim gia tien de chuyen trang 
        WebElement phonePriceDetail = myBrowser.findElement(By.xpath("//p[@class='box-price-present']"));
        System.out.println("Price detail: "+phonePriceDetail.getText());
        String brifPriceDetail = phonePriceDetail.getText();
        assertEquals(brifPrice, brifPriceDetail);
        
       
    }
    
    @AfterAll
    public static void tearDownClass() { 
       myBrowser.quit();//tat trinh duyet 
    }
    
}
