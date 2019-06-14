import javax.swing.JTextPane;

/*
 * Class that handles when new is clicked
 */
public class ActionNew extends Action {

	@Override
	public void doAction(JTextPane notePad) {
		notePad.setText(""); // Sets notepad to empty

	}

}
