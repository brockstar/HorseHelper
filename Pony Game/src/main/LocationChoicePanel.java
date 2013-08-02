package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import characters.PlayerCharacter;

public class LocationChoicePanel extends JPanel implements Observer{

	
	PlayerCharacter pc;
	
	public LocationChoicePanel(PlayerCharacter inputPC){
		this.pc = inputPC;
		inputPC.addObserver(this);
	}
	
	public void update(Observable arg0, Object arg1) {
		
	}

}
