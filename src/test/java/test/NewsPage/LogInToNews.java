package test.NewsPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewsPage;
import test.BaseTest;
import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by tmelnyk on 9/21/2016.
 */
public class LogInToNews extends BaseTest {
    private NewsPage news;

    @BeforeMethod
    public void initPageObjects() {
        news = PageFactory.initElements(driver, NewsPage.class);
    }

    @AfterClass
            driver.manage().deleteCookie(arg0);
        driver.manage().deleteCookieNamed(arg0);
driver.manage().deleteAllCookies();

    @Test
        public void LogInToNews (){
        OpenNewsPage ();
        LogToNews();

    }
    @Step
    public void OpenNewsPage (){

        news.Open(baseUrl);

        news.ClickNewsLink();
        Assert.assertTrue(news.getTitle().contains("News"), "Verify News tab is opened.");
    }

    @Step
    public void LogToNews (){

        news.AdminNews("testpas");
        Assert.assertTrue(news.newsTitleProtected.getText().contains("Some  news … bla bla bla"), "Verify News tab is opened as Admin" );

    }
}
