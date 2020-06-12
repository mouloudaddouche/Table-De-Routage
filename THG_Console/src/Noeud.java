import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class Noeud implements Comparable<Noeud> {
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
	
	@Override
	public int compareTo(Noeud nd) {
		return Integer.compare(this.distance, nd.getDistance());
	}
	
	//Fonction qui permet de verifié si il existe un lien entre 2 noeuds
	public boolean Lien_Existe(Noeud N1) {
		if(N1.Connexion.size()==0) return false;
		else if (this.Connexion.size()==0) return false;
		else{
			for(Lien L : Connexion) {
			if  (L.getN().getId()==N1.getId()) return true;
		}
		return false;
		}
	}
	
	//Fonction qui permet de recuperer la durée du transfert du message entre 2 noeuds
	public int gettime(int id) {
		int time=0;
		for(Lien l : this.Connexion) {
			if(l.getN().getId()-1==id) { time=l.getValeur();break;}
		}
		return time;
	}
	
	//Fonction to string
	public String ToString() {
		return(""+this.id);
		
	}
	
	
	//Fonction qui permet d'afficher les informations d'un noeud
	public void Affichage_Noeud() {
		 { System.out.print("N"+this.id+" : ");this.Affichage_Connexion();System.out.println("");}
	}
	
	//Fonction qui permet d'afficher les noeuds adjacents d'un noeud
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
