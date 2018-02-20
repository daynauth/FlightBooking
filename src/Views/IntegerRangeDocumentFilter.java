package Views;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class IntegerRangeDocumentFilter extends DocumentFilter{
	private final int max;
	private final int min;
	
	public IntegerRangeDocumentFilter(int min, int max){
		this.min = min;
		this.max = max;
	}
	
	public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException{
		if(str == null)return;
		else{
			String val;
			Document doc = fb.getDocument();
		}
	}
}
