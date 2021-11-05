package com.jachs.database.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/***
 * 
 * @author zhanchaohan
 *
 */
@Configuration
@PropertySource( encoding = "Utf-8", value = "classpath:/c3p0.properties" )
public class C3p0DataSourceConfig implements InitializingBean {
    @Value( "classpath:c3p0.sql" )
    private Resource dataScript;

    @Bean( "c3p0Source" )
    @ConfigurationProperties( prefix = "c3p0" )
    public DataSource c3p0SourceDs () {
        return DataSourceBuilder.create ().type ( com.mchange.v2.c3p0.ComboPooledDataSource.class ).build ();
    }
    @Bean
    public DataSourceInitializer C3p0dataSourceInitializer( @Qualifier( "c3p0Source" ) DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }
    private DatabasePopulator databasePopulator () {
        System.out.println ( "==================sql脚本正在执行==================" );
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator ();
        populator.addScripts ( dataScript );
        System.out.println ( "==================sql脚本初始化完成==================" );
        return populator;
    }

    @Bean( name = "c3p0TransactionManager" )
    public DataSourceTransactionManager oneTransactionManager ( @Qualifier( "c3p0Source" ) DataSource dataSource ) {
        return new DataSourceTransactionManager ( dataSource );
    }

    @Bean( name = "c3p0JdbcTemplate" )
    public JdbcTemplate JdbcTemplate ( @Qualifier( "c3p0Source" ) DataSource dataSource ) {
        return new JdbcTemplate ( dataSource );
    }

    @Override
    public void afterPropertiesSet () throws Exception {

    }

}