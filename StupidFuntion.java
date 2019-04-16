//
//@author Chatrus
//@category TEST
//@keybinding
//@menupath
//@toolbar

import java.io.File;
import java.io.FileOutputStream;

import ghidra.app.script.GhidraScript;
import ghidra.framework.main.ConsoleTextPane;
import ghidra.program.model.listing.Function;
import ghidra.program.model.listing.FunctionIterator;
import ghidra.program.model.listing.FunctionManager;
import ghidra.program.model.listing.Program;

public class StupidFuntion extends GhidraScript {

	@Override
	protected void run() throws Exception {
		String tmp;
		String separation = "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-";
		byte[] sep = separation.getBytes();
		byte[] s;
		boolean userLikesDoge = askYesNo("Important question","Do you like doges?");
		popup("The answer it's irrelevant");
		File fileWrite = askFile("Where do we print?","Write");
		Program program = getCurrentProgram(); // Gets The current program
		FunctionManager functionManager = program.getFunctionManager(); // creates a function manager
		FunctionIterator functions = functionManager.getFunctions(true);// Gets all functions in the program
		try {
			FileOutputStream bella = new FileOutputStream(fileWrite);
			for (Function function : functions) { // iterates for all functions
				tmp = function.getEntryPoint().toString() + " " + function.getSignature().getPrototypeString()
						+ "\n" + function.getComment()+"\n"; // Doesn't write \n
				s = tmp.getBytes();
				bella.write(s);
				bella.write(sep);
			}
			bella.close();
			
		}catch(Exception e) {
			popup("ERROR");
		}
		
		
		
	}
}
