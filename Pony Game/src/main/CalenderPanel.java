package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mechanics.Calender;

public class CalenderPanel extends JPanel implements Observer {

	Calender	c;

	JLabel	yearLabel		= new JLabel();
	JLabel	monthLabel		= new JLabel();
	JLabel	weekLabel		= new JLabel();
	JLabel	dayLabel			= new JLabel();
	JLabel	timeOfDayLabel	= new JLabel();

	JLabel	seasonLabel		= new JLabel();

	public CalenderPanel( Calender input ){
		c = input;

		add(yearLabel);
		add(monthLabel);
		add(weekLabel);
		add(dayLabel);
		add(timeOfDayLabel);

		add(seasonLabel);

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
