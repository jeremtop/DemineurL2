package graphique;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import model.DemineurModel;

public class DemineurPanel extends JPanel {
	/** Serial UID. */
	private static final long serialVersionUID = 1L;

	private DemineurModel demineurModel;

	private final int DY = 50;
	private final int DX = 50;
	private final Color[] couleur= {Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE,Color.RED,Color.MAGENTA};
	public DemineurPanel() {
		setBackground(Color.WHITE);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = getLigne(e.getX(), e.getY());
				int colonne = getColonne(e.getX(), e.getY());
				demineurModel.clic(ligne, colonne);
				repaint();
				
			}
		});
	}

	public void setDemineurModel(DemineurModel demineurModel) {
		this.demineurModel = demineurModel;
		repaint();
	}

	public void gameOver(Graphics g) {
		g.drawString("GAME OVER", getWidth() / 3 , getHeight() / 2);
		for (int x = 0; x < demineurModel.getNbLignes(); x++) {
			for (int y = 0; y < demineurModel.getNbColonnes(); y++) {
				
				demineurModel.getCase(x, y).setClique();
				repaint();
			}
		}
			
				
//		g.setColor(Color.RED);
//		Font fonte2 = g.getFont();
//		Font fonte = new Font("Dialog",Font.BOLD,20);
//		g.setFont(fonte);
//		g.drawString("Game Over", getWidth() / 3 , getHeight() / 2);
//		g.setColor(Color.BLACK);
//		g.setFont(fonte2);
		
		
	}
	
public void propager(int x, int y) {
		
		if (!demineurModel.positionValide(x, y)) 
			return; 

		if ( demineurModel.caseAdj(x,y) == 0 ) {
        	
            for(int i = 0; i < 3;i++) {  
    			if(demineurModel.positionValide((x-1)+i, y-1)  && !demineurModel.getCase((x-1)+i, y-1).isClique()){
    				demineurModel.getCase((x-1)+i, y-1).setClique();
    				//propager((x-1)+i,y-1);
    			}
    			if(demineurModel.getCase((x-1)+i, y+1)!=null && !demineurModel.getCase((x-1)+i, y+1).isClique() ){
    				demineurModel.getCase((x-1)+i, y+1).setClique();
    				//propager((x-1)+i, y+1);
    			}
    		}
    		if(demineurModel.getCase((x-1), y)!=null &&!demineurModel.getCase((x-1), y).isClique() ) {
    			demineurModel.getCase((x-1), y).setClique();
    			//propager((x-1), y+1);
    		}
    		if( demineurModel.getCase((x+1), y)!=null&&!demineurModel.getCase((x+1), y).isClique() ) {
    			demineurModel.getCase((x+1), y).setClique();
    			//propager((x+1), y+1);
    		}
		
        }
		else return;
		
}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (demineurModel == null) {
			g.drawString("Commencer", getWidth() / 2, getHeight() / 2);
			return;
		}

		for (int ligne = 0; ligne < demineurModel.getNbLignes(); ligne++)
			for (int colonne = 0; colonne < demineurModel.getNbColonnes(); colonne++) {
				int x = getCelluleX(ligne, colonne);
				int y = getCelluleY(ligne, colonne);
//				Font font = g.getFont();
				String value = demineurModel.getCase(ligne, colonne).isClique() ? ""+demineurModel.caseAdj(ligne,colonne)
						: "?";
					
				if(demineurModel.getCase(ligne, colonne).isClique()&&demineurModel.caseAdj(ligne,colonne) == 0) {
					
					propager(ligne,colonne);
					repaint();
				}
				
//					g.setFont(font);
				if(demineurModel.getCase(ligne, colonne).isClique()&&demineurModel.caseAdj(ligne,colonne) >= 0 && demineurModel.caseAdj(ligne,colonne)<=4) 
					g.setColor(couleur[demineurModel.caseAdj(ligne,colonne)]);
				if(demineurModel.getCase(ligne, colonne).isClique()&&demineurModel.getCase(ligne, colonne).isMine())
					value = "X";
				
				if(demineurModel.getCase(ligne, colonne).isClique()&&demineurModel.getCase(ligne, colonne).isMine()){
					gameOver(g);
				}
				g.drawString(value, x + (DX / 2), y + (DY / 2));
				g.setColor(Color.BLACK);
				g.drawRect(x, y, DX, DY);
				

			}
	}

	public int getLigne(int x, int y) {
		return y / DY;
	}

	public int getColonne(int x, int y) {
		return x / DX;
	}

	public int getCelluleX(int ligne, int colonne) {
		return colonne * DX;
	}

	public int getCelluleY(int ligne, int colonne) {
		return ligne * DY;
	}

}