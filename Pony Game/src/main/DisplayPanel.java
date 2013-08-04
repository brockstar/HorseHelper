package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayPanel extends JPanel implements Observer {

	Gamestate	gs;
	JEditorPane	ep	= new JEditorPane();
	JScrollPane	sp	= new JScrollPane(ep);

	public DisplayPanel(Gamestate gs) {
		this.gs = gs;
		gs.pc.addObserver(this);
		gs.cal.addObserver(this);
		setLayout(new GridLayout(0, 1));
		sp.setPreferredSize(new Dimension(100, 100));
		add(sp);

	}

	@Override
	public void update(Observable obs, Object packet) {
		// TODO Auto-generated method stub
		String text = "";
		if (obs.equals(gs.pc)) {
			if (packet instanceof ChangePacket) {
				text = buildText((ChangePacket) packet);
			} else {
				text = "\nYou earned 1 bit.";
			}

		}
		ep.setText(ep.getText() + text);
	}

public String buildText(ChangePacket packet){
	return "\n" + packet.at.toString() + "has increased from " + packet.oldValue + " to " + packet.newValue + ".";
}


}
