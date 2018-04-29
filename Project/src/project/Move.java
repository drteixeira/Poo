package project;

import java.util.Random;

public class Move extends Event {

	public Move(Individual individuo) {
		super(individuo);
		// TODO Auto-generated constructor stub
	}
	
	int time;
	double mean;
	static Random random = new Random();
	
	public double calcmean() {
		this.mean=(1.0-(Math.log(this.individuo.comfort)))*this.individuo.mparam;
		return mean;
	}
	
	public void expRandom() {
	double next = random.nextDouble();
	//this.time=-this.mean*Math.log(1.0-	next);
	double tempo =-this.mean*Math.log(1.0-	next);
	this.time = (int) tempo;
	//return -this.mean*Math.log(1.0-	next);
	}	
}
