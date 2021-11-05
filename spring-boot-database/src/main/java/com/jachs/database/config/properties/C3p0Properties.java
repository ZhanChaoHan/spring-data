package com.jachs.database.config.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
@Configuration
@PropertySource(encoding = "Utf-8",value = "classpath:/c3p0.properties")
public class C3p0Properties {
	@Value("${c3p0.jdbcUrl}")
	private String jdbcUrl;
	@Value("${c3p0.user}")
	private String user;
	@Value("${c3p0.password}")
	private String password;
	@Value("${c3p0.driverClass}")
	private String driverClass;
	@Value("${c3p0.minPoolSize}")
	private String minPoolSize;
	@Value("${c3p0.maxPoolSize}")
	private String maxPoolSize;
	@Value("${c3p0.maxIdleTime}")
	private String maxIdleTime;
	@Value("${c3p0.acquireIncrement}")
	private String acquireIncrement;
	@Value("${c3p0.maxStatements}")
	private String maxStatements;
	@Value("${c3p0.initialPoolSize}")
	private String initialPoolSize;
	@Value("${c3p0.idleConnectionTestPeriod}")
	private String idleConnectionTestPeriod;
	@Value("${c3p0.acquireRetryAttempts}")
	private String acquireRetryAttempts;
	@Value("${c3p0.acquireRetryDelay}")
	private String acquireRetryDelay;
	@Value("${c3p0.breakAfterAcquireFailure}")
	private String breakAfterAcquireFailure;
	@Value("${c3p0.testConnectionOnCheckout}")
	private String testConnectionOnCheckout;
}
