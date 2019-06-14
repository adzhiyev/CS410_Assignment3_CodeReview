import javax.swing.JTextPane;
/*
 * Class to copy contents of notebook
 */
public class ActionCopy extends Action {

	@Override
	public void doAction(JTextPane notePad) {
		notePad.copy(); //copies highlighted contents of notebook
	}

}
