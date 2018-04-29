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

public class ReadXML2 {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("C:\\Users\\Diogo\\Desktop\\POO\\data1.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("simulation");
	//System.out.println("----------------------------");
	
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
	
	NodeList finalpoint = doc.getElementsByTagName("finalpoint");
	int xposfinal =Integer.parseInt(finalpoint.item(0).getAttributes().getNamedItem("xfinal").getNodeValue());
	int yposfinal =Integer.parseInt(finalpoint.item(0).getAttributes().getNamedItem("yfinal").getNodeValue());

	NodeList specialcostzones = doc.getElementsByTagName("zone");
	int length_zones= specialcostzones.getLength();
	List xini = new ArrayList();
	List yini = new ArrayList();
	List xfin = new ArrayList();
	List yfin = new ArrayList();
	for (int i=0; i<length_zones;i++) {
		int xposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("xinicial").getNodeValue());
		int yposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("yinicial").getNodeValue());
		xini.add(new Integer(xposicao));
		yini.add(new Integer(yposicao));
		xposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("xfinal").getNodeValue());
		yposicao = Integer.parseInt(specialcostzones.item(i).getAttributes().getNamedItem("yfinal").getNodeValue());
		xfin.add(new Integer(xposicao));
		yfin.add(new Integer(yposicao));		
	}
	
	NodeList obstacles = doc.getElementsByTagName("obstacles");
	int num = Integer.parseInt(obstacles.item(0).getAttributes().getNamedItem("num").getNodeValue());
	//System.out.println("num: " + num);
	NodeList obstacle = doc.getElementsByTagName("obstacle");
	
	List xpos = new ArrayList();
	List ypos = new ArrayList();
	for (int i=0;i<num;i++) {
		int xposicao = Integer.parseInt(obstacle.item(i).getAttributes().getNamedItem("xpos").getNodeValue());
		int yposicao = Integer.parseInt(obstacle.item(i).getAttributes().getNamedItem("ypos").getNodeValue());
		xpos.add(new Integer(xposicao));
		ypos.add(new Integer(yposicao));
	}
	//System.out.println(xpos+"\n");
	//System.out.println(ypos+"\n");
	
	NodeList deaths = doc.getElementsByTagName("death");
	int death = Integer.parseInt(deaths.item(0).getAttributes().getNamedItem("param").getNodeValue());
	//System.out.println("death: " + death);
	
	NodeList reproductions = doc.getElementsByTagName("reproduction");
	int reproduction = Integer.parseInt(reproductions.item(0).getAttributes().getNamedItem("param").getNodeValue());
	//System.out.println("reproduction: " + reproduction);

	NodeList moves = doc.getElementsByTagName("move");
	int move = Integer.parseInt(moves.item(0).getAttributes().getNamedItem("param").getNodeValue());
	//System.out.println("move: " + move);
	
	
	//System.out.println("finalinst"+finalinst+"\n");
	//System.out.println("initop"+initpop+"\n");
	//System.out.println("maxpop"+maxpop+"\n");
	//System.out.println("comfortsens"+comfortsens+"\n");
	//System.out.println("colsnb"+colsnb+"\n");
	//System.out.println("rowsnb"+rowsnb+"\n");
	//System.out.println("xinicial"+xposinicial+"\n");
	//System.out.println("yinicial"+yposinicial+"\n");
	//System.out.println("xfinal"+xposfinal+"\n");
	//System.out.println("tfinal"+yposfinal+"\n");
	//System.out.println("xini"+xini+"\n");
	//System.out.println("yini"+yini+"\n");
	//System.out.println("xfin"+xfin+"\n");
	//System.out.println("yfin"+yfin+"\n");
	//System.out.println("xobstacles"+xpos+"\n");
	//System.out.println("yobstacles"+ypos+"\n");
	//System.out.println("death: " + death);
	//System.out.println("reproduction: " + reproduction);
	//System.out.println("move: " + move);
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
  
  Edge edge = new Edge();

}
