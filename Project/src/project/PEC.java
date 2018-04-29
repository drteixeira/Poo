package project;

import java.util.ArrayList;
import java.util.List;

public class PEC {

	List<Event> Events = new ArrayList<Event>();
	
	public void addEvent(Event e) {
			this.Events.add(e);
	}

	@Override
	public String toString() {
		return "PEC [Events=" + Events + "]";
	}
	
	


}
