spring-proxy-actuator
=====================

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.itelg.spring/spring-proxy-actuator/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.itelg.spring/spring-proxy-actuator)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/dec638a857614edfb153ba55d1d29a3b)](https://www.codacy.com/app/eggers-julian/spring-proxy-actuator)
[![Coverage Status](https://coveralls.io/repos/julian-eggers/spring-proxy-actuator/badge.svg?branch=master&service=github)](https://coveralls.io/github/julian-eggers/spring-proxy-actuator?branch=master)
[![Build Status](https://travis-ci.org/julian-eggers/spring-proxy-actuator.svg?branch=master)](https://travis-ci.org/julian-eggers/spring-proxy-actuator)

SpringBoot Proxy Actuator

#### Maven
```xml
<dependency>
	<groupId>com.itelg.spring</groupId>
	<artifactId>spring-proxy-actuator</artifactId>
	<version>0.2.0-RELEASE</version>
</dependency>
```

#### Example
```java
@Bean
public HealthIndicator proxyHealthIndicator()
{
	return new ProxyHealthIndicator("192.168.2.1");
}
```

#### Response ([health.json](http://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html#production-ready-health))
```json
{
	"status" : "UP",
	"proxy" : 
	{
		"status" : "UP"
	}
}
```
