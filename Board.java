import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Board {
	private Cell[][] cells;
	private JFrame frame;
	private JPanel easyPanel;
	private int side ;
	private int numMines;
	private JPanel menu;
	private int numOfFlags;
	private int nonMines;


	Board(){
		frame = new JFrame("Minesweeper");
		frame.setLayout(new BorderLayout());
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = Menu();
		frame.add(menu, BorderLayout.CENTER);
		frame.setVisible(true);
	}


	public JPanel Menu(){
		JPanel panel = new JPanel();
		JButton easy = new JButton("Easy");
		JButton normal = new JButton("Normal");
		JButton hard = new JButton("Hard");
		JButton score = new JButton("High Scores");
		time = new Timer();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.setLayout(new GridBagLayout());



		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(easy, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(normal, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(hard, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(score, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(time, gbc);

		easy.addActionListener(new easyMode());
		normal.addActionListener(new normalMode());
		hard.addActionListener(new hardMode());
		score.addActionListener(new scoreBoard());
		return panel;
	}
	public JPanel addCells(int side){
		JPanel panel = new JPanel(new GridLayout(side,side));
		cells = new Cell[side][side];
		for(int i = 0; i < side; i++){
			for(int j = 0; j < side; j++){
				cells[i][j] = new Cell();
				cells[i][j].setId(i,j);
				cells[i][j].addMouseListener(new mouseClicking());
				panel.add(cells[i][j]);
			}
		}
		this.plantMines(side);
		this.setCellValues();
		nonMines = side*side - numMines;
		return panel;
	}
	public void plantMines(int sides){
		Random random = new Random();
		int counter = 0;
		while(counter != numMines){
			counter += cells[random.nextInt(sides)][random.nextInt(sides)].setMine();
		}
	}
	private IntStream sidesOf(int value) {
	    return IntStream.rangeClosed(value - 1, value + 1).filter(
	            x -> x >= 0 && x < side);
	}
	private Set<Cell> getSurroundingCells(int x, int y) {
	    Set<Cell> result = new HashSet<>();
	    sidesOf(x).forEach(a -> {
	        sidesOf(y).forEach(b -> result.add(cells[a][b]));
	    });
	    result.remove(cells[x][y]);
	    return result;
	}
	private void setCellValues() {
		for(int i = 0; i < side; i++){
	    	for(int j = 0; j < side; j++){
	    		if(cells[i][j].isMine() == true){
	    			Set<Cell> surrounding = getSurroundingCells(i,j);
	    			Iterator<Cell> iter = surrounding.iterator();
	    			while(iter.hasNext()){
	    				Cell temp = iter.next();
	    				if(temp.isMine() == false){
	    					int x = temp.getI();
	    					int y = temp.getJ();
	    					cells[x][y].increment();
	    				}
	    			}
	    		}
	    	}
	    }
	}
	private void scanForEmptyCells(Cell cell){
		int x = cell.getI();
		int y = cell.getJ();
		Set<Cell> surrounding = getSurroundingCells(x,y);
		Iterator<Cell> iter = surrounding.iterator();
		while(iter.hasNext()){
			Cell temp = iter.next();
			if(temp.isEmpty() == true && temp.isChecked() == false){
				temp.reveal();
				nonMines--;
				scanForEmptyCells(temp);
			}
			else{
				temp.reveal();
				nonMines--;
			}
		}
	}
	private class mouseClicking implements MouseListener{
		boolean pressed;
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("Cristian");
			//if(){

			//}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			pressed = true;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			pressed = false;

		}

		@Override
		public void mousePressed(MouseEvent e) {
			Cell temp = (Cell) e.getSource();
			temp.getModel().setArmed(true);
			temp.getModel().setPressed(true);
			pressed = true;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Cell temp = (Cell) e.getSource();
			temp.getModel().setArmed(false);
			temp.getModel().setPressed(false);
			if(pressed){
				if (SwingUtilities.isRightMouseButton(e)) {
					if(temp.isFlagged() == false){
						temp.setText("F");
						temp.setFlag(true);
					}
					else if(temp.isFlagged() == true){
						temp.setFlag(false);
						temp.setText(" ");
					}

                }
				else if(SwingUtilities.isLeftMouseButton(e)){
					if(temp.checkMine() == true && temp.isFlagged() == false){
						gameOver();
					}
					else if(temp.isEmpty() == true && temp.isFlagged() == false){
						scanForEmptyCells(temp);
						if(nonMines == 0){
							win();
						}
					}
					else if(temp.isFlagged() == false){
						temp.reveal();
						nonMines--;
						if(nonMines == 0){
							win();
						}
					}
				}
			}
			pressed = false;
		}

	}
	private class easyMode implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.remove(menu);
			SwingUtilities.updateComponentTreeUI(frame);
			numMines = 9;
			side = 10;
			frame.add(addCells(10), BorderLayout.CENTER);
			JButton test = new JButton();
			test.setText("Cristain loves loli");
			frame.add(test, BorderLayout.NORTH);
		}

	}
	public void gameOver(){
		this.revealBoard();
	}
	public void revealBoard(){
		for(int i = 0; i < side ; i++){
			for(int j = 0; j < side; j++){
				if(cells[i][j].isChecked() != true){
					cells[i][j].reveal();
				}
			}
		}
	}
	private class normalMode implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.remove(menu);
			numMines = 50;
			side = 15;
			frame.add(addCells(15));
			SwingUtilities.updateComponentTreeUI(frame);
		}

	}
	private class hardMode implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.remove(menu);
			numMines = 100;
			side = 20;
			frame.add(addCells(20));
			frame.setSize(800,800);
			SwingUtilities.updateComponentTreeUI(frame);
		}

	}

	private class scoreBoard implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.remove(menu);
			numMines = 100;
			side = 20;
			frame.add(addCells(20));
			frame.setSize(800,800);
			SwingUtilities.updateComponentTreeUI(frame);
		}

	}

	public void win(){
		this.revealBoard();
	}
}
