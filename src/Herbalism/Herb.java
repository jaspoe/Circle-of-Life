package Herbalism;

public class Herb {

	private int id = 0;
	private String dc;
	private String terrain;
	private String name;
	private String rarity;
	private String additionalRule;
	private String description;
	private String details;
		
	
	public Herb(String t, String n, String r, String d, String a) {
		this.setTerrain(t);
		this.setName(n);
		this.setRarity(r);
		this.setDc(d);
		this.setAdditionalRule(a);
	}

	public void herbPrint() {
		System.out.println(
				"HerbID: " + this.id + 
				"\n Herb Name: " + this.name +
				"\n Herb Terrain: " + this.terrain);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	public String getAdditionalRule() {
		return additionalRule;
	}
	public void setAdditionalRule(String additionalRule) {
		this.additionalRule = additionalRule;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}	

	@Override
	public String toString() {
		return terrain + ", " + name + ", " + rarity+ ", " + dc + ", " + additionalRule;
	}

}
