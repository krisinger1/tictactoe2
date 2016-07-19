import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class GameBoard {
	final int OFFSETX=25;
	final int OFFSETY=25;
	GameCell board[][]=new GameCell[3][3];
	int boardWidth=300;
	GameBoard(){
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				board[i][j]=new GameCell();
				//board[i][j].setValue(0);
				board[i][j].setBounds(new Rectangle(j*(boardWidth/3)+OFFSETX,i*(boardWidth/3)+OFFSETY,(boardWidth/3),(boardWidth/3)));
				board[i][j].setLocation(new Point(j*(boardWidth/3)+OFFSETX,i*(boardWidth/3)+OFFSETY));
			}
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(OFFSETX,OFFSETY,boardWidth,boardWidth);
	}
	
	public void resetBoard(){
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				board[i][j].setValue(0);
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
		g.drawLine((boardWidth/3)+OFFSETX, 0+OFFSETY, boardWidth/3+OFFSETX, boardWidth+OFFSETY);
		g.drawLine(2*(boardWidth/3)+OFFSETX, 0+OFFSETY, 2*boardWidth/3+OFFSETX, boardWidth+OFFSETY);
		//g.drawLine((boardWidth/3)+0, 0+0, boardWidth/3+0, boardWidth+0);
		//g.drawLine(2*(boardWidth/3)+0, 0+0, 2*boardWidth/3+0, boardWidth+0);
		g.drawLine(0+OFFSETX, boardWidth/3+OFFSETY, boardWidth+OFFSETX, boardWidth/3+OFFSETY);
		g.drawLine(0+OFFSETX, 2*boardWidth/3+OFFSETY, boardWidth+OFFSETX, 2*boardWidth/3+OFFSETY);
		for (int i=0;i<3;i++){
			for (int j=0; j<3; j++){
				board[i][j].draw(g);
			}
		}
	}
	
}
