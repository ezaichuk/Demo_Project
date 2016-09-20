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

public class OurProductsTest extends BaseTest {
    private examplePage homepage;

    public OurProductsTest() {
    }

    @BeforeMethod
    public void initPageObjects() {
        this.homepage = (examplePage)PageFactory.initElements(this.driver, examplePage.class);
    }

    @Test
    public void OpenOurProductsTest() throws Exception {
        this.driver.get(baseUrl + "/shop/");
        //Assert.assertEquals("virtual-shop. Simple shop on WordPress", driver.getTitle());
        this.driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[6]/a")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals("Products - virtual-shop", driver.getTitle());
        Assert.assertTrue("Our products".equals(this.homepage.header.getText()));
        Thread.sleep(10000L);
    }

    @Test
    public void drillToGroupTest() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a/img")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals("Funny Gifts - virtual-shop", driver.getTitle());
        Assert.assertTrue("Funny Gifts".equals(this.homepage.header.getText()));
        Thread.sleep(10000L);
    }
}
