package lifegame09B15028;

public class BoardRepaint implements BoardListener {
	
	private BoardView view;
	
	public BoardRepaint(BoardView v){
		view = v;
	}

	@Override
	public void updated(BoardModel m) {
		view.repaint();
	}

}
