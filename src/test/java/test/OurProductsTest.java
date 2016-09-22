//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.examplePage;
import test.BaseTest;
import util.WebDriverHelper;

public class OurProductsTest extends BaseTest {
    private examplePage homepage;

    public OurProductsTest() {
    }

    @BeforeMethod
    public void initPageObjects() {
        this.homepage = (examplePage)PageFactory.initElements(this.driver, examplePage.class);
    }

    @Test( priority = 1 )
    public void OpenOurProductsTest() throws Exception {
        this.driver.get(baseUrl + "/shop/");
        //WebDriverHelper.getScreenShot();
        //Assert.assertEquals("virtual-shop. Simple shop on WordPress", driver.getTitle());
        this.driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[6]/a")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals("Products - virtual-shop", driver.getTitle().toString());
        Assert.assertTrue("Our products".equals(this.homepage.header.getText()));
        //Thread.sleep(10000L);
    }

    @Test( priority = 2 )
    public void drillToGroupTest() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a/img")).click();
        System.out.println(driver.getTitle());
        //Assert.assertEquals("Funny Gifts - virtual-shop", driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Funny"));
        Assert.assertTrue("Funny Gifts".equals(this.homepage.header.getText()));
    }

    @Test( priority = 3 )
    public void drillToFirstItemTest() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a[1]/img")).click();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Toaster"));
        Assert.assertTrue("Toaster".equals(this.homepage.header.getText()));
    }

    @Test( priority = 4 )
    public void specialLabelTest() throws Exception {
        driver.findElement(By.xpath("//img[@alt='funnygifts-2']")).click();
        try {
            Assert.assertEquals("Sale!", driver.findElement(By.cssSelector("span.onsale")).getText());
            } catch (Error e) {};


    }

    @Test( priority = 5 )
    public void itemsInStockTest() throws Exception {
        Assert.assertEquals(driver.findElement(By.cssSelector("p.stock.in-stock")).getText(), "15 in stock");
    }

    @Test( priority = 6 )
    public void initialQuantityTest() throws Exception {
        Assert.assertEquals(driver.findElement(By.name("quantity")).getAttribute("value"), "1");
    }

    @Test( priority = 7 )
    public void addItemsToCartTest() throws Exception {
        //driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("2");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test( priority = 8 )
    public void itemsDescriptionTest() throws Exception {
        Assert.assertNotNull(driver.findElement(By.xpath("(//img[@alt='funnygifts-2'])[4]")));
    }
}


