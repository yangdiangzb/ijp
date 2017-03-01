// IJP Assignment 1, Version 6.1.0, 05 Oct 2016
package ijp.controller;

import ijp.Picture;
import ijp.view.View;
import ijp.service.Service;
import ijp.service.ServiceFromProperties;
import ijp.view.ViewFromProperties;
import ijp.utils.Properties;
import java.util.HashMap;

/**
 * Implementing a controller for the PictureViewer application.
 * 
 * @author DianYang 
 * @version 1.0 
 */
public class MyController implements Controller 
{

	private View view;
	private Service service;
	private HashMap<Integer, String> selection;
	
	/**
	 * Create a controller doing nothing
	 */
	public MyController()
	{
		
	}
	
	/**
	 * Start the controller.
	 */
	public void start() 
	{
		// create the view and the service objects
		view = new ViewFromProperties(this);
		service = new ServiceFromProperties();
		selection = new HashMap<>();

		// read the list of Munros from the property file 
		String munrosString = Properties.get("MyController.subjects");
		
		// split the string at each comma to create a list of names
		String[] munrosList = munrosString.split(",");

		// iterate through the list
		for(String munros : munrosList) {
			// remove any leading or trailing spaces from each name
			munros = munros.trim();
			// add selections in the interface
			addSubject(munros);
		}
		
		// start the interface
		view.start();
	}

	/**
	 * Handle the specified selection from the interface.
	 *
	 * @param selectionID the id of the selected item
	 */
	public void select(int selectionID) 
	{
		
		// a picture corresponding to the selectionID
		// by default, this is an empty picture
		// (this is used if the selectionID does not match)
		Picture picture = new Picture();

		// create a picture corresponding to the selectionID
		picture = service.getPicture(selection.get(selectionID),1);
		
		// show the picture in the interface
		view.showPicture(picture);
	}
	
	/**
	 * Store the correspondence between the selection identifier and the name into the HashMap.
	 * 
	 * @param selectionName the name of the selected item
	 */
	private void addSubject(String selectionName)
	{
		// Add the name and ID of selection into HashMap
		selection.put(view.addSelection(selectionName),selectionName);
	}
	
}
