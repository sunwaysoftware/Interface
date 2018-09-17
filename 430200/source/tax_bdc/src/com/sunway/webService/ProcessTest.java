/**
 * 
 */
package com.sunway.webService;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amani
 *
 */
public class ProcessTest {

	/**
	 * Test method for {@link com.sunway.webService.Process#PgProcess(java.lang.String)}.
	 */
	@Test
	public final void testPgProcess() {
		
		String s = "<?xml version='1.0' encoding='UTF-8'?><EAIRequest><Requests><Request Name='GetFCXX'><FCXX FCSLH='20171206569' /><FCXX FCBM='null' /></Request></Requests></EAIRequest>";
		
		Process pro = new Process();
		String bb = pro.PgProcess(s);
		System.out.println(bb);
		
		
		fail("Not yet implemented"); // TODO
	}

}
