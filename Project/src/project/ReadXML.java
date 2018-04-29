package project;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXML {
	
	public static Grid readXML(String file) {
		total t;
		Grid g;
		Population pop;
		Death d;
		Reproduction r;
		Move m;
		PEC pec;
		pec = new PEC();
		 try {
			 	

				File fXmlFile = new File(file);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
						
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();

				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("simulation");
				
				int finalinst = Integer.parseInt(nList.item(0).getAttributes().getNamedItem("finalinst").getNodeValue());
				int initpop = Integer.parseInt(nList.item(0).getAttributes().getNamedItem("initpop").getNodeValue());
				int maxpop = Integer.parseInt(nList.item(0).getAttributes().getNamedItem("maxpop").getNodeValue());
				int comfortsens = Integer.parseInt(nList.item(0).getAttributes().getNamedItem("comfortsens").getNodeValue());	
				
				NodeList grid = doc.getElementsByTagName("grid");
				int colsnb = Integer.parseInt(grid.item(0).getAttributes().getNamedItem("colsnb").getNodeValue());
				int rowsnb = Integer.parseInt(grid.item(0).getAttributes().getNamedItem("rowsnb").getNodeValue());
				
				NodeList initialpoint = doc.getElementsByTagName("initialpoint");
				int xposinicial = Integer.parseInt(initialpoint.item(0).getAttributes().getNamedItem("xinicial").getNodeValue());
				int yposinicial = Integer.parseInt(initialpoint.item(0).getAttributes().getNamedItem("yinicial").getNodeValue());
				Coordinate pi = new Coordinate(xposinicial, yposinicial);

				NodeList finalpoint = doc.getElementsByTagName("finalpoint");
				int xposfinal =Integer.parseInt(finalpoint.item(0).getAttributes().getNamedItem("xfinal").getNodeValue());
				int yposfinal =Integer.parseInt(finalpoint.item(0).getAttributes().getNamedItem("yfinal").getNodeValue());
				Coordinate pf = new Coordinate(xposfinal, yposfinal);
				
				NodeList specialcostzones = doc.getElementsByTagName("zone");
				int length_zones= specialcostzones.getLength();
				NodeList obstacles = doc.getElementsByTagName("obstacles");
				int num = Integer.parseInt(obstacles.item(0).getAttributes().getNamedItem("num").getNodeValue());
				
				g = new Grid(colsnb,rowsnb,pi,pf,finalinst,num);
				int cmax=0;
				for (int i=0; i<length_zones;i++) {
					int xposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("xinicial").getNodeValue());
					int yposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("yinicial").getNodeValue());
					Coordinate zpi = new Coordinate(xposicao,yposicao);
					xposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("xfinal").getNodeValue());
					yposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("yfinal").getNodeValue());
					Coordinate zpf = new Coordinate(xposicao,yposicao);
					int czona = Integer.parseInt(specialcostzones.item(i).getTextContent());
					Edge e = new Edge(zpi, zpf, czona);
					g.AddSpecialEdge(e);
					if(czona>cmax) {
						cmax=czona;
					}
				}
				
				g.setcmax(cmax);

				NodeList obstacle = doc.getElementsByTagName("obstacle");				
				for (int i=0;i<num;i++) {
					int xposicao = Integer.parseInt(obstacle.item(i).getAttributes().getNamedItem("xpos").getNodeValue());
					int yposicao = Integer.parseInt(obstacle.item(i).getAttributes().getNamedItem("ypos").getNodeValue());
					Coordinate p = new Coordinate(xposicao,yposicao);
					g.addobstaculo(g.obs, p, i);
				}
				NodeList deaths = doc.getElementsByTagName("death");
				int death = Integer.parseInt(deaths.item(0).getAttributes().getNamedItem("param").getNodeValue());
				
				NodeList reproductions = doc.getElementsByTagName("reproduction");
				int reproduction = Integer.parseInt(reproductions.item(0).getAttributes().getNamedItem("param").getNodeValue());

				NodeList moves = doc.getElementsByTagName("move");
				int move = Integer.parseInt(moves.item(0).getAttributes().getNamedItem("param").getNodeValue());

				pop = new Population(initpop, maxpop);
				Individual ind = new Individual(g,comfortsens, death,reproduction,move); 
				for (int i=0; i<initpop; i++){
					pop.addindividual(ind);
				}
				int counter=0;
				int counter2=0;
				// Evento death 
				for (int i = 0; i < pop.individuals.size(); i++) {
					//System.out.println(i);
					d=new Death(pop.individuals.get(i));
					d.calcmean();
					d.expRandom();
					//System.out.println("Death mean= " + d.mean);
					//System.out.println("Death time= "+ d.time);
					r=new Reproduction(pop.individuals.get(i));
					r.calcmean();
					r.expRandom();
					//System.out.println("Reproduction mean= " + r.mean);
					//System.out.println("Reproduction time= "+ r.time);
					pec.addEvent(d);
					//int counter=0;
					m = new Move(pop.individuals.get(i));
					m.calcmean();
					m.expRandom();
					if (m.time<d.time) {
						counter2++;
						pec.addEvent(m);
					}
					if (r.time<d.time) {
						 counter++;
						 pec.addEvent(r);
					}
				}
				//System.out.println("Counter reproduction: "+ counter +"\nCounter Moves:" + counter2);
				System.out.println("PEC: " + pec);
				//System.out.println("Pop:"+ pop);
				//System.out.println("Grid: "+g);
				return g;
			    } catch (Exception e) {
				e.printStackTrace();
			    }
		 return null;
	}

  public static void main(String argv[]) {
	  
	  Grid g;
	  String file = "C:\\Users\\Diogo\\Desktop\\POO\\data1.xml";
	  
	  g = readXML(file);

   
  }

}