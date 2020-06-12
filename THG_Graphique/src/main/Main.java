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
		G.Remplir_Table_Routage_Graphe();
		Clic frame = new Clic(G);
		frame.Djisktra_Graphique(G);
		frame.setTitle("Table De Routage");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1520, 960);
		frame.setVisible(true);

	}
}