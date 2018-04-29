package project;

public abstract class Event {
	int time;
	Individual individuo;
	
	public Event(Individual individuo) {
		super();
		this.individuo = individuo;
	}

}
