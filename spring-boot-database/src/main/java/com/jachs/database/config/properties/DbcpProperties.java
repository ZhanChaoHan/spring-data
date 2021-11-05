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
@PropertySource(encoding = "Utf-8",value = "classpath:/dbcp2.properties")
public class DbcpProperties {
	@Value("${spring.datasource.dbcp2.max-wait-millis}")
	private String waitMillis;
	@Value("${spring.datasource.dbcp2.min-idle}")
	private String minIdle;
	@Value("${spring.datasource.dbcp2.initial-size}")
	private String initialSize;
}
