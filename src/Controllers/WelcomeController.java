package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.WelcomePanel;

public class WelcomeController extends Controller{
	private WelcomePanel welcomePanel;

	public WelcomeController(MainController mainController) {
		super(mainController);
		
		welcomePanel = new WelcomePanel();
		
		String buttonText;
		ActionListener a;
		
		if(mainController.checkFull()){
			buttonText = "Report"; 
			a = new ReportAction();
		}
		else{
			buttonText = "Sign In";
			a = new SigninAction();
		}
		
		welcomePanel.getButton().setText(buttonText);
		welcomePanel.setButtonListener(a);
	}
	
	

	@Override
	public void setPanel() {
		mainController.getGUI().replacePanel(this.welcomePanel);	
	}
	
	public class SigninAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainController.setState(new LoginController(mainController));
			
		}	
	}
	
	public class ReportAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainController.setState(new ReportController(mainController));
			
		}	
	}

}
