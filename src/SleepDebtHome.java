import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

public class SleepDebtHome extends JFrame {
	public static final Font HEADER_FONT = new Font("Tahoma", Font.BOLD, 20);
	public static final Font DEFAULT_FONT = new Font("Tahoma", Font.PLAIN, 12);
	
	private Container contentPane;
	private CardLayout cards;
	
	private HomePanel homePanel;
	private StatisticsPanel statisticsPanel;
	private LogPanel logPanel;
	private NavBar navBar;
	
	private static File debtFile;
	public static Image sleepButton, awakeButton;
	private Map nightlyDebt;
	
	private static final int DAY_INDEX = 0;
	private static final int SLEEP_DEBT_INDEX = 1;
	public static final int NORMAL_SLEEP_HOURS = 8; 
	
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
		
		cards.show(contentPane, "Welcome");
		
		// Data Structures
		nightlyDebt = new HashMap<Integer, Integer>();
		
		// Images
		sleepButton = Toolkit.getDefaultToolkit().getImage("../images/sleep.png");
		WaitForImage(this, sleepButton);
		
		awakeButton = Toolkit.getDefaultToolkit().getImage("../images/awake.png");
		WaitForImage(this, awakeButton);
	}
	
	public static void main (String[] args) {
		SleepDebtHome application = new SleepDebtHome();
		application.importFile(debtFile);
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
	
	public void importFile(File dataFile) {
		Scanner loadData = null;
		try {
			loadData = new Scanner(dataFile);
			while (loadData.hasNext()) {
				String[] entry = loadData.nextLine().split("\t");	// Entry 0 - Day, Entry 1 - Sleep Debt
				nightlyDebt.put(entry[DAY_INDEX], entry[SLEEP_DEBT_INDEX]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Data file cannot be found.");
			System.exit(1);
		} finally {
			loadData.close();
		}
	}
}
