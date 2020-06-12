import java.util.*;

public class Graphe {
Noeud tab[];


public Graphe() {
	tab=new Noeud[100];
}

//Fonction initialisation du graphe
public void Init_Graph() {
	for (int i=0;i<100;i++) {
		if (i<8) {
			tab[i]=new Noeud(1,i+1);}
		else if (i>=8 && i<28){
			tab[i]=new Noeud(2,i+1);
			tab[i].setNbtier1(Outils.Rand(2,1));
			tab[i].setNbtier2(Outils.Rand(3,2));
		}
		else {
			tab[i]=new Noeud(3,i+1);
			tab[i].setNbtier2(2);
			tab[i].setNbtier3(1);
		}
	}
}

//Fonction de la creation aleatoire d'un graphe
public void Creation_Aleatoire() {
	for (int i=0;i<100;i++){
		if (i<8) { // Blackbone
			for(int j=0;j<8;j++) {
				if (i==j) continue; // Parceque y'a pas de boucle
				else { // Pour verifier si un lien existe (75%)
					if(!(tab[i].Lien_Existe(tab[j]))) {
				     int proba = Outils.Rand(100,0);
				     if(proba<=75) {
				     int valeur=Outils.Rand(10,5);
					 tab[i].Connexion.add(new Lien(tab[j],valeur));
					 tab[j].Connexion.add(new Lien(tab[i],valeur));
				     }
				}
			}
		}
	}
		
		else if (i>=8 && i<28){ //Tier2
			//Lien avec Blackbone
			int indice;
			while(tab[i].getNbtier1()>0){
				do {
				indice=Outils.Rand(7,0);}while(tab[i].Lien_Existe(tab[indice]));
				int valeur=Outils.Rand(20,10);
				tab[i].Connexion.add(new Lien(tab[indice],valeur));
				tab[indice].Connexion.add(new Lien(tab[i],valeur));
				tab[i].setNbtier1(tab[i].getNbtier1()-1);
				tab[indice].setNbtier1(tab[indice].getNbtier1()-1);
				
			}
			//Lien avec Tier2
			while(tab[i].getNbtier2()>0){
				indice=0;
				for (int j=8;j<28;j++) {
					if ((tab[j].getNbtier2()!=0) && (!tab[i].Lien_Existe(tab[j]) && (i!=j))) { indice=j;break;}
				}
				int valeur=Outils.Rand(20,10);
				tab[i].Connexion.add(new Lien(tab[indice],valeur));
				tab[indice].Connexion.add(new Lien(tab[i],valeur));
				tab[i].setNbtier2(tab[i].getNbtier2()-1);
				tab[indice].setNbtier2(tab[indice].getNbtier2()-1);
			}
		}
		
		else {//Tier3
			int indice;
			
			for(int j=0;j<2;j++){
				do{indice=Outils.Rand(27,8);
				}while((tab[i].Lien_Existe(tab[indice])));
				int valeur=Outils.Rand(15,50);
				tab[i].Connexion.add(new Lien(tab[indice],valeur));
				tab[indice].Connexion.add(new Lien(tab[i],valeur));
			}
			
			if(tab[i].getNbtier3()>0) {
			  do {
		    indice=Outils.Rand(99,28);} while((tab[indice].getNbtier3()==0)||(tab[i].Lien_Existe(tab[indice]) ||(i==indice)));
			int valeur=Outils.Rand(15,50);
			tab[i].Connexion.add(new Lien(tab[indice],valeur));
			tab[indice].Connexion.add(new Lien(tab[i],valeur));
			tab[i].setNbtier3(tab[i].getNbtier3()-1);
			tab[indice].setNbtier3(tab[indice].getNbtier3()-1);
			}
		}
	}
	
 }//Fin de la fonction creation aleatoire

/*Fonction qui permet de recuperer le nombre de sommets parcouru a partir d'un sommet d'entré en utilisant 
un parcours en profondeur */

 public int Parcours_Profondeur_Sommets(Noeud origine, Vector<Noeud> sommetsVisités) {
    sommetsVisités.add(origine);
    for(Lien  l : origine.getConnexion()) {
    	if (!sommetsVisités.contains(l.getN())) {
    		Parcours_Profondeur_Sommets(l.getN(), sommetsVisités);
    	}
    }
  return sommetsVisités.size();
}

