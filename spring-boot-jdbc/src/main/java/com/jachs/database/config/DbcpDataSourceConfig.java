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
@PropertySource( encoding = "Utf-8", value = "classpath:/dbcp2.properties" )
public class DbcpDataSourceConfig implements InitializingBean{
    @Value( "classpath:dbcp.sql" )
    private Resource dataScript;
    
    @Bean( "dbcpSource" )
    @ConfigurationProperties( prefix = "spring.datasource.dbcp2" )
    public DataSource dbcpSourceDs () {
        return DataSourceBuilder.create ().build ();
    }
    private DatabasePopulator databasePopulator () {
        System.out.println ( "==================sql脚本正在执行==================" );
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator ();
        populator.addScripts ( dataScript );
        System.out.println ( "==================sql脚本初始化完成==================" );
        return populator;
    }
    @Bean
    public DataSourceInitializer DbcpdataSourceInitializer( @Qualifier( "dbcpSource" ) DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }
    @Bean(name = "dbcpTransactionManager")
    public DataSourceTransactionManager oneTransactionManager(@Qualifier("dbcpSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
   
    @Bean(name = "dbcpJdbcTemplate")
    public JdbcTemplate JdbcTemplate(@Qualifier("dbcpSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Override
    public void afterPropertiesSet () throws Exception {
        
    }
}