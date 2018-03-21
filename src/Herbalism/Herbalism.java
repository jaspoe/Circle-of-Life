package Herbalism;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Herbalism {
	
	List<Herb> herbs;
	List<String> terrainTable = new ArrayList<String>();
	
	public Herbalism(){
		this.herbs = readHerbsFromCSV("./bin/Herbalism/Herbalism.csv");
		this.terrainTable();		
	}
	
	private List<Herb> readHerbsFromCSV(String fileName) {

		List<Herb> herbs = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.ISO_8859_1)){
			String line = br. readLine();
			
			while (line != null) {
				String[] attributes = line.split(";");
				
				Herb herb = createdHerb(attributes);
				
				herbs.add(herb);
				
				line = br.readLine();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		return herbs;
	}

	private static Herb createdHerb(String[] metadata) {
		String terrain = metadata[1];
		String name = metadata[2];
		String rarity = metadata[3];
		String dc = metadata[4];
		String additionalRule = metadata[5];
		
		return new Herb(terrain, name, rarity, dc, additionalRule);
	}
	
	private void terrainTable() {
		String tempTerrain = herbs.get(0).getTerrain();
		terrainTable.add(tempTerrain);
		for(int i = 1; i < herbs.size(); i++) {
			if(!tempTerrain.equals(herbs.get(i).getTerrain())) {
				tempTerrain = herbs.get(i).getTerrain();
				terrainTable.add(tempTerrain);
			}
		}
	}
	
	
}
