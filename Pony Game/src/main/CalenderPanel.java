package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mechanics.GameDate;

public class CalenderPanel extends JPanel implements Observer {

	GameDate			c;

	JLabel			yearLabel			= new JLabel();
	JLabel			monthLabel			= new JLabel();
	JLabel			weekLabel			= new JLabel();
	JLabel			dayLabel				= new JLabel();
	JLabel			timeOfDayLabel		= new JLabel();

	JLabel			seasonLabel			= new JLabel();

	JButton			testButton			= new JButton("Advance");

	ActionListener	advanceListener	= new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														c.advanceTime();
													}
												};

	public CalenderPanel( GameDate input ){
		input.addObserver(this);
		c = input;

		add(yearLabel);
		add(monthLabel);
		add(weekLabel);
		add(dayLabel);
		add(timeOfDayLabel);

		add(seasonLabel);

		add(testButton);
		testButton.addActionListener(advanceListener);

		update(null, null);

	}

	public void update(Observable o, Object arg) {
		yearLabel.setText("Year " + c.getYear());
		monthLabel.setText("Month: " + c.getMonth().print());
		weekLabel.setText("Week: " + c.getWeek().print());
		dayLabel.setText("Day: " + c.getDay().print());
		timeOfDayLabel.setText("Time: " + c.getTimeOfDay().print());
	}

}
