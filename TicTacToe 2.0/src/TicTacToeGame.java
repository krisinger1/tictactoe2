	import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TicTacToeGame {

	   
	 
	    TicTacToeGame(){
	    	JFrame frame = new JFrame();
	    	GamePanel gamePanel = new GamePanel(new GameBoard());
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.getContentPane().setBackground(new Color(255,255,255));
	    	gamePanel.setOpaque(false);
	    	frame.add(gamePanel);
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
