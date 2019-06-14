import javax.swing.JTextPane;
import javax.swing.text.Position;
import javax.swing.text.StyledDocument;

/*
 * This class handles the paste Action Event
 */
public class ActionPaste extends Action {

	@Override
	public void doAction(JTextPane notePad) {
		StyledDocument doc = notePad.getStyledDocument(); // creates new style documents
		Position position = doc.getEndPosition(); // gets position that cursor is at
		notePad.paste(); // pastes copied content in clipboard to the notepad

	}

}
