package mechanics;

import characters.PlayerCharacter;

public class Activity {

	Ability			primary;
	Ability			secondary;

	public String	intro;

	public String	p1start;
	public String	p1win;
	public String	p1lose;

	public String	p2Astart;
	public String	p2Awin;
	public String	p2Alose;

	public String	p2Bstart;
	public String	p2Bwin;
	public String	p2Blose;

	public String	p3AAstart;
	public String	p3AAwin;
	public String	p3AAlose;

	public String	p3ABstart;
	public String	p3ABwin;
	public String	p3ABlose;

	public String	p3BAstart;
	public String	p3BAwin;
	public String	p3BAlose;

	public String	p3BBstart;
	public String	p3BBwin;
	public String	p3BBlose;

	public Activity( Ability primary,Ability secondary ){
		this.primary = primary;
		this.secondary = secondary;
	};

	public void perform(PlayerCharacter pc) {

	}

}
