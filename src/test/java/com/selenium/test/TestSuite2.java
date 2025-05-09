package com.selenium.test;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestSuite2 extends BaseTest {

    @Test(groups = {"serial", "env1", "env2"})
    void testSuite2Case1SerialEnv1Env2() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"serial", "env2"})
    void testSuite2Case2SerialEnv2() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"parallel", "env1", "env2"})
    void testSuite2Case3ParallelEnv1Env2() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }

    @Test(groups = {"parallel", "env2"})
    void testSuite2Case4ParallelEnv2() {
        this.getDriver().get("https://www.google.com/");
        assertThat(this.getDriver().getTitle()).contains("Google");
    }
}
