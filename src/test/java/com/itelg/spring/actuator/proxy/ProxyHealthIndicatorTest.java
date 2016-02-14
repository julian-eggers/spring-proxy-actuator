package com.itelg.spring.actuator.proxy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.actuate.health.HealthIndicator;

public class ProxyHealthIndicatorTest
{
    @Test
    @Ignore
    public void testIT()
    {
        HealthIndicator healthIndicator = new ProxyHealthIndicator("91.204.52.87");
        System.out.println(healthIndicator.health());
    }
    
    @Test
    public void testConstructorArray()
    {
    	ProxyHealthIndicator healthIndicator = new ProxyHealthIndicator("127.0.0.1", "192.168.2.1");
    	Assert.assertTrue(healthIndicator.getProxyIps().contains("127.0.0.1"));
    	Assert.assertTrue(healthIndicator.getProxyIps().contains("192.168.2.1"));
    	Assert.assertFalse(healthIndicator.getProxyIps().contains("8.8.4.4"));
    }
    
    @Test
    public void testConstructorList()
    {
    	ProxyHealthIndicator healthIndicator = new ProxyHealthIndicator(Arrays.asList("127.0.0.1", "192.168.2.1"));
    	Assert.assertTrue(healthIndicator.getProxyIps().contains("127.0.0.1"));
    	Assert.assertTrue(healthIndicator.getProxyIps().contains("192.168.2.1"));
    	Assert.assertFalse(healthIndicator.getProxyIps().contains("8.8.4.4"));    	
    }
}