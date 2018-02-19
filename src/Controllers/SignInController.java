package Controllers;

import java.awt.event.ActionListener;

public abstract class SignInController implements ActionListener{
	protected MainController mainController;
	
	public void SignInController(MainController controller){
		this.mainController = controller;
	}
}
