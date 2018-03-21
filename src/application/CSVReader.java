package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	private String line = "\n";
	private String cvsSplitBy = ";";
	private String[] tempLine;
	private List<String[]> table = new ArrayList<String[]>();
	

	public List<String[]> readTable(File file) {
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((line = br.readLine()) != null) {
				
				// use comma as separator
				tempLine = line.split(cvsSplitBy);
				table.add(tempLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
			table = null;
		}
	    
	    return table;

	}

	
	
}