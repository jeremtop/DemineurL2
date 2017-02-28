package model;

public class Case {

	private DemineurModel demineurModel;
	private boolean clique;
	private boolean mine;
	
	private int x;
	private int y;
	
	public Case(int x, int y) {

		this.mine=false;
		this.x=x;
		this.y=y;
		this.clique=false;
	}
	
	public void ajouterMine(boolean mine) {
		
		this.mine = mine;
		
	}
	

	public boolean isClique() {
		return clique;
	}

	public void setClique() {
		this.clique = true;
	}

	public boolean isMine() {
		return mine;
	}



	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
