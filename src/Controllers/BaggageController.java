package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Baggage;
import views.BaggagePanel;

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
			
			
			if(height == -1 || width == -1 || depth == -1 || weight == -1) {
				if(height == -1)baggagePanel.getHeightError().setVisible(true);
				else baggagePanel.getHeightError().setVisible(false);
				if(width == -1)baggagePanel.getWidthError().setVisible(true);
				else baggagePanel.getWidthError().setVisible(false);
				if(weight == -1)baggagePanel.getWeightError().setVisible(true);
				else baggagePanel.getWeightError().setVisible(false);
				if(depth == -1)baggagePanel.getDepthError().setVisible(true);
				else baggagePanel.getDepthError().setVisible(false);
				baggagePanel.showError("Please fill all fields");
			}else {
				Baggage baggage = new Baggage(width, height,depth, weight);
				mainController.getBooking().getPassenger().addBaggage(baggage);			
				mainController.setState(new ReceiptController(mainController));
			}
			
						
		}
		
	}
	
}
