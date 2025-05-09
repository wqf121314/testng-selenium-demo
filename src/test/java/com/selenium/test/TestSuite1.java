package com.selenium.test;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSuite1 extends BaseTest {

    @Test(groups = {"serial", "env1", "env2"})
    void testSuite1Case0SerialEnv1Env2() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google1");
    }

    @Test(groups = {"serial", "env1"})
    void testSuite1Case1SerialEnv1() throws InterruptedException {
        this.getDriver().get("https://www.google.com/");
        Thread.sleep(2000);
        assertThat(this.getDriver().getTitle()).contains("Google");
    }


    @Test(groups = {"parallel", "env1", "env2"})
    void testSuite1Case2ParallelEnv1Env2() throws InterruptedException {
        this.getDriver().get("https://www.google.com/");
        Thread.sleep(2000);
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"parallel", "env1"})
    void testSuite1Case3ParallelEnv1() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"parallel", "env1"})
    void testSuite1Case4ParallelEnv1() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"parallel", "env1"})
    void testSuite1Case5ParallelEnv1() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }
}
