package lifegame09B15028;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class BoardView extends JPanel implements BoardListener, MouseListener, MouseMotionListener{
	
	private BoardModel model;
	private int squareLength;
	private int nowX;
	private int nowY;
	private int previousX;
	private int previousY;	
	
	public BoardView(BoardModel m){
		model = m;
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		squareLength = Math.min(this.getHeight()/(model.getRows()+2), this.getWidth()/(model.getCols()+2));
		
		for(int i=0; i<model.getRows()+1; i++){
			g.drawLine(squareLength, squareLength*(i+1), squareLength*(model.getCols()+1), squareLength*(i+1));
			g.drawLine(squareLength*(i+1), squareLength, squareLength*(i+1), squareLength*(model.getRows()+1));
		}
		
		for(int i=0; i<model.getRows(); i++){
			for(int j=0; j<model.getCols(); j++){
				if(model.isAlive(j, i)){
					g.fillRect(squareLength*(j+1), squareLength*(i+1), squareLength, squareLength);
				}
			}
		}
	}
	
	public void mouseClicked(MouseEvent e){
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
	
	public void mouseExited(MouseEvent e){
		
	}
	
	public void mousePressed(MouseEvent e){
		nowX = (int)Math.floor(e.getX()/squareLength-1);
		nowY = (int)Math.floor(e.getY()/squareLength-1);
		
		if(0 <= nowX && nowX < model.getCols() && 0 <= nowY && nowY < model.getRows()){
			model.changeCellState(nowX, nowY);
			repaint();
		}
			
		previousX = nowX;
		previousY = nowY;
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	public void mouseDragged(MouseEvent e){
		nowX = (int)Math.floor(e.getX()/squareLength-1);
		nowY = (int)Math.floor(e.getY()/squareLength-1);
		
		if((nowX != previousX || nowY != previousY) && 
			0 <= nowX && nowX < model.getCols() && 0 <= nowY && nowY < model.getRows()){
			model.changeCellState(nowX, nowY);
			repaint();
		}
		
		previousX = nowX;
		previousY = nowY;
	}
	
	public void mouseMoved(MouseEvent e){
		
	}
	
	public void updated(BoardModel model){

	}
}
