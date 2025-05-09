package com.selenium.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.selenium.utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserType.FIREFOX);
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String methodName = result.getMethod().getMethodName();

            // 路径：target/screenshots/xxx.png
            String dirPath = "target/screenshots";
            String fileName = methodName + "_" + timestamp + ".png";
            File destFile = new File(dirPath, fileName);

            try {
                FileUtils.forceMkdir(new File(dirPath)); // 确保目录存在
                FileUtils.copyFile(screenshot, destFile);
                log.error("Saved screenshot: {}", destFile.getAbsolutePath());
            } catch (IOException e) {
                log.error("Failed to save screenshot: {}", e.getMessage());
            }
        }
    }
}
