import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/*
 * Class that handles the Open Action
 */
public class ActionOpen extends Action {

	// Handles opening of the file
	public Integer doAction(SimpleNotePad simpleNotePad, JTextPane notePad, Integer count, JMenuItem recentFile,
			JMenuItem fileMenu, JMenuItem[] recent) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // sets home location for when file
																					// is opened
		int result = fileChooser.showOpenDialog(simpleNotePad);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String path = selectedFile.toString();
			openFile(path, notePad);

			// If there are more then 3 items then the recent array
			if (count >= 3) {
				recentFile.remove(recent[0]); // removes top recent item
				recent[0] = recent[1]; // shifts the next recent item to top
				recent[1] = recent[2]; // shifts the last recent item to middle
				recent[2] = new JMenuItem(path); // creates new menu item for new recent file

				recentFile.add(recent[2]); // adds to array
				fileMenu.add(recentFile); // updates file menu with changes
				// sets the action listeners for the recent menu items
				recent[0].addActionListener(simpleNotePad);
				recent[1].addActionListener(simpleNotePad);
				recent[2].addActionListener(simpleNotePad);
				// sets the action commands for the recent menu items
				recent[0].setActionCommand("recent" + 1);
				recent[1].setActionCommand("recent" + 2);
				recent[2].setActionCommand("recent" + 3);

				// when recent menu has less then three items in it
			} else {

				// creates new Jmenu item with the path value and adds to recent
				recent[count] = new JMenuItem(path);
				recentFile.add(recent[count]);
				fileMenu.add(recentFile); // updates file menu

				// sets action listen for recent item
				recent[count].addActionListener(simpleNotePad);
				recent[count].setActionCommand("recent" + (count + 1)); // sets action command based on count
				count++;

			}
		}
		return count; // returns the number in the recent file submenu

	}

	// This method handles opening a file
	public void openFile(String path, JTextPane notePad) {
		FileReader fr;
		try {
			File file = new File(path);
			fr = new FileReader(file);

			// loops through the file and puts contents in the notePad
			while (fr.read() != -1)
				notePad.read(fr, null);
			fr.close();
		} catch (Exception openError) {
			JOptionPane.showMessageDialog(null, "Open File Error" + openError, "Open File Error",
					JOptionPane.ERROR_MESSAGE);

		}
	}
}
