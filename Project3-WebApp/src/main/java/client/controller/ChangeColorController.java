package client.controller;

import java.awt.Color;
import client.constants.ClientConstants;
import client.view.ColorSelectorButton;
import client.view.ColorSelectorButton.ColorChangedListener;

/**
 * Controller for changing the color of the graph
 */
public class ChangeColorController {
	public ChangeColorController(final ColorSelectorButton button) {
		button.addColorChangedListener(new ColorChangedListener() {
			
		    public void colorChanged(Color newColor) {
		    		if(button.getName() == "Meditation"){
		    			ClientConstants.meditationColor = newColor;
		    		}
		    		else if(button.getName() == "Engagement"){
		    			ClientConstants.engagementColor = newColor;
		    		}
		    		else if(button.getName() == "Frustation"){
		    			ClientConstants.frustationColor = newColor;
		    		}
		    		else if(button.getName() == "Excitement Short Term"){
		    			ClientConstants.excitementShortTermColor = newColor;
		    		}
		    		else if(button.getName() == "Excitement Long Term"){
		    			ClientConstants.excitementLongTermColor = newColor;
		    		}
		    }
		});
	}
}
