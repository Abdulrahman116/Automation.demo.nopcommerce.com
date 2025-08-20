package UtilTests;

import base.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class UtilTests extends BaseTests{

    WebDriver driver;
    ExtentTest test;
    static ExtentReports extent;

    public UtilTests(WebDriver driver){
        this.driver = driver;
    }

    //Screen Shot
    public void takeScreenShot(String name) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("report/"+name+".png"));
    }
    public void createReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My Report");
        extent.attachReporter(spark);
    }
    public void setTestCaseStatus(Method method, ITestResult result){
        test = extent.createTest(method.getName());
        if(result.getStatus()==ITestResult.SUCCESS){
            test.pass("Test Pass");
        }
        else if (result.getStatus()==ITestResult.FAILURE){
            test.fail("Test Fail");
        }
        else if (result.getStatus()==ITestResult.SKIP){
            test.skip("Test Skip");
        }
        test.addScreenCaptureFromPath(method.getName()+".png");
    }
    public void flushReport(){
        extent.flush();
    }
}
