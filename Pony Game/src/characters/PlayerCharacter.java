package characters;

import java.util.Observable;

import main.ChangePacket;
import abilities.Ability.AbilityType;
import abilities.Agility;
import abilities.Stamina;


public class PlayerCharacter extends Observable {

	private String	name			= "PC Pony";

	private int		stamina		= 2;
	private int		agility		= 2;

	private int		logic			= 2;
	private int		creativity	= 2;

	private int		wisdom		= 2;
	private int		charisma		= 2;

	private int		honesty		= 0;
	private int		kindness		= 0;
	private int		laughter		= 0;
	private int		generocity	= 0;
	private int		loyalty		= 0;
	private int		magic			= 0;

	private int		bits			= 0;
	private int		gems			= 0;

	private void changed(ChangePacket cp) {
		setChanged();
		notifyObservers(cp);
	}

	private void changed() {
		setChanged();
		notifyObservers();
	}
	public void increaseStat(AbilityType type, int amount) {
		switch (type) {
			case STAMINA:
				setStamina(getStamina() + amount);
				break;
			case AGILITY:
				setAgility(getAgility() + amount);
				break;
			case LOGIC:
				setLogic(getLogic() + amount);
				break;
			case CREATIVITY:
				setCreativity(getCreativity() + amount);
				break;
			case WISDOM:
				setWisdom(getWisdom() + amount);
				break;
			case CHARISMA:
				setCharisma(getCharisma() + amount);
				break;
			default: // do nothing;
				break;
		}
	}

	public void setStamina(int input) {
		int oldValue = getStamina();
		this.stamina = input;
		changed(new ChangePacket(AbilityType.STAMINA, oldValue, getStamina()));
	}

	public int getStamina() {
		return Integer.valueOf(stamina);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		changed();
	}

	public int getAgility() {
		return Integer.valueOf(agility);
	}

	public void setAgility(int input) {
		int oldValue = getAgility();
		this.agility = input;
		changed(new ChangePacket(AbilityType.AGILITY, oldValue, getAgility()));
	}

	public int getLogic() {
		return Integer.valueOf(logic);
	}

	public void setLogic(int input) {
		int oldValue = getLogic();
		this.logic = input;
		changed(new ChangePacket(AbilityType.LOGIC, oldValue, getLogic()));
	}

	public int getCreativity() {
		return Integer.valueOf(creativity);
	}

	public void setCreativity(int creativity) {
		int oldValue = getCreativity();
		this.creativity = creativity;
		changed(new ChangePacket(AbilityType.CREATIVITY, oldValue, getCreativity()));
	}

	public int getWisdom() {
		return Integer.valueOf(wisdom);
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
		changed();
	}

	public int getCharisma() {
		return Integer.valueOf(charisma);
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
		changed();
	}

	public int getHonesty() {
		return Integer.valueOf(honesty);
	}

	public void setHonesty(int honesty) {
		this.honesty = honesty;
		changed();
	}

	public int getKindness() {
		return Integer.valueOf(kindness);
	}

	public void setKindness(int kindness) {
		this.kindness = kindness;
		changed();
	}

	public int getLaughter() {
		return Integer.valueOf(laughter);
	}

	public void setLaughter(int laughter) {
		this.laughter = laughter;
		changed();
	}

	public int getGenerocity() {
		return Integer.valueOf(generocity);
	}

	public void setGenerocity(int generocity) {
		this.generocity = generocity;
		changed();
	}

	public int getLoyalty() {
		return Integer.valueOf(loyalty);
	}

	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
		changed();
	}

	public int getMagic() {
		return Integer.valueOf(magic);
	}

	public void setMagic(int magic) {
		this.magic = magic;
		changed();
	}

	public int getBits() {
		return Integer.valueOf(bits);
	}

	public void setBits(int bits) {
		this.bits = bits;
		changed();
	}

	public int getGems() {
		return Integer.valueOf(gems);
	}

	public void setGems(int gems) {
		this.gems = gems;
		changed();
	}

}
