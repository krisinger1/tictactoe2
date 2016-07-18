import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameBoard model;
	int player=1;
	int numplays=0;
	
	
	GamePanel(GameBoard model){
		this.model=model;
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				chooseCell(model.getCellLocation(e.getPoint()));
            }
        });
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(300,300);
	}
	
	private void chooseCell(GameCell cell){
		if (!cell.isTaken()){
			if (player==1){
				cell.setValue(1);
			}
			else cell.setValue(-1);
			player=-1*player;
			numplays++;
		}
        repaint();

		int winner = checkForWinner();
		if (numplays==9 && winner==0){
			JOptionPane.showMessageDialog(null, "Cat's game");
		}
		else if(winner!=0){
			if (winner==1)JOptionPane.showMessageDialog(null, "X wins!");
			else JOptionPane.showMessageDialog(null, "O wins!");
		}
	}
	
	private int checkForWinner(){
		//check rows
		for(int i=0;i<3;i++){
			int rowsum=0;
			int colsum=0;
			int diagsum=0;
			int otherdiagsum=0;
			for (int j=0;j<3;j++){
				rowsum+=model.board[i][j].getValue();
				colsum+=model.board[j][i].getValue();
				if (i==0)diagsum+=model.board[j][j].getValue();
				if (i==0)otherdiagsum+=model.board[j][2-j].getValue();
			}
			if (rowsum==-3||colsum==-3||diagsum==-3||otherdiagsum==-3)return -1;
			else if (rowsum==3||colsum==3||diagsum==3||otherdiagsum==3)return 1;
		}
		return 0;
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.draw(g);
    }
}
