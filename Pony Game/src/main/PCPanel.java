package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import characters.PlayerCharacter;

public class PCPanel extends JPanel implements Observer {

	PlayerCharacter	pc;
	JLabel				playerNameLabel	= new JLabel("PlayerName");
	JLabel				staminaLabel		= new JLabel("Stamina:");
	JLabel				agilityLabel		= new JLabel("Agility:");
	JLabel				logicLabel			= new JLabel("Logic: ");
	JLabel				creativityLabel	= new JLabel("Creativity: ");
	JLabel				wisdomLabel			= new JLabel("Wisdom: ");
	JLabel				charismaLabel		= new JLabel("Charisma: ");

	public PCPanel( PlayerCharacter inputPC ){
		inputPC.addObserver(this);
		this.pc = inputPC;
		setBorder(BorderFactory.createTitledBorder("Player Character Panel"));

		add(playerNameLabel);
		add(staminaLabel);
		add(agilityLabel);
		add(logicLabel);
		add(creativityLabel);
		add(wisdomLabel);
		add(charismaLabel);

		update(null, null);
	}

	public void update(Observable gamestate, Object obj) {
		playerNameLabel.setText("Name: " + pc.name);
		staminaLabel.setText("Stamina: " + pc.stamina);
		agilityLabel.setText("Agility: " + pc.agility);
		logicLabel.setText("Logic " + pc.logic);
		creativityLabel.setText("Creativity: " + pc.creativity);
		wisdomLabel.setText("Wisdom: " + pc.wisdom);
		charismaLabel.setText("Charisma: " + pc.charisma);

		revalidate();
		repaint();
	}
}
