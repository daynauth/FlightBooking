package Views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReceiptPanel extends JPanel{
	private JLabel feeInfo;
	private JButton checkIn;
	
	public ReceiptPanel(){
		feeInfo = new JLabel();
		this.add(feeInfo);
		
		checkIn = new JButton("Finish");
		this.add(checkIn);
	}
	
	public void addFeeInformation(double fee){
		feeInfo.setText("Your new fee is " + fee);
	}
	
	public void submitListener(ActionListener  e){
		checkIn.addActionListener(e);
	}
	
}
