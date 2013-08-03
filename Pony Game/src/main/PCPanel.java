package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import characters.PlayerCharacter;

@SuppressWarnings("serial")
public class PCPanel extends JPanel implements Observer {

	PlayerCharacter	pc;
	JLabel				playerNameLabel	= new JLabel("PlayerName");
	JLabel				staminaLabel		= new JLabel("Stamina:");
	JLabel				agilityLabel		= new JLabel("Agility:");
	JLabel				logicLabel			= new JLabel("Logic: ");
	JLabel				creativityLabel	= new JLabel("Creativity: ");
	JLabel				wisdomLabel			= new JLabel("Wisdom: ");
	JLabel				charismaLabel		= new JLabel("Charisma: ");
	
	JLabel				bitsLabel			= new JLabel("Bits: ");

	

	public PCPanel( PlayerCharacter inputPC ){
		inputPC.addObserver(this);
		this.pc = inputPC;
		setBorder(BorderFactory.createTitledBorder("Player Character Panel"));

		BoxLayout b = new BoxLayout(this,BoxLayout.Y_AXIS);
		setLayout(b);
		
		add(playerNameLabel);
		add(staminaLabel);
		add(agilityLabel);
		add(logicLabel);
		add(creativityLabel);
		add(wisdomLabel);
		add(charismaLabel);
		add(bitsLabel);
		
				

		update(null, null);
	}

	public void update(Observable gamestate, Object obj) {
		playerNameLabel.setText("Name: " + pc.getName());
		staminaLabel.setText("Stamina: " + pc.getStamina());
		agilityLabel.setText("Agility: " + pc.getAgility());
		logicLabel.setText("Logic " + pc.getLogic());
		creativityLabel.setText("Creativity: " + pc.getCreativity());
		wisdomLabel.setText("Wisdom: " + pc.getWisdom());
		charismaLabel.setText("Charisma: " + pc.getCharisma());
		
		bitsLabel.setText("Bits: " + pc.getBits());
		

		revalidate();
		repaint();
	}
}
