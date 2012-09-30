import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class NavBar extends JPanel implements MouseListener, MouseMotionListener{

	int xPos, yPos, xPosHover, yPosHover;
	boolean mouseClicked, mouseMoved = false;
	BufferedImage homeTitle, statsTitle, logTitle, settingsTitle;
	BufferedImage butPress1, butPress2, butPress3, butPress4;
	BufferedImage butUnpress1, butUnpress2, butUnpress3, butUnpress4;
	BufferedImage dayBg, nightBg;
	
	public NavBar(){
		super();
		try{
			/* homeTitle = ImageIO.read( new File("INSERTIMAGENAME") );
			statsTitle = ImageIO.read( new File("INSERTIMAGENAME") );
			logTitle = ImageIO.read( new File("INSERTIMAGENAME") );
			settingsTitle = ImageIO.read( new File("INSERTIMAGENAME") ); */
			butPress1 = ImageIO.read( new File("images/home_nav_button_depressed.png") );
			butPress2 = ImageIO.read( new File("images/stats_nav_button_depressed.png") );
			butPress3 = ImageIO.read( new File("images/sleepLog_nav_button_depressed.png") );
			butPress4 = ImageIO.read( new File("images/settings_nav_button_depressed.png") );
			butUnpress1 = ImageIO.read( new File("images/home_nav_button_inactive.png") );
			butUnpress2 = ImageIO.read( new File("images/stats_nav_button_inactive.png") );
			butUnpress3 = ImageIO.read( new File("images/sleepLog_nav_button_inactive.png") );
			butUnpress4 = ImageIO.read( new File("images/settings_nav_button_inactive.png") );
			dayBg = ImageIO.read( new File("images/background_day.png") );
			nightBg = ImageIO.read( new File("images/background_night.png") );
		} catch (IOException e){
			e.printStackTrace();
		}
		
		addMouseListener(this);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		mouseClicked = false;
		mouseMoved = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		xPos = arg0.getX();
		yPos = arg0.getY();
		mouseClicked = true;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		xPosHover = arg0.getX();
		yPosHover = arg0.getY();
		mouseMoved = true;
		if (xPosHover < 50){
			repaint();
		}
	}

}
