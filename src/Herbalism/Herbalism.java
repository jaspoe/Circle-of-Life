package Herbalism;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import application.Dice;


public class Herbalism {
	
	private List<Herb> herbs;
	private List<String> terrainTable = new ArrayList<String>();
	private List<Herb> commonHerbsTable = new ArrayList<Herb>();
	private Dice dice = new Dice();
	
	
	
	public List<Herb> getHerbs() {
		return herbs;
	}

	public void setHerbs(List<Herb> herbs) {
		this.herbs = herbs;
	}

	public List<String> getTerrainTable() {
		return terrainTable;
	}

	public void setTerrainTable(List<String> terrainTable) {
		this.terrainTable = terrainTable;
	}

	public Herbalism(){
		this.herbs = readHerbsFromCSV("./bin/Herbalism/Herbalism.csv");
		this.terrainTable();
		this.commonHerbsTable();
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
	
	private void commonHerbsTable() {

		for(int i = 0; i < herbs.size(); i++) {
			if(herbs.get(i).getTerrain().equals("Common")) {
				commonHerbsTable.add(herbs.get(i));
			}
		}
	}
	

	public List<Herb> rollIngredients(String terrain) {
		List<Herb> temp = new ArrayList<Herb>();
		List<Herb> rolledIngredients = new ArrayList<Herb>();
		for(int i = 0; i < herbs.size(); i++) {
			if(herbs.get(i).getTerrain().equals(terrain)) {
				temp.add(herbs.get(i));
			}
		}
		
		for(int i = 0; i < dice.roll(4); i++) {
			int ingredientNumber = dice.roll(6) + dice.roll(6) -2;
			if(ingredientNumber < 3 || ingredientNumber > 7) {
				if(dice.roll(20) > 14) {
					rolledIngredients.add(new Herb("", "Elemental Water", "", "", ""));
				}
			}else if(temp.get(ingredientNumber).getName().equals("Common Ingredient")) {
				rolledIngredients.add(commonHerbsTable.get(ingredientNumber));
			}else {
				rolledIngredients.add(temp.get(ingredientNumber));
			}
		}
		for(int i = 0; i < rolledIngredients.size(); i++) {
			System.out.println(rolledIngredients.get(i));
		}
		return rolledIngredients;
	}
}













