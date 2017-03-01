//IJP AssignMent 2, Version 1.1, 27 Nov 2016 

package view;

import javafx.scene.image.Image;

/**
 * Implementing the view class
 * @author s1626297
 * @version 1.1
 */
public class View 
{
	private Image image = null;
	private Integer index = 0;
	private Integer locationId = 0;
	
	/**
	 * Create an empty view
	 */
	public View()
	{
		
	}
	
	/**
	 * Create a view with source, index and locationId
	 * @param source The url of image of the view 
	 * @param index The index id of the view
	 * @param locationId The location id of the view
	 */
	public View(String source, Integer index, Integer locationId) 
	{
		this.setImage(source);
		this.setLocationId(locationId);
		this.setIndex(index);
	}
	
	/**
	 * Set the image of the view
	 * @param source The url of the image of the view
	 */
	public void setImage(String source) 
	{
		this.image = new Image(source);
	}
	
    /**
     * Return the image of the view
     * @return image
     */
	public Image image() 
	{
		return this.image;
	}
	
    /**
     * Set the index of the view in location
     * @param index Index of the view
     */
	public void setIndex(Integer index) 
	{
		this.index = index;
	}
	
	/**
	 * Get the index of the view in Location
	 * @return index Index of the view
	 */
	public Integer index() 
	{
		return this.index;
	}
	
	/**
	 * Set the location id of the view
	 * @param locationId Location Id
	 */
	public void setLocationId(Integer locationId) 
	{
		this.locationId = locationId;
	}
	
    /**
     * Get the location id of the view
     * @return locationId Location Id
     */
	public Integer locationId() 
	{
		return this.locationId;
	}
}
