package Controllers;

public class ReportController extends Controller {

	public ReportController(MainController mainController) {
		super(mainController);
		mainController.getAirport().generateReport();
	}

	@Override
	public void setPanel() {
		// TODO Auto-generated method stub
		
	}

}
