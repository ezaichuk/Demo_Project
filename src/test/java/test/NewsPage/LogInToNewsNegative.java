package test.NewsPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewsPage;
import ru.yandex.qatools.allure.annotations.Step;
import test.BaseTest;


/**
 * Created by tmelnyk on 9/21/2016.
 */
public class LogInToNewsNegative extends BaseTest {
    private NewsPage news;

    @BeforeMethod
    public void initPageObjects() {
        news = PageFactory.initElements(driver, NewsPage.class);
    }

    @Test
        public void LogInToNewsNegative (){
        OpenNewsPage ();
        LogInToNews1();
        LogInToNews2();
        LogInToNews3();
        LogInToNews4();
        LogInToNews5();

    }
    @Step
    public void OpenNewsPage (){

        news.Open(baseUrl);

        news.ClickNewsLink();
        Assert.assertTrue(news.getTitle().contains("News"), "Verify News tab is opened.");
    }

    @Step
    public void LogInToNews1 (){
        news.AdminNews("testpas1111");
        Assert.assertTrue(news.newsTitle.getText().contains("This content is password protected. To view it please enter your password below"), "Verify News tab is NOT opened as Admin" );
    }
    @Step
    public void LogInToNews2 (){
        news.AdminNews("testpas1111");
        Assert.assertTrue(news.newsTitle.getText().contains("This content is password protected. To view it please enter your password below"), "Verify News tab is NOT opened as Admin" );
    }
    @Step
    public void LogInToNews3 (){
        news.AdminNews("testpas1111");
        Assert.assertTrue(news.newsTitle.getText().contains("This content is password protected. To view it please enter your password below"), "Verify News tab is NOT opened as Admin" );
    }
    @Step
    public void LogInToNews4 (){
        news.AdminNews("testpas1111");
        Assert.assertTrue(news.newsTitle.getText().contains("This content is password protected. To view it please enter your password below"), "Verify News tab is NOT opened as Admin" );
    }
    @Step
    public void LogInToNews5 (){
        news.AdminNews("testpas1111");
        Assert.assertTrue(news.newsTitle.getText().contains("This content is password protected. To view it please enter your password below"), "Verify News tab is NOT opened as Admin" );
    }
}
