package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mechanics.Dialogue;

@SuppressWarnings("serial")
public class DialoguePanel extends JPanel implements Observer {

	Dialogue		currentDialogue;

	JPanel		topPanel			= new JPanel();
	JEditorPane	sayingsPane	= new JEditorPane();
	JScrollPane	sc					= new JScrollPane(sayingsPane);

	Box			bottomPanel		= Box.createHorizontalBox();

	public DialoguePanel(){
		setLayout(new BorderLayout());

		topPanel.setLayout(new GridLayout(0, 1));

		topPanel.setBorder(BorderFactory.createTitledBorder("Conversation"));
		topPanel.add(sc);

		add(topPanel, BorderLayout.CENTER);

		bottomPanel = Box.createHorizontalBox();
		bottomPanel.setBorder(BorderFactory.createTitledBorder("Options"));

		add(bottomPanel, BorderLayout.SOUTH);

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

			sayingsPane.setText(sayingsPane.getText() + dialogue.characterName + ":\n\t" + dialogue.text + "\n");

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
					ButtonListener l = new ButtonListener();
					l.d = d;
					b.addActionListener(l);
					bottomPanel.add(b);
				}
			}

			revalidate();
			repaint();
		}
	}

	public void clearPanels() {

		sayingsPane.setText("");
		bottomPanel.removeAll();

		revalidate();
		repaint();

	}

	private class ButtonListener extends Observable implements ActionListener {

		Dialogue	d;

		public void actionPerformed(ActionEvent e) {
			runDialogue(d);
		}
	}
}
