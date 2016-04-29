package labBalloon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BalloonApp extends JFrame {

	private JPanel contentPane;	
	private JPanel bottomJPanel;
	private JPanel centerJPanel;

	private JButton leftButton;
	private JButton rightButton;
	private JButton randomsButton;
	
	private JTextField equalsTextField;
	
	private JLabel topBalloonLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalloonApp frame = new BalloonApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BalloonApp() {
		
		//JFrame's properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		//Content pane
		createContentPane();
		
		//Lab Balloon label
		createTopPanel();
		
		//Bottom JPanel & components
		createBottomPanelComponents();
		
		//Center JPanel & components
		createCenterBalloonSelection();
	}

	
	private class randomButtonHandler implements ActionListener {
		
		Random isHelium = new Random();
		
		public void actionPerformed(ActionEvent e) {
			
			Balloon leftBalloon = createBalloon(Size.randomEnumGenerator(), isHelium.nextBoolean());
			Balloon rightBalloon = createBalloon(Size.randomEnumGenerator(), isHelium.nextBoolean());
			
			leftButton.setIcon(leftBalloon.getIcon());
			leftButton.setText(leftBalloon.toString());
			
			rightButton.setIcon(rightBalloon.getIcon());
			rightButton.setText(rightBalloon.toString());
			
			if(leftBalloon.equals(rightBalloon)) {
				
				equalsTextField.setBackground(Color.DARK_GRAY);
				equalsTextField.setForeground(Color.WHITE);
				equalsTextField.setText("Equal");
				
			}
			else {
				
				equalsTextField.setBackground(Color.WHITE);
				equalsTextField.setForeground(Color.BLACK);
				equalsTextField.setText("Not equal");
				
			}
		}	
	}
	
	private Balloon createBalloon(Size size, boolean isHelium) {
		
		Icon xSmallBalloonIcon = new ImageIcon(getClass().getResource("balloon20.jpg"));
		Icon smallBalloonIcon = new ImageIcon(getClass().getResource("balloon40.jpg"));
		Icon mediumBalloonIcon = new ImageIcon(getClass().getResource("balloon60.jpg"));
		Icon largeBalloonIcon = new ImageIcon(getClass().getResource("balloon80.jpg"));
		Icon xLargeBalloonIcon = new ImageIcon(getClass().getResource("balloon100.jpg"));
		
		Balloon randomBalloon = new Balloon(size, isHelium);
		
		switch(size) {
		
		case XS: 
			randomBalloon = new Balloon(size, isHelium, xSmallBalloonIcon);
			break;
			
		case S: 
			randomBalloon = new Balloon(size, isHelium, smallBalloonIcon);
			break;
		
		case M: 
			randomBalloon = new Balloon(size, isHelium, mediumBalloonIcon);
			break;
		
		case L: 
			randomBalloon = new Balloon(size, isHelium, largeBalloonIcon);
			break;
		
		case XL: 
			randomBalloon = new Balloon(size, isHelium, xLargeBalloonIcon);
			break;
		
		default: 
			break;
		
		}
		
		return randomBalloon;
	}
	
	
	private void createContentPane() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	}
	
	private void createBottomPanelComponents() {
		
		bottomJPanel = new JPanel();
		bottomJPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.add(bottomJPanel, BorderLayout.SOUTH);
		bottomJPanel.setLayout(new FlowLayout());
		
		randomsButton = new JButton("Get Random Balloons");
		randomsButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		bottomJPanel.add(randomsButton);
		randomsButton.addActionListener(new randomButtonHandler());
		
		equalsTextField = new JTextField();
		equalsTextField.setHorizontalAlignment(SwingConstants.CENTER);
		equalsTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		equalsTextField.setEditable(false);
		equalsTextField.setColumns(10);
		bottomJPanel.add(equalsTextField);
		
	}

	private void createCenterBalloonSelection() {
		
		centerJPanel = new JPanel();
		centerJPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(centerJPanel, BorderLayout.CENTER);
		centerJPanel.setLayout(new GridLayout(1, 2, 10, 5));
		
		leftButton = new JButton();
		leftButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		leftButton.setContentAreaFilled(false);
		leftButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		leftButton.setHorizontalTextPosition(SwingConstants.CENTER);
		leftButton.setIcon(null);
		centerJPanel.add(leftButton);
		
		rightButton = new JButton();
		rightButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		rightButton.setContentAreaFilled(false);
		rightButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		rightButton.setHorizontalTextPosition(SwingConstants.CENTER);
		rightButton.setIcon(null);
		centerJPanel.add(rightButton);
		
	}

	private void createTopPanel() {
		
		topBalloonLabel = new JLabel("Lab Ballon");
		topBalloonLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topBalloonLabel.setBorder(new EmptyBorder(0, 5, 10, 5));
		topBalloonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(topBalloonLabel, BorderLayout.NORTH);
		
	}
}