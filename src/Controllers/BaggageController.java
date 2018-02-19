package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Baggage;
import Views.BaggagePanel;

public class BaggageController extends Controller{
	private BaggagePanel baggagePanel;

	public BaggageController(MainController mainController) {
		super(mainController);
		
		baggagePanel = new BaggagePanel();
		baggagePanel.setSubmitListener(new SubmitAction());
	}

	public void setPanel() {
		mainController.getGUI().replacePanel(this.baggagePanel);
		
	}
	
	public class SubmitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int height = baggagePanel.getBaggageHeight();
			int width = baggagePanel.getBaggageWidth();
			int depth = baggagePanel.getBaggageDepth();
			int weight = baggagePanel.getBaggageWeight();
			
			Baggage baggage = new Baggage(width, height,depth, weight);
			mainController.getBooking().getPassenger().addBaggage(baggage);			
			mainController.setState(new ReceiptController(mainController));			
		}
		
	}
	
}
