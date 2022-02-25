package com.jachs.springbootr2db.connection;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.springframework.r2dbc.core.DatabaseClient;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import reactor.core.publisher.Flux;

/***
 * @author zhanchaohan
 */
public class ConnectionFactoryTest {

    @Test
    public void test1() throws Exception{
        //r2dbc:driver[:protocol]://[user:password@]host[:port]
        //r2dbc:mysql[:http]://[root:@]127.0.0.1[:3306]
        ConnectionFactory factory = ConnectionFactories.get("r2dbc:mysql[:http]://[root:@]127.0.0.1[:3306]");

        Publisher<? extends Connection> conn= factory.create();
    }
    @Test
    public void test2() {
    	ConnectionFactoryOptions options=ConnectionFactoryOptions.builder()
			     .option(ConnectionFactoryOptions.DRIVER, "mysql")
			     .option(ConnectionFactoryOptions.PROTOCOL, "pipes")
			     .option(ConnectionFactoryOptions.HOST, "localhost")
			     .option(ConnectionFactoryOptions.PORT, 3306)
			     .option(ConnectionFactoryOptions.DATABASE, "alarm")
				 .option(ConnectionFactoryOptions.USER, "root")
				 .option(ConnectionFactoryOptions.PASSWORD, "")
			     .option(Option.valueOf("locale"), "en_US")
			     .build();
    	
    	ConnectionFactory connFactory=ConnectionFactories.get(options);
    	DatabaseClient client = DatabaseClient.create(connFactory);
    	
    	Flux<Map<String, Object>> flux=client.sql("select * from users").fetch().all();
		flux.blockLast();
		flux.doOnComplete(()->{
			System.out.println("查询完毕");
		});

		flux.subscribe(a->{
    		Set<String> keySet=a.keySet();
    		
    		keySet.forEach(key->{
    			System.out.println(key);
    		});
    	});
    	
    }
    @Test
    public void test3() {
    	MySqlConnectionConfiguration configuration = MySqlConnectionConfiguration.builder()
                .host("127.0.0.1")
                .port(3306)
                .database("test")
                .username("root")
                .password("root")
                .build();

        ConnectionPoolConfiguration poolConfiguration = ConnectionPoolConfiguration.builder()
                .connectionFactory(MySqlConnectionFactory.from(configuration))
                .maxSize(30)
                .maxIdleTime(Duration.ofSeconds(1))
                .maxLifeTime(Duration.ofSeconds(100))
                .build();

        ConnectionPool pool=  new ConnectionPool(poolConfiguration);
    }
}
