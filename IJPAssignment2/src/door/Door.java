//IJP AssignMent 2, Version 1.1, 27 Nov 2016 

package door;

/**
 * Implementing a door class which create the relationship from location to location
 * @author s1626297
 * @version 1.1
 */

public class Door 
{
	private String currentPosition;
	private String nextPosition;
	
	/**
	 * Create a door doing nothing
	 */
	public Door()
	{
		
	}
	
	/**
	 * Create a door with current position and next position
	 * @param locationId Location id 
	 * @param viewId View id
	 * @param nextLocationId Location id after going through the door
	 * @param nextViewId View id after going through the door
	 */
	public Door(Integer locationId, Integer viewId, Integer nextLocationId,Integer nextViewId)
	{
		this.currentPosition = locationId.toString() + viewId.toString();
		this.nextPosition = nextLocationId.toString() + nextViewId.toString();
	}
	
	/**
	 * Get the current position 
	 * @return current position string
	 */
	public String currentPosition()
	{
		return this.currentPosition;
	}
	
	/**
	 * Get the next position
	 * @return next position string
	 */
	public String nextPosition()
	{
		return this.nextPosition;
	}
}

