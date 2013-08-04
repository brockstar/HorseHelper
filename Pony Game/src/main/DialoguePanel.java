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

public class DialoguePanel extends JPanel implements Observer {

	JPanel		topPanel			= new JPanel();
	JPanel		dialoguePanel	= new JPanel();

	JScrollPane	sc					= new JScrollPane(dialoguePanel);

	Box			bottomPanel		= Box.createHorizontalBox();

	public DialoguePanel(){
		setLayout(new BorderLayout());

		topPanel.setLayout(new GridLayout(0, 1));
		sc.setPreferredSize(new Dimension(100, 100));
		topPanel.add(sc);

		dialoguePanel.setLayout(new BoxLayout(dialoguePanel, BoxLayout.Y_AXIS));

		add(topPanel, (BorderLayout.NORTH));
		add(bottomPanel, BorderLayout.SOUTH);

	}

	public void update(Observable obs, Object dialogue) {
		if (dialogue instanceof Dialogue) {
			runDialogue((Dialogue) dialogue);
		} else {
			clearPanels();
		}
	}

	public void runDialogue(Dialogue dialogue) {
		JPanel say = new JPanel();
		say.setBorder(BorderFactory.createTitledBorder(dialogue.characterName));
		JLabel sayLabel = new JLabel(dialogue.text);
		say.add(sayLabel);
		dialoguePanel.add(say);

		bottomPanel = Box.createHorizontalBox();

		for (Dialogue d : dialogue.options) {
			JButton b = new JButton(d.optionName);
			ButtonListener l = new ButtonListener(this);
			b.addActionListener(l);
			bottomPanel.add(b);
		}
	}

	public void clearPanels() {
		dialoguePanel = new JPanel();
		bottomPanel = Box.createHorizontalBox();
	}

	private class ButtonListener extends Observable implements ActionListener {

		DialoguePanel	p;

		public ButtonListener( DialoguePanel p ){
			this.p = p;
		}

		public void actionPerformed(ActionEvent e) {
			p.update(null, e.getSource());
		}
	}
}
