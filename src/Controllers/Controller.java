package Controllers;

public abstract class Controller {
	protected MainController  mainController;
	
	public Controller(MainController mainController){
		this.mainController = mainController;
	}
	
	public abstract void setPanel();
	
}
