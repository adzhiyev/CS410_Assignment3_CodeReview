Daniyal Adzhiyev
CS410
Assignemt 3

1.	Code Smells


1.	First code smell is that the global variables names are to hard to understand and differentiate between the different JMenuItems/JMenu/ and JMenuBar.  The variable names should be renamed. Code lines 24 to 33.

2.	The GUI is intertwined with the business logic, the gui should be separated from the business logic by creating classes to handle the various different actions.  At the very least the business logic should not all be in one method for the Action Events it should be split up into different methods. Code lines 70 to 119.

3.	The Constructor should be split up into various methods to add the menu items, set the action listener and set the JFrame settings.  Additionally the global variables should not be instantiated at the global level but when the constructor is called. Code lines 24 to 64.

4.	Overall there are no comments in the code, There should be comments to let anyone who is reading the code an idea of what is going on. Code lines 1 to 120.

5.	The action command for undo is not implemented and should be removed. (code line 116)

6.	The catch command for the save action is empty, it should create a dialog box, code line 84 -85

7.	The paste action event doesn’t need to print position offset to console, code line 114.

8.	Separators should be added to the edit menu to be consist with the file menu

9.	Main method shouldn’t be apart of the GUI create a separate class to launch the application. Code lines 66 to 68.




2.	

Line 24 through 33:

o	I changed the variable names from mb to menuBar, em to editMenu, d to NotePad, nf to newFile, sf to safeFile, pf to printFile, 
	u to Undor, c to copy, and p to paste, because it is easier to read.

o	Line 84: I changed the variable ex to ioException because it is easier to read.

o	Line 104: I changed the variable pe to printerException to make it more clear to readers.

o	Removed undo menu and action command.

o	I removed line 114 code because it is unnecessary to print offset to console.

o	I created a methods to instantiate Menu Objects, configure JFrame settings, and set Action Listeners in the SimpleNotePad class.

o	I created new classes Action, ActionCopy, ActionNew, ActionOpen, ActionPaste, ActionPrint, ActionRecent, ActionReplace, 
	and ActionSave to separate the business logic from the GUI.

o	I created a new class Application to separate the launch of the program from the GUI.

•	I removed the instantiation of objects at the global level to when the constructor is called.

•	Line 127 through 131: I added separators to the edit menu to make it consist with the file menu
