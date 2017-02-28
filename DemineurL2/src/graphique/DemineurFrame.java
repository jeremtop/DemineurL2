package graphique;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.DemineurModel;

public class DemineurFrame extends JFrame {
	/** Serial UID.  */
	private static final long serialVersionUID = 1L;
	
	private DemineurPanel demineurPanel = new DemineurPanel();

	public DemineurFrame() {
		setSize(new Dimension(480, 500));
		add(demineurPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setDemineurModel(DemineurModel demineurModel) {
		demineurPanel.setDemineurModel(demineurModel);
	}
}