package replics.gui2;





import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import replics.gui.Welcome;

public class DBAdmin {

	static Shell sShell;
	static Table table;
	static Combo combo;
	static Button buttonSearch;
	static Label label;
	private static TableColumn colonne1;
	private static TableColumn colonne2;
	private static TableColumn colonne3;
	private static TableColumn colonne4;
	private static Slider slider;
	private static Button buttonInfo;
	private static Button buttonAddId;
	private static Button buttonDeleteId;
	
	public DBAdmin(){
		createShell();
	}
	
	public static void createShell(){
		sShell=new Shell();
		sShell.setSize(new org.eclipse.swt.graphics.Point(Welcome.xSize,Welcome.ySize));
		sShell.setLocation(Welcome.xPos,Welcome.yPos);
		
		table=new Table(sShell,SWT.MULTI);
		colonne1 = new TableColumn(table, SWT.LEFT);
		colonne1.setText("Name");
		colonne1.setWidth(100);
		colonne2 = new TableColumn(table, SWT.LEFT);
		colonne2.setText("Height");
		colonne2.setWidth(100);
		colonne3 = new TableColumn(table, SWT.LEFT);
		colonne3.setText("Place of census");
		colonne3.setWidth(100);
		colonne4 = new TableColumn(table, SWT.LEFT);
		colonne4.setText("session number");
		colonne4.setWidth(100);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true); 
		table.setBounds(10,100,420,200);
		
		Slider slider=new Slider(table,SWT.VERTICAL);
		slider.setBounds(400, 20, 20,180);
		
		
		Label label=new Label(sShell,0);
		label.setText("Search by: ");
		label.setBounds(5,50,50,15);
		
		combo = new Combo(sShell, SWT.BORDER);
		combo.setBounds(60,50,50,10);
		combo.add("Name");
		combo.add("Team leader");
		combo.add("Identifier");
		combo.add("Controler");
		combo.add("place of registration");
		combo.add("Height");
		combo.add("place of birth");
		combo.setSize(100,10);
		
		Button buttonInfo =new Button (sShell,SWT.None);
		buttonInfo.setText("more info");
		buttonInfo.setBounds(450, 100, 100, 50);
		
		Button buttonAddId=new Button (sShell,SWT.None);
		buttonAddId.setText("Add ID");
		buttonAddId.setBounds(450, 200, 100, 50);
		
		Button buttonDeleteId=new Button (sShell,SWT.None);
		buttonDeleteId.setText("Delete ID");
		buttonDeleteId.setBounds(450, 300, 100, 50);
		
		Text text = new Text(sShell, SWT.NONE); 
		text.setText("");
		text.setSize(100,15);
		text.setBounds(200,50,100,20);
		
		buttonSearch=new Button(sShell, SWT.NONE);
		buttonSearch.setText("Search");
	}
	
	private void setVisible(boolean b) {
		this.sShell.setVisible(b);
	}
	
	public void open() {
		final Display display = Display.getDefault();
		createShell();
		sShell.open();
		sShell.layout();
		while (!sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	
	public static void main(String[] args) {
		try {
			DBAdmin d=new DBAdmin();
			d.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
