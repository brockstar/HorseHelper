package characters;

import abilities.Ability.AbilityType;

public interface Workable {

	public AbilityType getPrimaryStat();
	
	public void randomActivity();

	public void staminaActivity();

	public void agilityActivity();

	public void logicActivity();

	public void creativityActivity();

	public void wisdomActivity();

	public void charismaActivity();

	public void socialActivity();

}
