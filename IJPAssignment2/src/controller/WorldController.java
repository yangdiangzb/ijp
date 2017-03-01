//IJP AssignMent 2, Version 1.1, 27 Nov 2016 
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import java.util.HashMap;
import item.Item;
import world.World;
/**
 * Implementing a controller 
 * @author s1626297
 * @version 1.1
 */

public class WorldController 
{
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView itemView1;
	@FXML
	private ImageView itemView2;
	@FXML
	private ImageView itemView3;
	@FXML
	private ImageView mapView;
	@FXML
	private Button forwardButton;
	@FXML
	private MenuButton menuButton;
	@FXML
	private Circle positionMark;
	@FXML
	private Label message;
	
	/*
	 * Create world
	 */
	private World world = new World();
	private HashMap<Item,ImageView> itemViewList;
	
	/**
	 * Initialise the our interface 
	 */
	public void initialise() 
	{
		world.init();
		
		/*
		 * Set images of all imageViews
		 */
		imageView.setImage(world.currentView().image());
		mapView.setImage(world.mapView());
		itemView1.setImage(world.itemList().get(0).image());
		itemView2.setImage(world.itemList().get(1).image());
		itemView3.setImage(world.itemList().get(2).image());
		
		/*
		 * Set item views unvisible first
		 */
		itemView1.setVisible(false);
		itemView2.setVisible(false);
		itemView3.setVisible(false);
		
		/*
		 * Create a itemView HashMap
		 */
		itemViewList = new HashMap<Item,ImageView>();
		itemViewList.put(world.itemList().get(0), itemView1);
		itemViewList.put(world.itemList().get(1), itemView2);
		itemViewList.put(world.itemList().get(2), itemView3);
		
        checkButton();
        printMessage();
	}
	
	/**
	 * Put down a portable item
	 * @param event
	 */
    public void putDown(ActionEvent event) 
    {
    	MenuItem mi = (MenuItem)event.getSource();
    	
    	//get the text of menuItem
    	
  
    	String text = mi.getText();
    	/*
    	 * For each item, check whether it's available to put down and put down
    	 */
    	for(Item item: world.itemList()) {
    		if((text.equals(item.name())) && (item.locationId() == 0) && (item.viewIndex() == 0) ) {
    			itemViewList.get(item).setVisible(true);
    			item.setViewIndex(world.currentView().index());
    			item.setLocationId(world.currentView().locationId());
    		}
    	}
    	printMessage();
    }
    
    /**
     * Pick up a portable item
     * @param event
     */
    public void pickUp(ActionEvent event) 
    {
    	MenuItem mi = (MenuItem)event.getSource();
    	
    	//get the text of menuItem
    	String text = mi.getText();
    	
    	/*
    	 * For each item, check whether it's available to pick up and pick up
    	 */
    	for(Item item: world.itemList()){
    		if((text.equals(item.name())) && (item.viewIndex() == world.currentView().index()) && (item.locationId() == world.currentView().locationId()) ) {
    			itemViewList.get(item).setVisible(false);
    			item.setViewIndex(0);
    			item.setLocationId(0);
    		}
    	}
    	printMessage();
    }
    
    /**
     * Check if the item is in current view
     */
    public void checkItem(){
    	for(Item item: world.itemList() )
    	{
    		if((item.viewIndex() == world.currentView().index()) && (item.locationId()==world.currentView().locationId()) ) {
    			itemViewList.get(item).setVisible(true);
    		} else if ((item.viewIndex() != world.currentView().index()) || (item.locationId() != world.currentView().locationId()) ) {
    			itemViewList.get(item).setVisible(false);
    		}
    	}
    }
    
    /**
     * Turn right
     * @param event
     */
    public void turnRight(ActionEvent event) 
    {
    	int index = world.currentView().index();
    	int locationId = world.currentView().locationId();
    	
    	//find the next view in current location
    	int nextIndex = (index + 1) % world.getLocation(locationId).getSize();
    	world.setCurrentView(world.getLocation(locationId).getView(nextIndex));
    	imageView.setImage(world.currentView().image());
    	checkButton();
    	checkItem();
    	checkPosition();
    	printMessage();
    }
    
    /**
     * Turn left 
     * @param event
     */
    public void turnLeft(ActionEvent event)
    {
    	int index = world.currentView().index();
    	int locationId = world.currentView().locationId();
    	
    	//find the last view in current location
    	int nextIndex = (index + world.getLocation(locationId).getSize() - 1) % world.getLocation(locationId).getSize();
    	world.setCurrentView(world.getLocation(locationId).getView(nextIndex));
    	imageView.setImage(world.currentView().image());
    	checkButton();
    	checkItem();
    	checkPosition();
    	printMessage();
    }
    
    /**
     * move forward
     * @param event
     */
    public void moveForward(ActionEvent event)
    {
    	Integer index = world.currentView().index();
    	Integer locationId = world.currentView().locationId(); 
    	String currentPosition = locationId.toString() + index.toString();
    	
    	//find the next position in door relationship HashMap
    	String nextPosition = world.doorMap().get(currentPosition);
    	Integer nextLocationId = nextPosition.charAt(0) - '0';
    	Integer nextIndex = nextPosition.charAt(1) - '0';
    	
    	world.setCurrentView(world.getLocation(nextLocationId).getView(nextIndex));
    	imageView.setImage(world.currentView().image());
    	
    	checkButton();
    	checkItem();
    	checkPosition();
    	printMessage();
    }
    /**
     * Check if current view has the forward function and enable or disable the forward button
     */
    public void checkButton()
    {
    	Integer index = world.currentView().index();
    	Integer locationId = world.currentView().locationId(); 
    	String currentPosition = locationId.toString() + index.toString();
    	
    	//check if currentPostion in door relationship HashMap
    	if(world.doorMap().get(currentPosition) == null) {
    		forwardButton.setDisable(true);
    	} else {
    		forwardButton.setDisable(false);
    	}
    }
    
    /**
     * Check the position of current view and set the coordinate in the logic map
     */
    public void checkPosition()
    {
    	positionMark.setLayoutX(world.getLocation(world.currentView().locationId()).positionX());
    	positionMark.setLayoutY(world.getLocation(world.currentView().locationId()).positionY());
    }
    
    /**
     * Print some messages for instruction
     */
    public void printMessage()
    {
    	String tempMessage;
    	tempMessage = "You are in the " + world.getLocation(world.currentView().locationId()).name() + ".\n";
    	for(Item item : world.itemList()) {
    		if((item.locationId() == 0) && (item.viewIndex() == 0)) {
    			tempMessage += "Item " + item.name() + " is ready to put down.\n";
    		} else{
    			tempMessage += "Item " + item.name() + " is in the " + world.getLocation(item.locationId()).name() + " , pls find it.\n"; 
    		}
    	}
    	message.setText(tempMessage);
    }
}
