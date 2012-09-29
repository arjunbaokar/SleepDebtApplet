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
	
	public NavBar(){
		super();
		try{
			homeTitle = ImageIO.read( new File("INSERTIMAGENAME") );
			statsTitle = ImageIO.read( new File("INSERTIMAGENAME") );
			logTitle = ImageIO.read( new File("INSERTIMAGENAME") );
			settingsTitle = ImageIO.read( new File("INSERTIMAGENAME") );
			butPress1 = ImageIO.read( new File("INSERTIMAGENAME") );
			butPress2 = ImageIO.read( new File("INSERTIMAGENAME") );
			butPress3 = ImageIO.read( new File("INSERTIMAGENAME") );
			butPress4 = ImageIO.read( new File("INSERTIMAGENAME") );
			butUnpress1 = ImageIO.read( new File("INSERTIMAGENAME") );
			butUnpress2 = ImageIO.read( new File("INSERTIMAGENAME") );
			butUnpress3 = ImageIO.read( new File("INSERTIMAGENAME") );
			butUnpress4 = ImageIO.read( new File("INSERTIMAGENAME") );
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
