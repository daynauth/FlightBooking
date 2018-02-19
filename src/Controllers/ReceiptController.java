package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.ReceiptPanel;

public class ReceiptController extends Controller {
	private ReceiptPanel receiptPanel;

	public ReceiptController(MainController mainController) {
		super(mainController);
		
		receiptPanel = new ReceiptPanel();
		receiptPanel.addFeeInformation(mainController.getBooking().getBaggageFee());
		receiptPanel.submitListener(new SubmitAction());
		
	}

	@Override
	public void setPanel() {
		mainController.getGUI().replacePanel(receiptPanel);
		
	}
	
	public class SubmitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainController.getBooking().checkIn();
			mainController.setState(new WelcomeController(mainController));		
		}
		
	}

}
