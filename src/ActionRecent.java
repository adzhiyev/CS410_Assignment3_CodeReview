import javax.swing.JMenuItem;
import javax.swing.JTextPane;

/*
 * This class handles the Recent Action Event 
 */
public class ActionRecent extends Action {
	private int index; // index of recent array

	// Constructor to set the index of the recent array
	public ActionRecent(int index) {
		this.index = index;
	}

	public void doAction(JTextPane notePad, JMenuItem[] recent) {
		String path = recent[index].getText(); // creates the path based on the recent array's index's text value
		// creates an ActionOpen object to open the file when clicked
		ActionOpen openFile = new ActionOpen();
		openFile.openFile(path, notePad); // opens the file
	}

}
