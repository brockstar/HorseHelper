package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mechanics.Dice;
import mechanics.Dice.Result;
import characters.PlayerCharacter;

public class Gui {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {

				// initialize model objects
				PlayerCharacter pc = new PlayerCharacter();

				// create frame
				JFrame frame = new JFrame("Pony Game");

				frame.setSize(new Dimension(500, 300));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// create content panel
				JPanel mainPanel = new JPanel(new BorderLayout());
				frame.add(mainPanel);

				PCPanel pcPanel = new PCPanel(pc);

				mainPanel.add(pcPanel, BorderLayout.WEST);

				JPanel centerpanel = new JPanel();

				JButton staminaButton = new JButton("Stamina");
				JButton agilityButton = new JButton("Agility");
				JButton logicButton = new JButton("Logic");
				JButton creativityButton = new JButton("Creativity");
				JButton wisdomButton = new JButton("Wisdom");
				JButton charismaButton = new JButton("Charisma");

				staminaButton.setActionCommand("stamina");
				agilityButton.setActionCommand("agility");
				logicButton.setActionCommand("logic");
				creativityButton.setActionCommand("creativity");
				wisdomButton.setActionCommand("wisdom");
				charismaButton.setActionCommand("charisma");

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
						System.out.println(pc.toString());

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
								pc.setStamina(skill + 1);
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

				MyListener ml = new MyListener(pc);

				staminaButton.addActionListener(ml);
				agilityButton.addActionListener(ml);
				logicButton.addActionListener(ml);
				creativityButton.addActionListener(ml);
				wisdomButton.addActionListener(ml);
				charismaButton.addActionListener(ml);

				JPanel buttonPanel = new JPanel();

				BoxLayout b = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
				buttonPanel.setLayout(b);

				buttonPanel.add(staminaButton);
				buttonPanel.add(agilityButton);
				buttonPanel.add(logicButton);
				buttonPanel.add(creativityButton);
				buttonPanel.add(wisdomButton);
				buttonPanel.add(charismaButton);

				mainPanel.add(buttonPanel, BorderLayout.EAST);

				JPanel displayPanel = new JPanel();
				JLabel displayLabel = new JLabel("Display Label");

				mainPanel.add(displayPanel, BorderLayout.SOUTH);

				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		};
		EventQueue.invokeLater(runner);
	}
}
