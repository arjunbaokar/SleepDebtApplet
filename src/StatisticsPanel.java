import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class StatisticsPanel extends JPanel{

	public Font defaultFont = new Font("Tahoma", Font.PLAIN, 16);
	public int topX = 100;
	public int topY = 75;
	
	public void paintComponent(Graphics g){
		this.setFont(defaultFont);
		g.drawString("Estimate IQ Loss: ", topX, topY);
		g.drawString("Sleep Debt per week: ", topX, topY + 50);
		g.drawString("Total sleep debt: ", topX, topY + 100);
		g.drawString("Overall Sleep Health: ", topX, topY + 200);
	}
	
}
