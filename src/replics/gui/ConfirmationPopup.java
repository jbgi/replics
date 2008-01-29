package replics.gui;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class ConfirmationPopup {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="298,57"
	private Label label = null;
	private Button button = null;

	public ConfirmationPopup(){
		createSShell();
		this.sShell.setVisible(true);
	}
	
	private void createSShell() {
		sShell = new Shell();
		sShell.setSize(new org.eclipse.swt.graphics.Point(211,145));
		label = new Label(sShell, SWT.NONE);
		label.setBounds(new org.eclipse.swt.graphics.Rectangle(47,16,110,15));
		button = new Button(sShell, SWT.NONE);
		button.setBounds(new org.eclipse.swt.graphics.Rectangle(57,62,89,24));
		button.setText("CLOSE");
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				sShell.setVisible(false);
			}
		});
	}
	
	public void setText(String s){
		this.label.setText(s);
	}
}
