// IJP Assignment 1, Version 6.1.0, 05 Oct 2016
package ijp.proxy;

import ijp.service.Service;
import ijp.service.ServiceFromProperties;
import ijp.Picture;
import java.util.HashMap;

/**
 * Implementing a cache proxy for the PictureViewer application.
 * 
 * @author DianYang 
 * @version 1.0 
 */

public class MyCacheProxy implements Service
{
	private Service baseService = null;
	private HashMap<String, Picture>  pictures;
	
	/**
	 * Create a cache proxy service based on the service specified in the CacheProxy.base_service resource.
	 */
	public MyCacheProxy() 
	{
		pictures = new HashMap<>();
		baseService = new ServiceFromProperties("CacheProxy.base_service");
		  
	}
	
	/**
	 * Create a cache proxy service based on the specified service.
	 * @param baseService the base service
	 */
	public MyCacheProxy(Service baseService) 
	{
		pictures = new HashMap<>();
		this.baseService = baseService;
	}
	
	/**
	 * Return a textual name for the service.
	 * @return the name of the base service
	 */
	public String serviceName() 
	{
		return baseService.serviceName();
	}
	
	/**
	 * Return a picture from the base service.
	 * @param subject the free-text subject string
	 * @param index the index of the matching picture to return
	 * @return the requested picture
	 */
	public Picture getPicture(String subject, int index) 
	{	
		Picture picture = new Picture();
		// If the requested picture is in the cache
		// return the copy from the cache
		if(pictures.get(subject) != null) {
			Picture temPic = pictures.get(subject);
			if(temPic.index().equals(index)) {
				picture = temPic;
			}
		}
		// If the requested picture is not in the cache
		// download it from the base service
		// store it in the cache
		else {
			picture = baseService.getPicture(subject, index);
			pictures.put(subject, picture);
		}
		return picture;
	}
	
}
