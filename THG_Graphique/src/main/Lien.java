package main;

public class Lien implements Comparable<Object>{
	private Noeud N;
	private int valeur;
	
	//Constructeur Avec Paramétres
	public Lien(Noeud n1, int valeur) {
		super();
		N = n1;
		this.valeur = valeur;
	}
	
	//Getter du noeud
	public Noeud getN() {
		return N;
	}
	
	//Setter du noeud
	public void setN(Noeud n1) {
		N = n1;
	}
	
	//Getter du poids de l'arret
	public int getValeur() {
		return valeur;
	}
	
	//Setter du poids de l'arret
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public String tostring() {
		return (this.N.ToString()+"("+this.valeur+")");
	}
	
	@Override
	public int compareTo(Object o) {
		Lien l1=(Lien)o;
		return Integer.compare(this.getN().getId(), l1.getN().getId());
	}

}
