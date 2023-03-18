package yar.wargame.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import yar.wargame.hu.Main;

public class ReportLog {
	
	private static Main plugin = Main.getPlugin(Main.class);
	private static File log = new File(plugin.getDataFolder(), "report.log");
	private static ArrayList<String> logtext = new ArrayList<>();
	private static StackTraceElement[] strackTraceElement;
	
	public static File getLog() {
		return log;
	}
	public static void setLog(File log) {
		ReportLog.log = log;
	}
	
	public static void setup() {
		try {
			log.createNewFile();
			System.out.println("Report log succesfully created!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
	public static void write(String text) {
		try {
			PrintWriter logoutput = new PrintWriter(log);
			logtext.add(text);
			for (String logtxt : logtext) {
				logoutput.println(logtxt);
			}
			logoutput.close();	
			System.out.println("[WarGame] Oops... a new error, please check the 'plugins/WarGame/report.log'!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
	}
	public static StackTraceElement[] getStrackTraceElement() {
		return strackTraceElement;
	}
	public static void setStrackTraceElement(StackTraceElement[] strackTraceElement) {
		ReportLog.strackTraceElement = strackTraceElement;
	}
}
