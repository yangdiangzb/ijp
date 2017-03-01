//IJP AssignMent 2, Version 1.1, 27 Nov 2016 

package world;

import location.Location;
import view.View;
import door.Door;
import item.Item;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implementing the world class and initialising the world
 * @author s1626297
 * @version 1.1
 */
public class World 
{
	
	private HashMap<Integer,Location> locationMap;
	private HashMap<String,String> doorMap;
	private List<Item> itemList;
	private View currentView;
	private Image mapView;
	
	/**
	 * Create a world with location HashMap, 
	 */
	public World()
	{
		locationMap = new HashMap<Integer,Location>();
		doorMap = new HashMap<String,String>();
		itemList = new ArrayList<Item>();
		currentView = new View();
	}
	
	/**
	 * world initialising
	 */
	public void init()
	{
		/*
		 * Create Locations and add views to each location
		 */
		Location location1 = new Location(480.0, 415.0, "Bathroom");
		Location location2 = new Location(542.0, 415.0, "Bedroom");
    	Location location3 = new Location(600.0, 415.0, "Kitchen");
    	Location location4 = new Location(480.0, 465.0, "Hall");
    	Location location5 = new Location(542.0, 465.0, "Hall");
    	Location location6 = new Location(600.0, 465.0, "Hall");
  
    	location1.addView(0, new View("pictures/room1_0.jpg", 0, 1));
    	location1.addView(1, new View("pictures/room1_1.jpg", 1, 1));
    	location1.addView(2, new View("pictures/room1_2.jpg", 2, 1));
    	location1.addView(3, new View("pictures/room1_3.jpg", 3, 1));
    	location2.addView(0, new View("pictures/room2_0.jpg", 0, 2));
    	location2.addView(1, new View("pictures/room2_1.jpg", 1, 2));
    	location2.addView(2, new View("pictures/room2_2.jpg", 2, 2));
    	location2.addView(3, new View("pictures/room2_3.jpg", 3, 2));
    	location3.addView(0, new View("pictures/room3_0.jpg", 0, 3));
    	location3.addView(1, new View("pictures/room3_1.jpg", 1, 3));
    	location3.addView(2, new View("pictures/room3_2.jpg", 2, 3));
    	location3.addView(3, new View("pictures/room3_3.jpg", 3, 3));
    	location4.addView(0, new View("pictures/hall1_0.jpg", 0, 4));
    	location4.addView(1, new View("pictures/hall1_1.jpg", 1, 4));
    	location4.addView(2, new View("pictures/hall1_2.jpg", 2, 4));
    	location4.addView(3, new View("pictures/hall1_3.jpg", 3, 4));
    	location4.addView(4, new View("pictures/hall1_4.jpg", 4, 4));
    	location5.addView(0, new View("pictures/hall2_0.jpg", 0, 5));
    	location5.addView(1, new View("pictures/hall2_1.jpg", 1, 5));
    	location5.addView(2, new View("pictures/hall2_2.jpg", 2, 5));
    	location5.addView(3, new View("pictures/hall2_3.jpg", 3, 5));
    	location6.addView(0, new View("pictures/hall3_0.jpg", 0, 6));
    	location6.addView(1, new View("pictures/hall3_1.jpg", 1, 6));
    	location6.addView(2, new View("pictures/hall3_2.jpg", 2, 6));
    	location6.addView(3, new View("pictures/hall3_3.jpg", 3, 6));
    	
    	/*
    	 * add each location to locationMap
    	 */
    	this.addLocation(1, location1);
		this.addLocation(2, location2);
		this.addLocation(3, location3);
		this.addLocation(4, location4);
		this.addLocation(5, location5);
		this.addLocation(6, location6);
		
		/*
		 * Create door relationships
		 */
    	Door door1 = new Door(1, 3, 4, 4);
		Door door2 = new Door(4, 2, 1, 1);
		Door door3 = new Door(2, 3, 5, 3);
		Door door4 = new Door(5, 1, 2, 1);
		Door door5 = new Door(3, 3, 6, 3);
		Door door6 = new Door(6, 1, 3, 1);
		Door door7 = new Door(4, 3, 5, 2);
		Door door8 = new Door(5, 0, 4, 0);
		Door door9 = new Door(5, 2, 6, 2);
		Door door10 = new Door(6, 0, 5, 0);
		
		/*
		 * Add each door relationship to doorMap
		 */
		this.addDoor(door1.currentPosition(), door1.nextPosition());
		this.addDoor(door2.currentPosition(), door2.nextPosition());
		this.addDoor(door3.currentPosition(), door3.nextPosition());
		this.addDoor(door4.currentPosition(), door4.nextPosition());
		this.addDoor(door5.currentPosition(), door5.nextPosition());
		this.addDoor(door6.currentPosition(), door6.nextPosition());
		this.addDoor(door7.currentPosition(), door7.nextPosition());
		this.addDoor(door8.currentPosition(), door8.nextPosition());
		this.addDoor(door9.currentPosition(), door9.nextPosition());
		this.addDoor(door10.currentPosition(), door10.nextPosition());
		
		/*
		 * Create Items
		 */
		Item item1 = new Item("Cattie","pictures/cattie.png", 0, 0, 0);
		Item item2 = new Item("Doggie","pictures/doggie.png", 0, 0, 1);
		Item item3 = new Item("Rabbit","pictures/rabbit.png", 0, 0, 2);
		
		/*
		 * Add items into itemMap
		 */
		this.addItem(item1);
		this.addItem(item2);
		this.addItem(item3);
	
		/*
		 * Set the initial view
		 */
		this.currentView = this.getLocation(5).getView(3);
		/*
		 * Set the logic map image
		 */
		this.mapView = new Image("pictures/map.png");
	}
	
	/**
	 * Add door to door HashMap
	 * @param currentPosition CurrentPosition String
	 * @param nextPosition NextPosition String
	 */
	public void addDoor(String currentPosition, String nextPosition)
	{
		this.doorMap.put(currentPosition, nextPosition);
	}
	
	/**
	 * Add location to location HashMap
	 * @param locationId The index of location
	 * @param location The location
	 */
	public void addLocation(Integer locationId, Location location) 
	{
		this.locationMap.put(locationId, location);
	}
	
	/**
	 * Get location by location index 
	 * @param locationId The index of location
	 * @return location
	 */
	public Location getLocation(Integer locationId)
	{
		return this.locationMap.get(locationId);
	}
	
	/**
	 * Get the door relationship HashMap 
	 * @return doorMap
	 */
	public HashMap<String, String> doorMap()
	{
		return this.doorMap;
	}
	
	/**
	 * Get the location HashMap
	 * @return locationMap
	 */
	public HashMap<Integer,Location> locationMap()
	{
		return this.locationMap;
	}
	
	/**
	 * Add items into the item list
	 * @param item Item
	 */
	public void addItem(Item item)
	{
		this.itemList.add(item);
	}
	
	/**
	 * Get the item list
	 * @return itemList
	 */
	public List<Item> itemList()
	{
		return this.itemList;
	}
	
	/**
	 * Get the currentView
	 * @return currentView
	 */
	public View currentView()
	{
		return this.currentView;
	}
	
	/**
	 * Set the currentView with new View
	 * @param newView The new view
	 */
	public void setCurrentView(View newView)
	{
		this.currentView = newView;
		
	}
	
	/**
	 * Get the logic map view
	 * @return mapView
	 */
	public Image mapView()
	{
		return this.mapView;
	}
}
