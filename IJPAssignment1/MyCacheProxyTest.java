// IJP Assignment 1, Version 6.1.0, 05 Oct 2016
package ijp.test;

import static org.junit.Assert.*;
import java.awt.image.BufferedImage;
import org.junit.Test;
import ijp.Picture;
import ijp.service.Service;
import ijp.proxy.BrokenCacheProxy;
//import ijp.proxy.MyCacheProxy;

/**
 * Testing a cache proxy for the PictureViewer application.
 * 
 * @author Dian Yang
 * @version 1.0
 */
public class MyCacheProxyTest implements Service 
{
	/**
	 * Test that requests for the same subject and index return the same image.
	 */
	@Test
	public void equalityTest() 
	{
		//Service proxy = new MyCacheProxy(this);
		Service proxy = new BrokenCacheProxy(this);		
		Picture firstPicture = proxy.getPicture("equalityTest",2);
		Picture secondPicture = proxy.getPicture("equalityTest",2);
		assertTrue(
				"different picture returned for same subject (and index)",
				firstPicture.equals(secondPicture));
	}
	
	/**
	 * Test that the picture returned from the cache proxy actually has the index that was requested.
	 */
	@Test
	public void indexTest() 
	{
		//Service proxy = new MyCacheProxy(this);
		Service proxy = new BrokenCacheProxy(this);
		Picture firstPicture = proxy.getPicture("indexTest",100);
		assertTrue(
				"the picture returned from the cache proxy actually has the index that was requested",
				(firstPicture.index() == 100));
	}
	
	/**
	 * Test error B that the picture returned from the cache proxy actually use NoService.
	 */
	@Test
	public void serviceTest()
	{
		Service proxy = new BrokenCacheProxy(this);
		Picture firstPicture = proxy.getPicture("serviceTest", 2);
		assertFalse(
				"the picture returned from the cache proxy actually user NoService",
				(firstPicture.source().equals("NoService")));
	}
	
	/**
	 * Test that the picture returned from the cache proxy always has the subject that was requested.
	 */
	@Test
	public void subjectTest()
	{
		Service proxy = new BrokenCacheProxy(this);
		Picture firstPicture = proxy.getPicture("subjectTest", 2);
		assertTrue(
				"the picture returned from the cache proxy always has the subject that was requested",
				(firstPicture.subject().equals("subjectTest")));
	}
	
	/**
	 * Test that error C that the picture returned from the cache proxy always has index 0
	 */
	@Test
	public void zeroIndexTest()
	{
		Service proxy = new BrokenCacheProxy(this);
		Picture firstPicture = proxy.getPicture("zeroIndexTest", 2);
		assertFalse(
				"the pictire returned from the cache proxy always has index 0",
				(firstPicture.index() == 0));
	}
	
	/**
	 * Test that there is no error in error D by running all tests in 100 times
	 */
	@Test
	public void multiRunTest()
	{
		for(int i = 0; i < 100; i++){
			indexTest();
			equalityTest();
			serviceTest();
			subjectTest();
			zeroIndexTest();
		}
	}
	
	/**
	 * Return a picture from the simulated service.
	 * This service simply returns an empty picture every time that it called.
	 * Note that a <em>different</em> object is returned each time, even if the
	 * subject and index are the same.
	 *
	 * @param subject the requested subject
	 * @param index the index of the picture within all pictures for the requested topic
	 *
	 * @return the picture
	 */
	@Override
	public Picture getPicture(String subject, int index) 
	{
		return new Picture((BufferedImage)null, subject ,serviceName(), index);
	}
	
	/**
	 * Return a textual name to identify the simulated service.
	 *
	 * @return the name of the service ("cacheProxyTest")
	 */
	@Override
	public String serviceName() 
	{
		return "MyCacheProxyTest";
	}
}
