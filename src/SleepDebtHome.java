import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SleepDebtHome extends JFrame {
	private Container contentPane;
	private CardLayout cards;
	
	private HomePanel homePanel;
	private StatisticsPanel statisticsPanel;
	private LogPanel logPanel;
	private NavBar navBar;
	
	private File debtFile;
	
	public SleepDebtHome() {
		// JFrame Settings
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(200, 60);
		setSize(500, 650);
		setVisible(true);
		setTitle("Sleep Debt Calculator");
		
		// Files
		debtFile = new File("sleepDebt.txt");
		
		// Panels and Container
		contentPane = this.getContentPane();
		cards = new CardLayout();
		contentPane.setLayout(cards);
		
		homePanel = new HomePanel();
		this.add(homePanel, "Welcome");
		
		statisticsPanel = new StatisticsPanel();
		this.add(statisticsPanel, "Statistics");
		
		logPanel = new LogPanel();
		this.add(logPanel, "Log");
	}
	
	public static void main (String[] args) {
		SleepDebtHome application = new SleepDebtHome();
	}
	
	public void WaitForHome(JFrame component, Image image) {	// try-catch block for images
		MediaTracker tracker = new MediaTracker(component);
		try {
			tracker.addImage(image, 0);
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
