package com.selenium.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GroupFilterInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        String env = context.getCurrentXmlTest().getParameter("env");
        String phase = context.getCurrentXmlTest().getParameter("phase");

        List<IMethodInstance> filtered = new ArrayList<>();
        for (IMethodInstance method : methods) {
//            log.info("Method {} matched with phase={} and env={}", method.getMethod().getMethodName(), phase, env);
            List<String> groups = List.of(method.getMethod().getGroups());
            if (groups.contains(env) && groups.contains(phase)) {
                filtered.add(method);
            }
        }
        return filtered;
    }
}
