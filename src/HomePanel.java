import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class HomePanel extends JPanel {
	private JPanel navAndTitleBar, contentPanel;
	
	public HomePanel() {
		this.setLayout(null);
		
		navAndTitleBar = new NavBar();
		navBar.setBounds(0, 0, 500, 150);
		navBar.setBackground(Color.blue);
		this.add(navAndTitleBar);
		
		contentPanel = new ContentPanel();
		contentPanel.setBounds(0, 150, 500, 650);
		contentPanel.setBackground(Color.blue);
		this.add(contentPanel);
		
		
	}
	
	public void WaitForImage(JFrame component, Image image) {	// try-catch block for images
		MediaTracker tracker = new MediaTracker(component);
		try {
			tracker.addImage(image, 0);
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class ContentPanel extends JPanel implements MouseListener {
		private boolean asleep = false;
		private JTextArea welcomeMessage;
		
		public ContentPanel() {
			addMouseListener(this);
			this.setLayout(null);
			
			welcomeMessage = new JTextArea();
			welcomeMessage.setBounds(20, 40, 460, 300);
			welcomeMessage.setEditable(false);
			welcomeMessage.setForeground(Color.white);
			welcomeMessage.setOpaque(false);
			welcomeMessage.setWrapStyleWord(true);
			welcomeMessage.setLineWrap(true);
			welcomeMessage.setFont(SleepDebtHome.DEFAULT_FONT);
			this.add(welcomeMessage);
		}
		
		@SuppressWarnings("serial")
		class DrawingArea extends JPanel {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				loadWelcome();
				drawWelcomeMessage(g);
				drawButtons(g);
			}
		}
		
		private void loadWelcome() {
			Scanner readWelcomeMessage = null;
			StringBuilder instructions = new StringBuilder();
			try {
				readWelcomeMessage = new Scanner(new File("welcome.txt"));
				while (readWelcomeMessage.hasNext()) {
					instructions.append(readWelcomeMessage.next() + " ");
				}
			} catch (FileNotFoundException e) {
				System.out.println("Welcome Message not found!");
			} finally {
				readWelcomeMessage.close();
			}
			welcomeMessage.setText(instructions.toString());
		}
		
		private void drawWelcomeMessage(Graphics g) {
			g.setColor(Color.white);
			g.setFont(SleepDebtHome.HEADER_FONT);
			g.drawString("Welcome!", 20, 10);
		}
		
		private void drawButtons(Graphics g) {
			Image displayedButton = asleep ? SleepDebtHome.awakeButton : SleepDebtHome.sleepButton;
			g.drawImage(displayedButton, 20, 480, this);
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseClicked(MouseEvent e) {
			int x = e.getX(), y = e.getY();	// Grab position of mouseclick event.
			
			contentPanel.repaint();
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
	}
}
