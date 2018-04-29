package project;

public class Edge {
	Coordinate pi, pf;
	int cost;
	
	public Edge(Coordinate pi, Coordinate pf, int cost) {
		this.pi = pi;
		this.pf = pf;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Edge [pi=" + pi + ", pf=" + pf + ", cost=" + cost + "]";
	}
	
	
	
	
}
