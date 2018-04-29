package project;

public class Individual {
	int cost=0; //Custo do caminho
	int lenght=0; //Tamanho do caminho
	int dist; //Distância do pto atual, ao final
	int k; //sensibility
	int dparam, rparam, mparam; //parametros para métodos
	double comfort; // =  //Conforto associado
	Coordinate posatual;
	
	public Individual(Grid g, int k, int dparam, int rparam, int mparam) {
		this.dist = g.SetDist(g.pi);
		this.k = k;
		SetComfort(g);
		this.posatual = g.pi;
		this.dparam=dparam;
		this.rparam=rparam;
		this.mparam=mparam;
		this.posatual=g.pi;
	}	
	
	@Override
	public String toString() {
		return "Individual [cost=" + cost + ", lenght=" + lenght + ", dist=" + dist + ", k=" + k + ", dparam=" + dparam
				+ ", rparam=" + rparam + ", mparam=" + mparam + ", comfort=" + comfort + ", posatual=" + posatual + "]";
	}


	public void SetComfort(Grid g) {
		double cost = this.cost;
		double length = this.lenght;
		double cmax = g.cmax;
		double dist=this.dist;
		double num1= cost - lenght + 2.0;
		double den1 = (cmax-1)*(lenght)+3;
		double num2=dist;
		double den2=g.n+g.m+1.0;
		double k = this.k;
		this.comfort = Math.pow(1.0-num1/den1,k)*Math.pow(1-num2/den2, k) ;
	}
	

	
}