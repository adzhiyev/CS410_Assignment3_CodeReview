import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class SimpleNotePad extends JFrame implements ActionListener {
	// global variables
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu recentFile;
	private JTextPane notePad = new JTextPane();
	private JMenuItem newFile;
	private JMenuItem saveFile;
	private JMenuItem printFile;
	private JMenuItem openFile;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem replace;
	private JMenuItem[] recent;
	private Integer count;

	// constructor
	public SimpleNotePad() {
		instantiateMenuObjects(); // instantiates the menu objects
		addMenuItems(); // adds menu items to menubar
		configureMenuBars();
		configureActionListeners();
		configureJFrameSettings();
	}

	// instantiates the menu objects
	private void instantiateMenuObjects() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		recentFile = new JMenu("Recent");
		notePad = new JTextPane();
		newFile = new JMenuItem("New File");
		saveFile = new JMenuItem("Save File");
		printFile = new JMenuItem("Print File");
		openFile = new JMenuItem("Open File");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		replace = new JMenuItem("Replace");
		recent = new JMenuItem[3];

		count = 0;
	}

	// configures the JFrame settings
	private void configureJFrameSettings() {
		setTitle("A Simple Notepad Tool");
		add(new JScrollPane(notePad));
		setPreferredSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();

	}

	// adds actions listeners
	private void configureActionListeners() {
		setActionListeners(newFile, "new");
		setActionListeners(saveFile, "save");
		setActionListeners(printFile, "print");
		setActionListeners(openFile, "open");
		setActionListeners(copy, "copy");
		setActionListeners(paste, "paste");
		setActionListeners(replace, "replace");

	}

	// Sets the action listener and commands based on item and command text
	private void setActionListeners(JMenuItem item, String command) {

		item.addActionListener(this);
		item.setActionCommand(command);
	}

	// adds menu items
	private void addMenuItems() {

		addFileMenuItems();
		addEditMenuItems();

	}

	// adds file menu items
	private void addFileMenuItems() {
		fileMenu.add(newFile);
		fileMenu.addSeparator();
		fileMenu.add(saveFile);
		fileMenu.addSeparator();
		fileMenu.add(printFile);
		fileMenu.addSeparator();
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(recentFile);

	}

	// adds edit menu items
	private void addEditMenuItems() {

		editMenu.add(copy);
		editMenu.addSeparator();
		editMenu.add(paste);
		editMenu.addSeparator();
		editMenu.add(replace);

	}

	// configure the menubars by adding menus
	private void configureMenuBars() {
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);
	}

	@Override
	// Handles the Action Events based on action event keyword
	public void actionPerformed(ActionEvent e) {

		// Checks what the action event command is and creates a specific Action Object
		// to execute the action
		if (e.getActionCommand().equals("new")) {
			ActionNew actNew = new ActionNew();
			actNew.doAction(notePad);
		} else if (e.getActionCommand().equals("save")) {
			ActionSave actSave = new ActionSave();
			actSave.doAction(notePad);
		} else if (e.getActionCommand().equals("open")) {
			ActionOpen actOpen = new ActionOpen();
			count = actOpen.doAction(this, notePad, count, recentFile, fileMenu, recent);
		} else if (e.getActionCommand().equals("replace")) {
			ActionReplace actReplace = new ActionReplace();
			actReplace.doAction(notePad);
		} else if (e.getActionCommand().equals("print")) {
			ActionPrint actPrint = new ActionPrint();
			actPrint.doAction(this, notePad);
		} else if (e.getActionCommand().equals("copy")) {
			ActionCopy actCopy = new ActionCopy();
			actCopy.doAction(notePad);
		} else if (e.getActionCommand().equals("paste")) {
			ActionPaste actPaste = new ActionPaste();
			actPaste.doAction(notePad);
		} else if (e.getActionCommand().equals("recent1")) {
			ActionRecent act1Recent = new ActionRecent(0);
			act1Recent.doAction(notePad, recent);
		} else if (e.getActionCommand().equals("recent2")) {
			ActionRecent act2Recent = new ActionRecent(1);
			act2Recent.doAction(notePad, recent);
		} else if (e.getActionCommand().equals("recent3")) {
			ActionRecent act3Recent = new ActionRecent(2);
			act3Recent.doAction(notePad, recent);
		}
	}

}
