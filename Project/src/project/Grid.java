package project;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

	int n,m; //dimensão
	Coordinate pi, pf; //pontos inicial/final
    int cmax; //custo máximo de um edge
	List<Edge> edges = new ArrayList<>();//lista de edges
	Coordinate obs[]; //Vetor de Obstaculos
	int tf; //instante final da evolução
	int obstaculos;
		
	public Grid(int n, int m, Coordinate pi, Coordinate pf, int tf, int obstaculos) {
		this.n = n;
		this.m = m;
		this.pi = pi;
		this.pf = pf;
		this.tf = tf;
		this.obs = new Coordinate[obstaculos];
		this.obstaculos=obstaculos;
		//int cmax=0;
	}
	
	public void AddSpecialEdge(Edge e) {
		this.edges.add(e);
	}
	
	public void setcmax(int cmax) {
		this.cmax=cmax;
	}
	
	public int SetDist(Coordinate pi) {
		int d = Math.abs(this.pf.x-pi.x)+Math.abs(this.pf.y-pi.y);
		return d;
	}

	@Override
	public String toString() {
		return "Grid [n=" + n + ", m=" + m + ", pi=" + pi + ", pf=" + pf + ", cmax=" + cmax + ", edges=" + edges
				+ ", obs=" + Arrays.toString(obs) + ", tf=" + tf + ", obstaculos=" + obstaculos + "]";
	}

	public Coordinate[] addobstaculo(Coordinate obs[], Coordinate c, int index) {
		if (index<obstaculos) {
			this.obs[index]=c;
		}
		return obs;
	}


	
	


	
	
}
