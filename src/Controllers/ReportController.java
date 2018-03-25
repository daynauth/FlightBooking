package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.ReportPanel;

public class ReportController extends Controller {
	private ReportPanel reportPanel;
	
	public ReportController(MainController mainController) {
		super(mainController);
		reportPanel = new ReportPanel();
		
		reportPanel.setText(mainController.getAirport().generateReport());
		reportPanel.setButtonListener(new ReturnListener());
	}

	@Override
	public void setPanel() {
		mainController.getGUI().replacePanel(this.reportPanel);	
	}
	
	public class ReturnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainController.setState(new WelcomeController(mainController));				
		}
		
	}

}
