//IJP AssignMent 2, Version 1.1, 27 Nov 2016 
package location;

import java.util.HashMap;
import view.View;

/**
 * Implementing a location class to save all views in the location and the position in logic map.
 *
 * @author s1626297
 * @version 1.1 
 */
public class Location 
{
	
	private HashMap<Integer,View> viewMap;
	private double positionX;
	private double positionY;
	private String name;
	
	/**
	 * Create a location doing nothing
	 */
	public Location()
	{
		
	}
	
	/**
	 * Create a location with the position in logic map and location name
	 * @param positionX the x coordinate of the position in logic map
	 * @param positionY the y coordinate of the position in logic map
	 * @param name the name of the location
	 */
	public Location(double positionX,double positionY,String name)
	{
		viewMap = new HashMap<Integer,View>();
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.setName(name);
	}
	
	/**
	 * Add a view in view hashMap
	 * @param index the index of the view in this location
	 * @param view the view
	 */
	public void addView(Integer index,View view) 
	{
		this.viewMap.put(index, view);
	}
	
	/**
	 * Return the view with index in view hashMap
	 * @param index Index of the view
	 * @return the view
	 */
	public View getView(Integer index)
	{
		return this.viewMap.get(index);
	}
	
	/**
	 * Return the size of the view hashMap
	 * @return the size of the view hashMap
	 */
	public Integer getSize()
	{
		return this.viewMap.size();
	}
	
	/**
	 * set the x coordinate of position in the logic map
	 * @param positionX x coordinate of position in the logic map
	 */
	public void setPositionX(double positionX)
	{
		this.positionX = positionX;
	}
	
	/**
	 * set the y coordinate of the position in the logic map
	 * @param positionY y coordinate of the position in the logic map
	 */
	public void setPositionY(double positionY)
	{
		this.positionY = positionY;
	}
	
	/**
	 * return the x coordinate of the position in the logic map
	 * @return x coordinate of the position in the logic map
	 */
	public double positionX()
	{
		return this.positionX;
	}
	
	/**
	 * return the y coordinate of the position in the logic map
	 * @return y coordinate of the position in the logic map
	 */
	public double positionY()
	{
		return this.positionY;
	}
	
	/**
	 * set the name of location
	 * @param name the name of location
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * return the name of location
	 * @return the name of location
	 */
	public String name()
	{
		return this.name;
	}
}
