package lifegame09B15028;

public class ModelPrinter implements BoardListener{
	
	public void updated(BoardModel model){
		model.printForDebug();
	}
	
}
