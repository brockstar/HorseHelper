package mechanics;

public abstract class Ability {

	public enum AbilityType {
		STAMINA, AGILITY, LOGIC, CREATIVITY, WISDOM, CHARISMA;
	}

	AbilityType	type;
	int			value;

	public class Stamina extends Ability {
		public Stamina( int value ){
			this.type = AbilityType.STAMINA;
			this.value = value;
		}
	}

	public class Agility extends Ability {
		public Agility( int value ){
			this.type = AbilityType.AGILITY;
			this.value = value;
		}
	}

	public class Logic extends Ability {
		public Logic( int value ){
			this.type = AbilityType.LOGIC;
			this.value = value;
		}
	}

	public class Creativity extends Ability {
		public Creativity( int value ){
			this.type = AbilityType.CREATIVITY;
			this.value = value;
		}
	}

	public class Wisdom extends Ability {
		public Wisdom( int value ){
			this.type = AbilityType.WISDOM;
			this.value = value;
		}
	}

	public class Charisma extends Ability {
		public Charisma( int value ){
			this.type = AbilityType.CHARISMA;
			this.value = value;
		}
	}
}
