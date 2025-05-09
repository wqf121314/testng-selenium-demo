package com.selenium.test;


import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestSuite4 extends BaseTest {

    @Test(groups = {"serial", "env1", "env2", "env3"})
    void testSuite4Case1SerialEnv1Env2Env3() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"serial", "env3"})
    void testSuite4Case2SerialEnv3() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"parallel", "env1", "env3"})
    void testSuite4Case3ParallelEnv1Env3() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }


    @Test(groups = {"parallel", "env2", "env3"})
    void testSuite4Case3ParallelEnv2Env3() throws InterruptedException {
        this.getDriver().get("https://www.google.com/");
        Thread.sleep(2000);
        assertThat(this.getDriver().getTitle()).contains("Google");
    }


    @Test(groups = {"parallel", "env3"})
    void testSuite4Case4ParallelEnv3() throws InterruptedException {
        this.getDriver().get("https://www.google.com/");
        Thread.sleep(2000);
        assertThat(this.getDriver().getTitle()).contains("Google");
    }
}
