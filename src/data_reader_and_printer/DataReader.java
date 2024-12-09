package data_reader_and_printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class DataReader {
	
	private String dataPath;
	
	public ArrayList<String[]> runDataRead() {
		
    	
		try {
			URL url = DataReader.class.getProtectionDomain().getCodeSource().getLocation();
			String decodedPath = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8.name());  	
	    	File parentFile = new File(decodedPath);
	    	setDataPath(parentFile.getPath() + "\\data\\data.csv");
		} catch(Exception e) {
			System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
		}
    	
    	ArrayList<String[]> lines = new ArrayList<>();
    	
    	
    	
    	try {
	    	File dataFile = new File(getDataPath()); 		    	
	    	Scanner scanner = new Scanner(dataFile);
	    	
	    	while (scanner.hasNextLine()) {
	    		String line = scanner.nextLine();
	    		String[] values = line.split(",");
	    		lines.add(values);
	    	}
	    	
	    	scanner.close();
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}    	
    	
    	return lines;
	}

	public String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}
	
}