 ///*Fonction qui permet de recuperer le nombre de sommets parcouru a partir de tout les sommets du graphe
public int Parcours_Profondeur_Graphe(){
	int Nb_Total_Sommet_Visités=0;
	 Vector<Noeud> sommetsVisités = new Vector<Noeud>();
	 for(int i=0;i<100;i++) {
		 sommetsVisités.removeAllElements();
		 Nb_Total_Sommet_Visités+=this.Parcours_Profondeur_Sommets(this.tab[i],sommetsVisités);
	 }
	 return  Nb_Total_Sommet_Visités;
}


//Fonction qui permet de calculer tout les plus courts chemin d'un noeud vers tout les noeuds
public void computePath(Noeud sourceVertex) {
    sourceVertex.setDistance(0);
    PriorityQueue<Noeud> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(sourceVertex);

    while (!priorityQueue.isEmpty()) {
        Noeud vertex = priorityQueue.poll();

        for (Lien edge : vertex.getConnexion()) {
            Noeud v = edge.getN();
//           Vertex u = edge.getStartVertex();
            int weight = edge.getValeur();
            int minDistance = vertex.getDistance() + weight;

            if (minDistance < v.getDistance()) {
                priorityQueue.remove(vertex);
                v.setPredecessor(vertex);
                v.setDistance(minDistance);
                priorityQueue.add(v);
            }
        }
    }
}

//Fonction qui permet de calculer le plus court chemin vers un noeud précis
public ArrayList<Noeud> getShortestPathTo(Noeud targetVerte) {
    ArrayList<Noeud> path = new ArrayList<>();

    for (Noeud vertex = targetVerte; vertex != null; vertex = vertex.getPredecessor()) {
        path.add(vertex);
    }
    Collections.reverse(path);
    return path;
}

//Fonction qui intialise tout les attributs utilisés dans l'algo de djiskra
public void Apres_Djsikra(){
	 for(int i=0;i<100;i++) {
	    	this.tab[i].setDistance(Integer.MAX_VALUE);
	    	this.tab[i].setPredecessor(null);
	    	this.tab[i].setVisited(false);
	    }
}

//Fonction qui remplit la table de routage d'un noeud ( en utilisant l'algo de djiskra )
public void Remplir_Table_Routage_Noeud(int idnoeud) {
		this.computePath(tab[idnoeud]);
		for(int j=0;j<100;j++) {
			if(idnoeud==j) this.tab[idnoeud].getTable_Hashage().put(idnoeud,null);
			else {
				ArrayList<Noeud> rst=new ArrayList<Noeud>();
				for(Noeud nd: this.getShortestPathTo(this.tab[j])) {
					rst.add(nd);
				}
				this.tab[idnoeud].getTable_Hashage().put(j,new ArrayList<Noeud>(rst));
			}
		}
	}

//Fonction qui remplit tout les tables de routage des sommets du graphe
public void Remplir_Table_Routage_Graphe() {
	for (int i=0;i<100;i++) {
		this.Remplir_Table_Routage_Noeud(i);
		this.Apres_Djsikra();
	}
}

//Fonction qui affiche le plus court chemin
public void Affichage_Plus_Court_Chemin(ArrayList<Noeud> PCC) {
	Iterator <Noeud> iter=PCC.iterator();
	while(iter.hasNext()) {
		System.out.print(iter.next().ToString());
		if(iter.hasNext()) System.out.print(" -> ");
	}
	System.out.println();
}

//Fonction qui affiche tout les chemins possibles entres 2 noeuds choisit
public void Parcourir(Graphe G,int position, int depth,int [] path, boolean [] taboo,int target,int n) {
	path[depth]=position;
	 
	// on est sur le sommet d'arrivé -> fini
	if (position==target) {
		// affiche la solution
		int somme=0;
		// affiche la solution
		for(int i=0;i<depth;i++) { System.out.print(path[i]+1+" -> ");
		somme+=G.tab[path[i]].gettime(path[i+1]);	
		}
		System.out.print(path[depth]+1+" = "+somme);
		System.out.print("MT\n");
		return;
	}
	// sinon...
	taboo[position]=true; // on pose un caillou
	// on explore les chemins restants
	for(int i=0;i<100;i++) {
		if( taboo[i]) continue;
		else if (depth>=3) break;
			for(Lien l : G.tab[position].getConnexion()) {
				if (l.getN().getId()-1==i) {Parcourir(G,i,depth+1,path,taboo,target,n);break;}
				
			}
	}

	taboo[position]=false; // on retire le caillou
 }
}//Fin de la classe Graphe
