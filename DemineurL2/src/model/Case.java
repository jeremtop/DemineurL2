package model;

public class Case {

	
	private boolean clique;
	private boolean mine;
	private boolean flag;
	private int x;
	private int y;
	private DemineurModel demineurModel;
	
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

	public boolean isFlag() {
		return flag;
	}
	
	public void setFlag() {
		if(!flag) {
			this.flag = true;
			//demineurModel.setCpt((demineurModel.getCpt())+1);
		}
			
		else {
			this.flag = false;
			//demineurModel.setCpt((demineurModel.getCpt())-1);
		}
			
	}
	
}
