import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebScaper {
    public static void main(String[] Args) throws InterruptedException {
        //Create chrome driver's instance

        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Site 1
        driver.get("https://www.migros.com.tr/");

        driver.findElement(By.id("product-search-combobox--trigger")).sendKeys("Komili Ayçiçek Yağı 4 L");
        driver.findElement(By.xpath("//*[@id=\"product-search-combobox-search-right-button\"]")).click();

        WebElement price1 = driver.findElement(By.cssSelector("[class=\"amount\"]"));
        String p1 = price1.getText();
        driver.close();

        //Site 2
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver2.get("https://www.bizimtoptan.com.tr/");

        driver2.findElement(By.id("small-searchterms")).sendKeys("Komili Ayçiçek Yağı 4 L");
        driver2.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();

        WebElement price2 = driver2.findElement(By.cssSelector("[class=\"product-price\"]"));
        String  p2= price2.getText();
        driver2.close();


        //Site 3
        WebDriver driver3 = new ChromeDriver();
        driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver3.get("https://www.amazon.com.tr/ref=nav_logo");

        driver3.findElement(By.id("twotabsearchtextbox")).sendKeys("Komili Ayçiçek Yağı 4 L");
        driver3.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        WebElement price3 = driver3.findElement(By.cssSelector("[class=\"a-price\"]"));

        String p3 = price3.getText();
        driver3.close();


        float pr1=Float.parseFloat(p1.replaceAll("[^0-9.]",""));

        float pr2=Float.parseFloat(p2.replaceAll("[^0-9.]",""));

        float pr3=Float.parseFloat(p3.replaceAll("[^0-9.]",""));


        System.out.println("Migros price= "+pr1);
        System.out.println("BizimToptan price= "+pr2);
        System.out.println("Amazon price= "+pr3);

        if(pr1>pr2 & pr1>pr3){
            System.out.println("The most expensive one:"+ pr1);
            if(pr2>pr3){
                System.out.println("The cheapest is :"+ pr3);
                System.out.println("The average is :"+ pr2);
            }
            else if(pr3>pr2){
                System.out.println("The cheapest is :"+ pr2);
                System.out.println("The average is :"+ pr3);
            }

            else if(pr2==pr3){
                System.out.println("Second site and third site is the same price and less than first site :"+ pr2);
            }
        }

        else if(pr2>pr1 & pr2>pr3){
            System.out.println("The most expensive one:"+ pr2);
            if(pr1>pr3){
                System.out.println("The cheapest is :"+ pr3);
                System.out.println("The average is :"+ pr1);
            }
            else if(pr3>pr1){
                System.out.println("The cheapest is :"+ p1);
                System.out.println("The average is :"+ p3);
            }
            else if(pr1==pr3){
                System.out.println("First site and third site is the same price and less than second site :"+ pr1);
            }
        }

        else if(pr3>pr1 & pr3>pr2){
            System.out.println("The most expensive one:"+ pr3);
            if(pr2>pr1){
                System.out.println("The cheapest is :"+ pr1);
                System.out.println("The average is :"+ pr2);
            }
            else if(pr1>pr2){
                System.out.println("The cheapest is :"+ pr2);
                System.out.println("The average is :"+ pr1);
            }
            else if(pr1==pr2){
                System.out.println("First site and second site is the same price and less than third site :"+ pr1);
            }
        }
    }
}
