import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class GameCell {
	int value=0;
	Rectangle bounds;
	Point cellLocation;
	
	
	GameCell(){
		value=0;
	}
	
	public void setValue(int value){
	if (value==-1||value==0||value==1){
			this.value=value;
		}
	}
	
	public int getValue(){
		return value;
	}
	
	public void setLocation(Point p){
		cellLocation = p;
	}
	
	public Point getLocation(){
		return cellLocation;
	}
	
	public void setBounds(Rectangle r){
		bounds=r;
	}
	
	public boolean contains(Point p){
		return bounds.contains(p);
	}
	
	public boolean isTaken(){
		if (value==1 || value==-1) {
			JOptionPane.showMessageDialog(null, "PLease choose and open square");
			return true;
		}
		else return false;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		//g.fillRect(cellLocation.x, cellLocation.y, bounds.width, bounds.width);
		g.setColor(Color.BLACK);
		if (value==1){
			g.drawLine(cellLocation.x, cellLocation.y, cellLocation.x+bounds.width, cellLocation.y+bounds.width);
			g.drawLine(cellLocation.x+bounds.width, cellLocation.y, cellLocation.x, cellLocation.y+bounds.width);

		}
		//if (value==1)g.drawLine(0, 0, 100, 100);

		else if (value==-1) g.drawOval(cellLocation.x, cellLocation.y, bounds.width, bounds.width);
	}
}
