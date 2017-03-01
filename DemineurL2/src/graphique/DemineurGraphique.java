package graphique;
import javax.swing.JOptionPane;

import model.DemineurModel;

public class DemineurGraphique {
	private DemineurModel demineurModel = new DemineurModel();
	
	private DemineurFrame demineurFrame = new DemineurFrame();
	
	
	public DemineurGraphique() {
		demineurFrame.setVisible(true);
		//JPanel
		//Buttons
		int taille = 0;
		while(taille == 0) {
			String tailleS = JOptionPane.showInputDialog("Entrez taille demineur", taille);
			if(tailleS==null)
				System.exit(1);
			taille = Integer.parseInt(tailleS);
			
				
		}
		demineurModel = new DemineurModel(taille);
		demineurFrame.setDemineurModel(demineurModel);
	    
		
	}

}