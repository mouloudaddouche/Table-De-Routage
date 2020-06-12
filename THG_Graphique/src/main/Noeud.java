package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class Noeud implements Comparable<Noeud> {
	private int pixelX;
	private int pixelY;
	private int type;
	private int id;
	private int nbtier1;
	private int nbtier2;
	private int nbtier3;
	public ArrayList<Lien> Connexion;
	private boolean visited;
	private Noeud predecessor;
	private int distance;
	private HashMap<Integer,ArrayList<Noeud>> Table_Hashage;
	
	public Noeud(){
	}
	//Constructeur
	public Noeud(int type, int id) {
		super();
		this.type = type;
		this.id = id;
		this.Connexion=new ArrayList<Lien>();
		this.Table_Hashage=new HashMap<Integer,ArrayList<Noeud>>();
		this.distance=Integer.MAX_VALUE;
		this.predecessor=null;
	}
	
	public Noeud(int id) {
		this.id = id;
		this.distance=Integer.MAX_VALUE;
		this.predecessor=null;
	}
	
	
	public int getPixelX() {
		return pixelX;
	}

	public void setPixelX(int pixelX) {
		this.pixelX = pixelX;
	}

	public int getPixelY() {
		return pixelY;
	}

	public void setPixelY(int pixelY) {
		this.pixelY = pixelY;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Lien> getConnexion() {
		return Connexion;
	}

	public void setConnexion(ArrayList<Lien> connexion) {
		Connexion = connexion;
	}
	
	public int getNbtier1() {
		return nbtier1;
	}

	public void setNbtier1(int nbtier1) {
		this.nbtier1 = nbtier1;
	}

	public int getNbtier2() {
		return nbtier2;
	}

	public void setNbtier2(int nbtier2) {
		this.nbtier2 = nbtier2;
	}

	public int getNbtier3() {
		return nbtier3;
	}

	public void setNbtier3(int nbtier3) {
		this.nbtier3 = nbtier3;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public Noeud getPredecessor() {
		return predecessor;
	}
 
	public void setPredecessor(Noeud predecessor) {
		this.predecessor = predecessor;
	}
 
	public int getDistance() {
		return distance;
	}
 
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	public HashMap<Integer, ArrayList<Noeud>> getTable_Hashage() {
		return Table_Hashage;
	}
	public void setTable_Hashage(HashMap<Integer, ArrayList<Noeud>> table_Hashage) {
		Table_Hashage = table_Hashage;
	}
	
	@Override
	public int compareTo(Noeud nd) {
		return Integer.compare(this.distance, nd.getDistance());
	}
	
	//
	public boolean Lien_Existe(Noeud N1) {
			for(Lien L : this.Connexion) {
			if  (L.getN().getId()==N1.getId()) return true;
		}
		return false;
		}
	
	public int gettime(int id) {
		int time=0;
		for(Lien l : this.Connexion) {
			if(l.getN().getId()-1==id) { time=l.getValeur();break;}
		}
		return time;
	}
	
	
	public String ToString() {
		return(""+this.id);
		
	}
	
	public String Connexion() {
		String s="";
		for(Lien l :Connexion) {
			s=s+l.tostring();
		}
		return s;
	}
	
	public void Affichage_Noeud() {
		 { System.out.print("N"+this.id+" : ");this.Affichage_Connexion();System.out.println("");}
	}
	
	public void Affichage_Connexion() {
		Iterator<Lien> it=this.Connexion.iterator();
		while(it.hasNext()) {
			System.out.print(it.next().tostring());
			if(it.hasNext()) {
				System.out.print(" + ");
			}
		}
	}
	
	public boolean eqauls(Object O) {
		if(O == null) return false;
		if(O instanceof Noeud) {
			Noeud N=(Noeud) O;
			if(this.id ==N.getId()) return true;
			else return false;
		}
		return false;
	}
	
}
