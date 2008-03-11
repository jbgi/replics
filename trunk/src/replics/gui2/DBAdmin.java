package replics.gui2;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import replics.gui.Welcome;

public class DBAdmin {

	static Shell sShell;
	static Table table;
	static Combo combo;
	static Button buttonSearch;
	
	public DBAdmin(){
		createShell();
	}
	
	public static void createShell(){
		sShell=new Shell();
		sShell.setSize(new org.eclipse.swt.graphics.Point(Welcome.xSize,Welcome.ySize));
		sShell.setLocation(Welcome.xPos,Welcome.yPos);
		table=new Table(sShell,SWT.CHECK);
		
		combo = new Combo(sShell, SWT.BORDER);
		combo.add("Name");
		combo.add("Team leader");
		combo.add("Identifier");
		combo.add("Controler");
		combo.add("place of registration");
		combo.add("Height");
		combo.add("place of birth");
		combo.setSize(100,40);
		
		Text text = new Text(sShell, SWT.NONE); 
		text.setText("");
		text.setSize(100,25);
		
		buttonSearch=new Button(sShell, SWT.NONE);
		buttonSearch.setText("Search");
		
	}
	
	public static void main(String[] args) {
		System.out.println("toto");
		System.out.println(Welcome.xSize);
		DBAdmin dd=new DBAdmin();
	}
}
