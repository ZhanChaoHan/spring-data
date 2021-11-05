package com.jachs.database.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/***
 * 
 * @author zhanchaohan
 *
 */
@Configuration
@PropertySource( encoding = "Utf-8", value = "classpath:/c3p0.properties" )
public class C3p0DataSourceConfig {

    @Bean( "c3p0Source" )
    @ConfigurationProperties( prefix = "c3p0" )
    public DataSource c3p0SourceDs () {
        return DataSourceBuilder.create ()
                .type(com.mchange.v2.c3p0.ComboPooledDataSource.class)
                .build();
    }

}