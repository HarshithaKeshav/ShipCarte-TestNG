package io.pragra.shipcarte.test;

import io.pragra.shipcarte.configuration.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ConfigTest {

    @Test
    public void testConfigValidProperties() throws IOException {
        Assert.assertEquals(Config.getProperty("browser.type"),"chrome");
    }

    @Test
    public void testConfigValidPRoperties2() throws IOException{
        Assert.assertTrue(Config.getProperty("firefox.driver").contains("geckodriver"));
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testConfigInvalidProperties() throws IOException {
        Config.getProperty("abcdef");
    }
}
