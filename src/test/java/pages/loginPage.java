package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class loginPage {
        public void PositiveLogin (WebDriver driver, String[] loginData) {

           driver.get("https://accounts.google.com/signin");
           driver.findElement(By.id("identifierId")).sendKeys(loginData[0]);
           driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
           driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(loginData[1]);
           driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
        }
        public void NegativeLogin(WebDriver driver, String[] loginNegData){

            driver.get("https://accounts.google.com/signin");
            driver.findElement(By.id("identifierId")).sendKeys(loginNegData[0]);
            driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
            String result =((driver.findElement(By.xpath("//div[@class='o6cuMc Jj6Lae']")))).getText();
            Assert.assertEquals("The actual and expected title don’t match",loginNegData[2],result);
            }

        }


