package main;

import java.util.Observable;
import java.util.Observer;

import mechanics.GameDate;
import characters.Applejack;
import characters.Fluttershy;
import characters.PinkiePie;
import characters.PlayerCharacter;
import characters.RainbowDash;
import characters.Rarity;
import characters.TwilightSparkle;

public class Gamestate extends Observable implements Observer{

	PlayerCharacter	pc				= new PlayerCharacter();
	GameDate		cal				= new GameDate();

	Applejack		applejack		= new Applejack();
	RainbowDash		rainbowDash		= new RainbowDash();
	TwilightSparkle	twilightSparkle	= new TwilightSparkle();
	Rarity			rarity			= new Rarity();
	Fluttershy		fluttershy		= new Fluttershy();
	PinkiePie		pinkiePie		= new PinkiePie();

	String console = "";
	
	public Gamestate() {
		pc.addObserver(this);
		cal.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object obj) {
		// TODO Auto-generated method stub
		String arg;
		if(obs.equals(pc)){
			notifyObservers("The PC has ");
		}
		if(obs.equals(cal)){
			console = "\nThe calendar has changed.";
		}
		setChanged();
		
	}

}
