package characters;

import abilities.Ability.AbilityType;

public class RainbowDash implements Workable {

	String	primaryStat	= "agility";

	String	greeting		= "What's goin' on?";

	public AbilityType getPrimaryStat() {
		return AbilityType.AGILITY;
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
		// "Show me that you can be tough AND fast!"
	}

	public void agilityActivity() {
		randomActivity();
	}

	public void logicActivity() {
		// "This problem's making my head hurt! Can you take care of it?"
	}

	public void creativityActivity() {
		// "Today, I want to see some of your fancier moves. C'mon, show me what you got!"
	}

	public void wisdomActivity() {
		// "Yeah, yeah, I got this one. But if you feel like helping, don't let me stop you."
	}

	public void charismaActivity() {
		// "A pony with some style should do just fine for this one."
	}

	public void socialActivity() {
		// "Oh hey. I was on my way somewhere, but I guess I could hang out for a while."
	}

}
