package model;

public class DemineurModel {
	private int nbLignes;
	private int nbColonnes;
	Case[][] mines;
	private int coeff = 10;
	public DemineurModel() {
		initialiser(coeff, coeff);
	}

	public boolean positionValide(int ligne, int colonne) {
		return ligne >= 0 && ligne < nbLignes && colonne >= 0 && colonne < nbColonnes;
	}

	public void clic(int ligne, int colonne) {
		if (!positionValide(ligne, colonne))
			return;
		mines[ligne][colonne].setClique();
	}

	public void initialiser(int nbLignes, int nbColonnes) {
		if (nbLignes < 0 || nbColonnes < 0 )
			return;

		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		mines = new Case[nbLignes][nbColonnes];
		for (int ligne = 0; ligne < nbLignes; ligne++) 
			for (int colonne = 0; colonne < nbColonnes; colonne++) 
				mines[ligne][colonne] = new Case(ligne,colonne);
		
		poserMine();
	}

	
	public int getNbLignes() {
		return nbLignes;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public Case getCase(int ligne, int colonne) {
		if (!positionValide(ligne, colonne))
			return null;
		return mines[ligne][colonne];
	}
	
	public boolean getMine(int ligne, int colonne) {
		if (!positionValide(ligne, colonne))
			return false;
		return mines[ligne][colonne].isMine();
	}
	
	public void poserMine() {
		int nbMines=(nbLignes*nbColonnes)/coeff;
		for (int i = 0; i < nbMines; i++) {
			int randomColonne = (int) (Math.random()*coeff);
			int randomLigne = (int) (Math.random()*coeff);
			if (mines[randomLigne][randomColonne].isMine())
				i--;
			mines[randomLigne][randomColonne].ajouterMine(true);
		}
		
	}
	
	public int caseAdj(int x, int y) {
		if((getMine(x, y)))
			return -1;
		
		int cpt = 0;
		
		for(int i = 0; i < 3;i++) {  
			if(getCase((x-1)+i, y-1)!=null && getCase((x-1)+i, y-1).isMine())
				cpt++;
			if(getCase((x-1)+i, y+1)!=null &&getCase((x-1)+i, y+1).isMine())
				cpt++;
		}
		if(getCase((x-1), y)!=null &&getCase(x-1, y).isMine())
			cpt++;
		if(getCase((x+1), y)!=null &&getCase(x+1, y).isMine())
			cpt++;
		
		return cpt;
		
	}
	
	
}