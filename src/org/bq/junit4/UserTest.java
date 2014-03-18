/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.junit4;

import static org.bq.junit4.Print.print;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.core.Is.is;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class UserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		print("---------------Before------------------");
	}

	@Test
	public void test() {
		String s=new User().add("bq", "1234");
		assertThat(s,is("bq1234"));
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		print("--------------After------------------");
	}
}
