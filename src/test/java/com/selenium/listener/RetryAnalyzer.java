package com.selenium.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Slf4j
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // 设置最大重试次数

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            String methodName = result.getMethod().getMethodName();
            log.warn("Retrying test '{}' (retry {}/{})", methodName, retryCount, maxRetryCount);
            return true; // 返回 true 表示需要重试
        }
        return false;
    }
}
