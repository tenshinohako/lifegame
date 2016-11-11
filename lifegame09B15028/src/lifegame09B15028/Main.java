package lifegame09B15028;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Main implements Runnable{
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Main());
	}
	
	public void run(){
		BoardModel model = new BoardModel(10, 10);
		BoardView view = new BoardView(model);
		BoardNext next = new BoardNext(model);
		BoardUndo undo = new BoardUndo(model);
		BoardNew newButton = new BoardNew(this);
	
		//ウィンドウを表示
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Lifegame09B15028");
		
		//盤面を描くパネル
		JPanel base = new JPanel();
		frame.setContentPane(base);
		base.setPreferredSize(new Dimension(700, 800));
		frame.setMinimumSize(new Dimension(300, 200));
		base.setLayout(new BorderLayout());
		base.add(view, BorderLayout.CENTER);
		
		//ボタンを設置するパネル
		JPanel buttonPanel = new JPanel();
		base.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout());
		
		//Nextボタン
		JButton buttonNext = new JButton();
		buttonNext.setText("Next");
		buttonPanel.add(buttonNext);
		buttonNext.addActionListener(next);
		
		//Undoボタン
		JButton buttonUndo = new JButton();
		buttonUndo.setText("Undo");	
		buttonUndo.setEnabled(false);
		buttonPanel.add(buttonUndo);
		buttonUndo.addActionListener(undo);
		
		//NewGameボタン
		JButton buttonNew = new JButton();
		buttonNew.setText("New Game");
		buttonPanel.add(buttonNew);
		buttonNew.addActionListener(newButton);
		
		model.addListener(new CheckEnable(buttonUndo));
		model.addListener(new BoardRepaint(view));
		
		frame.pack();
		frame.setVisible(true);
	}
}