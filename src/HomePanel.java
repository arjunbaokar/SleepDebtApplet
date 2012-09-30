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
		navAndTitleBar.setBounds(0, 0, 500, 150);
		navAndTitleBar.setBackground(Color.black);
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
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			loadWelcome();
			drawWelcomeMessage(g);
			
			// Draw appropriate button.
			if (asleep) {
				g.drawImage(SleepDebtHome.sleepButton, 55, 200, this);
			} else {
				g.drawImage(SleepDebtHome.awakeButton, 55, 200, this);
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
			g.drawString("Welcome!", 20, 20);			
		}
		
		private void processClick() {
			// Change button to other type of button.
			// If awake, record the system time.  If asleep, calculate sleep debt, add to map.
			asleep = !asleep;
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseClicked(MouseEvent e) {
			int x = e.getX(), y = e.getY();	// Grab position of mouseclick event.
			if (x >= 65 && x <= 415 && y >= 380 && y <= 530) {
				processClick();
			}
			contentPanel.repaint();
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
	}
}
