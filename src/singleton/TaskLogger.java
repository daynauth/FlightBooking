package singleton;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class TaskLogger {
	private static TaskLogger instance = new TaskLogger();
	private static final ArrayList<String> log = new ArrayList<>();
	private static Date date = new Date();
	
	private TaskLogger() {
		
	}
	
	public static TaskLogger getInstance() {
		return instance;
	}
	
	public static void add(String message) {
		log.add(date + " " + message);
	}
	
	public static ArrayList<String> getOutput(){
		return log;
	}
	
	public static void writeToFile(String file) {
		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))){
			log.forEach(e -> {
				try {
					writer.write(e);
					writer.newLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
