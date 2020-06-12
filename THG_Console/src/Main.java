import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args){
		boolean quitter=false;
		int etape=1;
		int choix=0;
		boolean creation=false;
		boolean tbroutage=false;
		Graphe G=new Graphe();
		do {
			   System.out.println("      Tables De Routage          ");
			   System.out.println("1) La creation aleatoire d'un reseau r�aliste");
			   System.out.println("2) Affichage du reseau");
			   System.out.println("3) La verification de la conn�xit� du r�seau");
			   System.out.println("4) La reconstitition du chemin entre 2 noeuds");
			   System.out.println("5) Quitter");
			int i=0;
			do {
			do {
				if (i==0) System.out.println("Faites votre choix ");
				else  System.out.println("Veuillez choisir un choix disponbile dans le menu ");
				Scanner sc=new Scanner(System.in);
				choix=sc.nextInt();
				i++;
			}while(choix<1 || choix>5);
			if(etape==1) {
			if (choix==1) creation=true;
			if(choix!=1 && creation ==false) { if (choix==5) {System.out.println("Programme Termin�"); return;}
			else System.out.println("Vous pouvez pas realiser ce choix tantque le reseau n'est pas cr�e");i=0;}
			}
			if (etape!=1) creation =true;
			}while(creation==false);
			creation=false;
			etape++;
			switch(choix) {
			
			case 1 :{
				if (creation ==true) {
					System.out.println("Le reseau est d�ja cr�e, voulez vous cr�e un autre reseau al�atoire ?");
					System.out.println("1) Oui");
					System.out.println("2) Non");
					
					int choix2;
					
					do {
					Scanner sc=new Scanner(System.in);
					choix2=sc.nextInt();
					}while (choix2<1 || choix2 >2);
					
					if (choix2==2) break;
					
				   }
				
					G.Init_Graph();
					G.Creation_Aleatoire();
					G.Remplir_Table_Routage_Graphe();
					System.out.println("\nReseau Cr�e\n");
					creation =true;
					}break;
			
			case 2 :{
					for(int j=0;j<100;j++) {
						G.tab[j].Affichage_Noeud();
										   }
				    }break;
			
			case 3:{
				if(G.Parcours_Profondeur_Graphe()!=10000) {
					do {
						G.Init_Graph();
						G.Creation_Aleatoire();
						G.Remplir_Table_Routage_Graphe();
						creation=true;
						}while(G.Parcours_Profondeur_Graphe()!=10000);
				   }
				System.out.println("\nLe reseau cr�e est connexe\n");
				   }break;
			
			case 4 :{
				System.out.println("Veuillez Rentrer l'indice du noeud �metteur");
				Scanner sc=new Scanner(System.in);
				int indemt=0;
				do {
					indemt=sc.nextInt();
				}while(indemt<1 || indemt>100);
				
				System.out.println("Veuillez Rentrer l'indice du noeud destinataire");
				int inddest=0;
				do {
					if(inddest==indemt) System.out.println("Il faut choisir un noeud d�stinataire diffrent du noeud �metteur");
					inddest=sc.nextInt();
				}while(inddest<1 || inddest>100 || inddest==indemt);
				
				int [] path=new int[100];
				boolean [] taboo=new boolean[100];
				System.out.println("Les chemins possibles : ");
				G.Parcourir(G,indemt-1,0, path, taboo,inddest-1, 100);
				System.out.print("\nLe plus court chemin : ");
				G.Affichage_Plus_Court_Chemin(G.tab[indemt-1].getTable_Hashage().get(inddest-1));
				System.out.println();
				
					}break;
			
			case 5 :{
				System.out.println("\nProgramme Termin�\n");
					quitter=true;
				   }break;
			}
			
			}while(quitter==false);
	}
			
		}
			
		