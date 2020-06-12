package main;
import java.util.Collection;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxGraph;

public class Clic extends JFrame{
	 mxGraph graph;
	 Object [] tabnode;
	 
	 	public Clic(Graphe G){
		graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		 tabnode=new Object[20];
		try
		{
		   tabnode[0]= graph.insertVertex(parent, null, "v1", 500, 10, 30,
		         30,"shape=ellipse;perimeter=ellipsePerimeter");
		   
		   
		   tabnode[1]= graph.insertVertex(parent, null, "v2", 750, 10, 30,
			         30,"shape=ellipse;perimeter=ellipsePerimeter");
		   
		   tabnode[2]= graph.insertVertex(parent, null, "v3",
		         900, 50, 30, 30, "shape=ellipse;perimeter=ellipsePerimeter");
		   
		   tabnode[3] = graph.insertVertex(parent, null, "v4",
			         350, 50, 30, 30, "shape=ellipse;perimeter=ellipsePerimeter");
		   // type 2 -----------------------------------------------
		   
		   tabnode[4] = graph.insertVertex(parent, null, "v5",
			         1200, 180, 30, 30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[5] = graph.insertVertex(parent, null, "v6", 20, 180, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[6] = graph.insertVertex(parent, null, "v7", 150, 250, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[7] = graph.insertVertex(parent, null, "v8", 1020, 250, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[8] = graph.insertVertex(parent, null, "v9", 800, 350, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[9] = graph.insertVertex(parent, null, "v10", 400, 350, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   // type 3 ----------------------------------------------------
		   tabnode[10] = graph.insertVertex(parent, null, "v11", 10, 500, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[11] = graph.insertVertex(parent, null, "v12", 70, 600, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[12] = graph.insertVertex(parent, null, "v13", 250, 730, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[13] = graph.insertVertex(parent, null, "v14", 400, 800, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[14] = graph.insertVertex(parent, null, "v15", 550, 820, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[15] = graph.insertVertex(parent, null, "v16", 680, 800, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[16] = graph.insertVertex(parent, null, "v17", 820, 750, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[17] = graph.insertVertex(parent, null, "v18", 980, 850, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[18] = graph.insertVertex(parent, null, "v19", 1150, 600, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   tabnode[19] = graph.insertVertex(parent, null, "v20", 1450, 520, 30,
			         30, "shape=ellipse;perimeter=ellipsePerimeter");
		   
		  // graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "red", new Object[]{v2}); // V2 = nom sommet
		   
		   //////////////////////////////////////
		   //Edge
		 
		  // String edgeStyle = mxConstants.STYLE_EDGE + "=" + mxConstants.EDGESTYLE_TOPTOBOTTOM;
		   for(int i=0;i<20;i++) {
			   String edgeStyle = mxConstants.STYLE_STARTARROW + "=" + mxConstants.NONE;
			   for (Lien l : G.tab[i].getConnexion()) {
				   graph.insertEdge(parent, null,l.getValeur() , tabnode[G.tab[i].getId()-1], tabnode[l.getN().getId()-1],edgeStyle);
			   }
		   }
		 
		   
		}
		finally
		{
		   graph.getModel().endUpdate();
		   		   graph.getModel().endUpdate();
			mxGraphComponent graphComponent = new mxGraphComponent(graph);
			mxGraphModel graphModel  = (mxGraphModel)graphComponent.getGraph().getModel(); 
			Collection<Object> cells =  graphModel.getCells().values(); 
			mxUtils.setCellStyles(graphComponent.getGraph().getModel(), 
			    cells.toArray(), mxConstants.STYLE_ENDARROW, mxConstants.NONE);
			getContentPane().add(graphComponent); 
		}
		graph.setCellsMovable(false);
	}
	 	public void Djisktra_Graphique(Graphe G) {
			final mxGraphComponent graphComponent = new mxGraphComponent(graph);
			getContentPane().add(graphComponent);
			
			graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
			{
				int noeudsrc;
				int noeuddest;
				int i=0;
				Object cell=null;
				
			public void mouseReleased(MouseEvent e){
					if(i!=2)cell = graphComponent.getCellAt(e.getX(), e.getY());
					if (i==2) return;
					
					if (cell != null)
					{
						System.out.println(i);
						switch(i) {
						case 0:{
							
							System.out.println("récupération du clique src"+graph.getLabel(cell).substring(1));
							noeudsrc=Integer.parseInt(graph.getLabel(cell).substring(1));
							i++;
						}break;
						case 1:{
							System.out.println("récupération du clique dest"+graph.getLabel(cell).substring(1));
						    noeuddest=Integer.parseInt(graph.getLabel(cell).substring(1));
							i++;
							for(Noeud nd : G.tab[noeudsrc-1].getTable_Hashage().get(noeuddest-1)){
								graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "red", new Object[]{tabnode[nd.getId()-1]});
							}
							
							G.Affichage_Plus_Court_Chemin(G.tab[noeudsrc-1].getTable_Hashage().get(noeuddest-1));
						}break;
						}
							
						}
					}
			
			}
			
		);
			return;
	  }
}
