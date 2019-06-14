import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/*
 * This class  handles the Print Action event
 */
public class ActionPrint {

	// doAction event for when print menu is clicked
	public void doAction(SimpleNotePad spd, JTextPane notePad) {
		try {
			PrinterJob printerJob = PrinterJob.getPrinterJob(); // creates new printerJob
			printerJob.setJobName("Sample Command Pattern");
			printerJob.setCopies(1);
			// Creates new Printable
			printerJob.setPrintable(new Printable() {
				public int print(Graphics pg, PageFormat pf, int pageNum) {
					if (pageNum > 0)
						return Printable.NO_SUCH_PAGE;
					pg.drawString(notePad.getText(), 500, 500);
					spd.paint(pg);
					return Printable.PAGE_EXISTS;

				}
			});

			if (printerJob.printDialog() == false)
				return;
			printerJob.print();
			// printer exception
		} catch (PrinterException printerException) {
			JOptionPane.showMessageDialog(null, "Printer error" + printerException, "Printing error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
