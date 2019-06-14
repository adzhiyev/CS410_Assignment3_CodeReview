import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

/*
 * This class handles the Replace Action Event
 */
public class ActionReplace extends Action {

	@Override
	public void doAction(JTextPane notePad) {
		// asks user to enter replacement text
		String replacementText = JOptionPane.showInputDialog("Enter replacement text");
		int startText, endText; // positions to hold index in the notePad
		try {
			startText = notePad.getSelectionStart(); // gets the start of the highlighted text
			endText = notePad.getSelectedText().length(); // gets the end of the highlighted text
			notePad.getDocument().remove(startText, endText); // removes the text
			SimpleAttributeSet attributes = new SimpleAttributeSet();
			// inserts the text the user entered in place of the removed text
			notePad.getDocument().insertString(startText, replacementText, attributes);
			// handles exception if the location of the start or end text is not valid
		} catch (BadLocationException badLocationException) {
			JOptionPane.showMessageDialog(null, "Bad Location Error" + badLocationException,
					"Bad Location for replacement text", JOptionPane.ERROR_MESSAGE);
		}
	}

}
