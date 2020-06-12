package main;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class Main{

	public static void main(String[] args) {
		Graphe G=new Graphe();
		G.Init_Graph();
		G.Creation_Aleatoire();
		for(int i=0;i<20;i++) {
			G.tab[i].Affichage_Noeud();
		}
		G.Remplir_Table_Routage_Graphe();
		Clic frame = new Clic(G);
		frame.Djisktra_Graphique(G);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2000, 960);
		frame.setVisible(true);

	}
}