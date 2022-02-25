package com.jachs.springbootr2db.connection;

import org.junit.jupiter.api.Test;
import org.springframework.r2dbc.connection.DelegatingConnectionFactory;
import org.springframework.r2dbc.connection.SingleConnectionFactory;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ConnectionFactoryUtilsTest {

	@Test
	public void test1() {
		SingleConnectionFactory singFactory=new SingleConnectionFactory("", false);
	
		DelegatingConnectionFactory  deleFactory=new DelegatingConnectionFactory(singFactory);
	}
}
