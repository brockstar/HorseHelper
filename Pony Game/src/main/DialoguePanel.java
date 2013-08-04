package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mechanics.Dialogue;

@SuppressWarnings("serial")
public class DialoguePanel extends JPanel implements Observer {

	Dialogue	currentDialogue;

	JPanel		topPanel		= new JPanel();
	JPanel		sayingsPanel	= new JPanel();

	JScrollPane	sc				= new JScrollPane(sayingsPanel);

	Box			bottomPanel		= Box.createHorizontalBox();

	public DialoguePanel() {
		setLayout(new BorderLayout());

		topPanel.setLayout(new GridLayout(0, 1));
		sc.setPreferredSize(new Dimension(100, 100));
		topPanel.setBorder(BorderFactory.createTitledBorder("Conversation"));
		topPanel.add(sc);

		sayingsPanel.setLayout(new BoxLayout(sayingsPanel, BoxLayout.Y_AXIS));

		add(topPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		bottomPanel = Box.createHorizontalBox();
		bottomPanel.setBorder(BorderFactory.createTitledBorder("Options"));

	}

	public void update(Observable obs, Object dialogue) {
		if (dialogue instanceof Dialogue) {
			currentDialogue = (Dialogue) dialogue;
			runDialogue(currentDialogue);
		}
	}

	public void runDialogue(Dialogue dialogue) {
		invalidate();

		if (dialogue == null) {
			clearPanels();
		} else {

			JPanel say = new JPanel();
			say.setPreferredSize(new Dimension(400, 50));
			say.setMaximumSize(new Dimension(400, 50));
			say.setMinimumSize(new Dimension(300, 100));
			say.setBorder(BorderFactory.createTitledBorder(dialogue.characterName));
			JLabel sayLabel = new JLabel(dialogue.text);
			say.add(sayLabel);
			sayingsPanel.add(say);

			bottomPanel.removeAll();

			if (dialogue.options == null) {
				JButton b = new JButton("Done");
				ActionListener a = new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						runDialogue(null);
					}

				};
				b.addActionListener(a);
				bottomPanel.add(b);
			} else {

				for (Dialogue d : dialogue.options) {
					JButton b = new JButton(d.optionName);
					ButtonListener l = new ButtonListener(this);
					l.d = d;
					b.addActionListener(l);
					bottomPanel.add(b);
				}

			}
			add(bottomPanel, BorderLayout.SOUTH);

			revalidate();
			repaint();
		}
	}

	public void clearPanels() {

		sayingsPanel.removeAll();
		bottomPanel.removeAll();

		revalidate();
		repaint();

	}

	private class ButtonListener extends Observable implements ActionListener {

		// DialoguePanel p;
		Dialogue	d;

		public ButtonListener(DialoguePanel p) {
			// this.p = p;
		}

		public void actionPerformed(ActionEvent e) {
			runDialogue(d);
		}
	}
}
