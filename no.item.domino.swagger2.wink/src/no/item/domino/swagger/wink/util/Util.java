package no.item.domino.swagger.wink.util;


public class Util {

	private static final boolean ERROR = true;
	private static final boolean WARNING = true;
	private static final boolean INFO = true;
	private static final boolean DEBUG = true;
		
	public static void writeToLog(String msg) {
		System.out.println(msg);
		//log(msg);
	}
		
	public static void debug(String string, String className, String methodName) {
		if (DEBUG) {
			writeToLog("DEBUG : Class : " + className + ". Method : " + methodName + ". " + string + ";");	
		}
	}
	public static void debug(String string, String className) {
		if (DEBUG) {
			writeToLog("DEBUG : Class : " + className + ". " + string + ";");	
		}
	}
	public static void debug(String string) {
		if (DEBUG) {
			writeToLog("DEBUG : " + string + ";");	
		}
	}
	
	public static void info(String string, String className, String methodName) {
		if (INFO) {
			writeToLog(" INFO : Class : " + className + ". Method : " + methodName + ". " + string + ";");	
		}
	}
	
	public static void info(String string, String className) {
		if (INFO) {
			writeToLog(" INFO : Class : " + className + ". " + string + ";");	
		}
	}
	
	public static void info(String string) {
		if (INFO) {
			writeToLog(" INFO : " + string);	
		}
	}
	
	public static void warn(String string, String className, String methodName) {
		if (WARNING) {
			writeToLog("WARNING : Class : " + className + ". Method : " + methodName + ". " + string + ";");	
		}
	}
	
	public static void warn(String string, String className) {
		if (WARNING) {
			writeToLog("WARNING : Class : " + className + ". " + string + ";");	
		}
	}
	
	public static void warn(String string) {
		if (WARNING) {
			writeToLog("WARNING : " + string);
		}
	}
		
	public static void error(String string, String className, String methodName) {
		if (ERROR) {
			writeToLog("ERROR : Class : " + className + ". Method : " + methodName + ". " + string + ";");	
		}
	}
	
	public static void error(String string, String className) {
		if (ERROR) {
			writeToLog("ERROR : Class : " + className + ". " + string + ";");	
		}
	}
	
	public static void error(String string) {
		if (ERROR) {
			writeToLog("ERROR : " + string + ";" );
		}
	}
}
