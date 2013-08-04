package main;

import abilities.Ability.AbilityType;

public class ChangePacket {

	AbilityType at;
	int oldValue;
	int newValue;
	
	
	public ChangePacket(AbilityType at, int ov, int nv){
		this.at=at;
		oldValue = ov;
		newValue = nv;
	}
	
	
}
