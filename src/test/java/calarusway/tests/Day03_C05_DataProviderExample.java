package calarusway.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilitest.BaseTest;

public class Day03_C05_DataProviderExample extends BaseTest {


    @Test(
            dataProvider = "keyData"
    )
    public void amazonSearchTest(String key){

        WebDriver driver;
        driver = null;
        driver.get("https://www.amazon.com.tr/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // DataProvider ile saglanan string ifade arama kismina yazilir ve enter a basilir
        searchBox.sendKeys(key + Keys.ENTER);

        WebElement searchResult = driver.findElement(By.className("a-color-state"));

        // Arama sonucunun aradigimiz kelimeyi icerip icermedigi kontrol edilir
        Assert.assertTrue(searchResult.getText().contains(key));

    }


    @DataProvider
    public Object[][] keyData(){
        return new Object[][]{
                {"java"},
                {"javascript"},
                {"python"}
        };
    }
}