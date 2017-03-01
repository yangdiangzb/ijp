//IJP AssignMent 2, Version 1.1, 27 Nov 2016 

package item;

import javafx.scene.image.Image;

/**
 * Implementing the item class for portable item
 * @author s1626297
 *
 */
public class Item 
{
	private Image image;
	private String name;
	private Integer index;
	private Integer locationId;
	private Integer viewIndex;
	
	
	/**
	 * Create a item doing nothing
	 */
	public Item()
	{
		
	}
	
	/**
	 * Create a item with name, source, locationId, viewIndex, index 
	 * @param name The name of the portable item
	 * @param source The url source of the item image
	 * @param locationId The locationId where the item at
	 * @param viewIndex The viewIndex where the item at
	 * @param index The index of the item
	 */
	public Item(String name,String source,Integer locationId,Integer viewIndex, Integer index)
	{
		this.setName(name);
		this.setImage(source);
		this.setLocationId(locationId);
		this.setIndex(index);
		this.setViewIndex(viewIndex);
	}
	
	/**
	 * Set the index of item
	 * @param index Index of item
	 */
	public void setIndex(Integer index)
	{
		this.index = index;
	}
	
	/**
	 * Get the index of item
	 * @return index Index of item
	 */
	public Integer index()
	{
		return this.index;
	}
	
	/**
	 * Set the name of item
	 * @param name Name of item
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Get the name of item
	 * @return name 
	 */
	public String name()
	{
		return this.name;
	}
	
	/**
	 * Set the location where the item at
	 * @param locationId Location id
	 */
	public void setLocationId(Integer locationId)
	{
		this.locationId = locationId;
	}
	
	/**
	 * Get the location where the item at
	 * @return locationId Location id
	 */
	public Integer locationId()
	{
		return this.locationId;
	}
	
	/**
	 * Set the image of item
	 * @param source The url of item image
	 */
	public void setImage(String source)
	{
		this.image = new Image(source);
	}
	
	/**
	 * Get the image of item
	 * @return image
	 */
	public Image image()
	{
		return this.image;
	}
	
	/**
	 * Set the view index where the item at
	 * @param viewIndex view index
	 */
	public void setViewIndex(Integer viewIndex)
	{
		this.viewIndex = viewIndex;
	}
	
	/**
	 * Get the view index where the item at
	 * @return view index
	 */
	public Integer viewIndex()
	{
		return this.viewIndex;
	}
}
