import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	GamePanel gamepanel;
	ButtonPanel(GamePanel gamepanel){
		this.gamepanel=gamepanel;
		this.setOpaque(false);
		JButton reset=new JButton("Reset Board");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				gamepanel.resetGame();
				gamepanel.repaint();
			}
		});
		this.add(reset);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//gamepanel.repaint();
		
	}
}
