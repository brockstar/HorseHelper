package mechanics;

import java.util.ArrayList;

public class Dialogue {

	public ArrayList<Dialogue>	options	= new ArrayList<Dialogue>();

	public String			optionName;
	public String			characterName;
	public String			text;

	public Dialogue( String optionName,String characterName,String text ){
		this.optionName = optionName;
		this.characterName = characterName;
		this.text = text;
	}

	public void addOption(Dialogue d) {
		options.add(d);
	}

}
