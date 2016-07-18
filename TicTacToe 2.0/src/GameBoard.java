import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class GameBoard {
	GameCell board[][]=new GameCell[3][3];
	int boardWidth=300;
	GameBoard(){
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				board[i][j]=new GameCell();
				//board[i][j].setValue(0);
				board[i][j].setBounds(new Rectangle(j*(boardWidth/3),i*(boardWidth/3),(boardWidth/3),(boardWidth/3)));
				board[i][j].setLocation(new Point(j*(boardWidth/3),i*(boardWidth/3)));
			}
		}
	}
	
	
	public GameCell getCellLocation(Point p){
		 for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j].contains(p)) {
	                    return board[i][j];
	                }
	            }
	        }
	        return null;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.drawLine((boardWidth/3), 0, boardWidth/3, boardWidth);
		g.drawLine(2*(boardWidth/3), 0, 2*boardWidth/3, boardWidth);
		g.drawLine(0, boardWidth/3, boardWidth, boardWidth/3);
		g.drawLine(0, 2*boardWidth/3, boardWidth, 2*boardWidth/3);
		for (int i=0;i<3;i++){
			for (int j=0; j<3; j++){
				board[i][j].draw(g);
			}
		}
	}
	
}
