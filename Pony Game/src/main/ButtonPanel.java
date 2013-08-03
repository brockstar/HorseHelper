package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import mechanics.Ability.AbilityType;
import mechanics.Dice;
import mechanics.Dice.Result;
import characters.PlayerCharacter;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	
	PlayerCharacter pc;
	
	JButton staminaButton = new JButton("Stamina");
	JButton agilityButton = new JButton("Agility");
	JButton logicButton = new JButton("Logic");
	JButton creativityButton = new JButton("Creativity");
	JButton wisdomButton = new JButton("Wisdom");
	JButton charismaButton = new JButton("Charisma");

	

	final class MyListener implements ActionListener {

		PlayerCharacter pc;
		int difficulty = 10;

		public void actionPerformed(ActionEvent e) {

			switch (e.getActionCommand()) {
			case "stamina":
				skillCheck(e.getActionCommand(), pc.getStamina(),
						difficulty);
				break;
			case "agility":
				skillCheck(e.getActionCommand(), pc.getAgility(),
						difficulty);
				break;
			case "logic":
				skillCheck(e.getActionCommand(), pc.getLogic(),
						difficulty);
				break;
			case "creativity":
				skillCheck(e.getActionCommand(),
						pc.getCreativity(), difficulty);
				break;
			case "wisdom":
				skillCheck(e.getActionCommand(), pc.getWisdom(),
						difficulty);
				break;
			case "charisma":
				skillCheck(e.getActionCommand(), pc.getCharisma(),
						difficulty);
				break;
			default:
				break;
			}

		}

		// constructor
		public MyListener(PlayerCharacter pc) {
			this.pc = pc;
			

		}

		public void skillCheck(String attribute, int skill,
				int difficulty) {
			Result r = Dice.contest(skill, difficulty);

			while (r.equals(Result.TIE)) {
				r = Dice.contest(skill, difficulty);
			}

			if (r.equals(Result.FAILURE)) {
				switch (attribute) {
				case "stamina":
					pc.increaseStat(AbilityType.STAMINA, 1);
					break;
				case "agility":
					pc.setAgility(skill + 1);
					break;
				case "logic":
					pc.setLogic(skill + 1);
					break;
				case "creativity":
					pc.setCreativity(skill + 1);
					break;
				case "wisdom":
					pc.setWisdom(skill + 1);
					break;
				case "charisma":
					pc.setCharisma(skill + 1);
					break;
				default:
					break;
				}

			} else if (r.equals(Result.SUCCESS))
				pc.setBits(pc.getBits() + 1);

		}

	}
	;

	MyListener ml;

	
	
	public ButtonPanel(PlayerCharacter apc){
		
		this.pc = apc;
		ml = new MyListener(pc);
		
		
		
		staminaButton.setActionCommand("stamina");
		agilityButton.setActionCommand("agility");
		logicButton.setActionCommand("logic");
		creativityButton.setActionCommand("creativity");
		wisdomButton.setActionCommand("wisdom");
		charismaButton.setActionCommand("charisma");
		
		staminaButton.addActionListener(ml);
		agilityButton.addActionListener(ml);
		logicButton.addActionListener(ml);
		creativityButton.addActionListener(ml);
		wisdomButton.addActionListener(ml);
		charismaButton.addActionListener(ml);

		BoxLayout b = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(b);

		add(staminaButton);
		add(agilityButton);
		add(logicButton);
		add(creativityButton);
		add(wisdomButton);
		add(charismaButton);
	}
}
