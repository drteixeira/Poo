package project;

import java.util.List;
import java.util.ArrayList;

public class Population {
	List<Individual> individuals = new ArrayList<Individual>();//lista de individuos
	int ni; //numero inicial de individuos
	int nmaxi; //numero maximo de individuos
	int ind;
	
	
	public Population(int ni, int nmaxi) {
		super();
		this.ni = ni;
		this.nmaxi = nmaxi;
		this.ind=0;
	}
	
	public void addindividual(Individual i) {
		if (this.ind<nmaxi) {
			this.individuals.add(i);
			this.ind=this.ind+1;
		}
	}

	@Override
	public String toString() {
		return "Population [individuals=" + individuals + ", ni=" + ni + ", nmaxi=" + nmaxi + ", ind=" + ind + "]";
	}
	
	
	

}
