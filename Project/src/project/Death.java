package project;

import java.util.Random;

public class Death extends Event {

	public Death(Individual individuo) {
		super(individuo);
		
	}
	int time;
	double mean;
	static Random random = new Random();
	
	public double calcmean() {
		this.mean=(1.0-(Math.log(1.0-this.individuo.comfort)))*this.individuo.dparam;
		return mean;
	}
	
	public void expRandom() {
	double next = random.nextDouble();
	//this.time=-this.mean*Math.log(1.0-	next);
	double tempo =-this.mean*Math.log(1.0-	next);
	this.time = (int) tempo;
	//return -this.mean*Math.log(1.0-	next);
	}

	@Override
	public String toString() {
		return "Death [time=" + time + ", individuo=" + individuo + "]";
	}

	
	
	
}
