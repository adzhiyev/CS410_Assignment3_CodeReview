import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/*
 * This class handles the Save Action Event
 */
public class ActionSave extends Action {

	@Override
	public void doAction(JTextPane notePad) {
		File fileToWrite = null; // file to be saved
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			fileToWrite = fileChooser.getSelectedFile(); // gets the file to save

		try {
			PrintWriter outputFile = new PrintWriter(new FileWriter(fileToWrite));
			outputFile.println(notePad.getText());
			JOptionPane.showMessageDialog(null, "File is saved successfully..."); // displays dialog for when file saved
			outputFile.close(); // closes outputFile
			// if there is an error trying to save
		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Save Error" + ioException, "Error trying to save",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
