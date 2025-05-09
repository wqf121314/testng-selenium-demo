package com.selenium.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ExecutionLoggerListener implements ITestListener {
    private static final DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final Map<Integer, LocalDateTime> startTimes = new ConcurrentHashMap<>();

    private String now() {
        return LocalDateTime.now().format(timeFmt);
    }

    private String testName(ITestResult result) {
        return result.getTestClass().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        int id = System.identityHashCode(result);
        startTimes.put(id, LocalDateTime.now());

        System.out.printf("%s [%s] Running %s%n",
                now(),
                Thread.currentThread().getName(),
                testName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logEnd(result, "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logEnd(result, "FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logEnd(result, "SKIPPED");
    }

    private void logEnd(ITestResult result, String status) {
        int id = System.identityHashCode(result);
        LocalDateTime start = startTimes.getOrDefault(id, LocalDateTime.now());
        Duration duration = Duration.between(start, LocalDateTime.now());
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).toSeconds();
        String durationStr = String.format("%d:%02d", minutes, seconds);

        System.out.printf("%s [%s] Finished %s (%s) after %s%n",
                now(),
                Thread.currentThread().getName(),
                testName(result),
                status,
                durationStr);
    }
}
