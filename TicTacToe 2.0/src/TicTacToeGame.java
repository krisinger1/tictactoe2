	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TicTacToeGame {

	   
	 
	    TicTacToeGame(){
	    	JFrame frame = new JFrame();
	    	frame.setLayout(new FlowLayout());
	    	frame.setPreferredSize(new Dimension(600,400));
	    	GamePanel gamePanel = new GamePanel(new GameBoard());
	    	ButtonPanel buttonPanel = new ButtonPanel(gamePanel);
	    	//gamePanel.setLayout(new BorderLayout());
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.getContentPane().setBackground(new Color(255,255,255));
	    	gamePanel.setOpaque(false);
	    	frame.add(gamePanel);
	    	frame.add(buttonPanel);
	    	frame.setVisible(true);
	    	frame.pack();
	    }
	    
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable(){
	        	public void run(){
	        		new TicTacToeGame();
	        	}
	        });
	        	
	    }
	 
}
