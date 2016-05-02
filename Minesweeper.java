

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Minesweeper implements ActionListener {
	
	JFrame frame = new JFrame("Minesweeper");
	JButton easy = new JButton("Easy");
	JButton medium = new JButton("Medium");
	JButton hard = new JButton("Hard");
	JButton score = new JButton("High Scores");
	JButton[][] easygrid = new JButton[10][10];
	JPanel welcome = new JPanel();
	JPanel selection = new JPanel();
	JLabel wtext = new JLabel("Welcome! Please select a difficulty to begin a game!");
	Container easycontainer = new Container();
	
	BorderLayout bl = new BorderLayout();
	
	
	
	public Minesweeper(){
		title();
	}
	
	public Component title(){
		frame.setSize(500,500);
		frame.setLayout(bl);

		frame.add(selection(), BorderLayout.CENTER);
		
		welcome.add(wtext);
		frame.add(welcome, BorderLayout.NORTH);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		return frame;
	}
	
	public Component selection(){
		selection.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		score.addActionListener(this);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		selection.add(easy,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		selection.add(medium,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		selection.add(hard,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		selection.add(score,gbc);
		
		return selection;
	}
	
	private Component easyGame(){
		welcome.hide();
		selection.hide();
		
		Grid egame = new Grid(10,10);
		
		easycontainer.setLayout(new GridLayout(10,10));
		for(int r = 0; r < easygrid.length; r++){
			for(int c = 0; c < easygrid.length; c++){
				easygrid[r][c] = new JButton();
				easycontainer.add(easygrid[r][c]);
			}
		}
		
		
		
		frame.add(easycontainer, BorderLayout.CENTER);
		
		
		return frame;
	}
	
	private void generateMines(){
		
	}

	
	public void actionPerformed(ActionEvent event){
		if(event.getSource().equals(easy)){
			easyGame();
		}
		if(event.getSource().equals(medium)){
			System.out.println("You click medium");
		}
		if(event.getSource().equals(hard)){
			System.out.println("You click hard");
		}
		if(event.getSource().equals(score)){
			System.out.println("You click score");
		}
	}
	
}
