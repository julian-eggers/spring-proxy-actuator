package com.itelg.spring.actuator.proxy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;

public class ProxyHealthIndicator extends AbstractHealthIndicator
{
    private static final Logger log = LoggerFactory.getLogger(ProxyHealthIndicator.class);
    private List<String> proxyIps = new ArrayList<>();
    
    public ProxyHealthIndicator(String... ips)
    {
    	proxyIps.addAll(Arrays.asList(ips));
    }
    
    public ProxyHealthIndicator(List<String> ips)
    {
    	proxyIps.addAll(ips);
    }

    @Override
    protected void doHealthCheck(Builder builder) throws Exception
    {
        HttpURLConnection connection = null;
        builder.down();
        
        try
        {
            URL url = new URL("https://api.ipify.org/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.connect();
            int statusCode = connection.getResponseCode();
            
            if (statusCode == 200)
            {
                String response = IOUtils.toString(connection.getInputStream());
                
                for (String proxyIp : proxyIps)
                {
                	if (response.contains(proxyIp))
                	{
                		builder.up();
                	}
                }
            }
            else
            {
            	log.warn("ipify.org not available (Status-Code: " + statusCode + ")");
            }
        }
        catch (Exception e)
        {
            builder.down();
            log.error(e.getMessage(), e);
        }
        finally
        {
            if (connection != null)
            {
                connection.disconnect();
            }
        }
    }
    
    public List<String> getProxyIps()
    {
    	return proxyIps;
    }
}