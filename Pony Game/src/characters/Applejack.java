package characters;

import abilities.Ability;
import abilities.Ability.AbilityType;

public class Applejack implements Workable {

	String	greeting	= "Hey there, sugarcube!";

	public AbilityType getPrimaryStat() {
		return AbilityType.STAMINA;
	}

	public void randomActivity() {
		int random = (int) (Math.random() * 6);
		if (random == 0) {
			staminaActivity();
		} else if (random == 1) {
			agilityActivity();
		} else if (random == 2) {
			logicActivity();
		} else if (random == 3) {
			creativityActivity();
		} else if (random == 4) {
			wisdomActivity();
		} else if (random == 5) {
			charismaActivity();
		} else {
			randomActivity();
		}
	}

	public void staminaActivity() {
		randomActivity();
	}

	public void agilityActivity() {
		// "I'm gonna need ya to be quick on this one!"
	}

	public void logicActivity() {
		// "Let's put our head together and see if we can figure this one out!"
	}

	public void creativityActivity() {
		// "I reckon we could use your skills a puttin' a personal touch on things."
	}

	public void wisdomActivity() {
		// "I've been ponderin' how best to get this one done."
	}

	public void charismaActivity() {
		// "I need a feller who can get somepony's attention."
	}

	public void socialActivity() {
		// "Well now, if it isn't the new pny in town. Whatcha doin' here anyhow?"
	}

}
