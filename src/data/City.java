package data;

import java.util.ArrayList;
import java.util.List;

import org.osbot.rs07.api.map.Area;

public enum City {
	GNOME_AGILITY("Gnome Agility Course", 1, new Area(new int[][] {
			{2473, 3441}, {2469, 3437}, {2469, 3418}, {2473, 3414},
			{2487, 3414}, {2491, 3418}, {2491, 3437}, {2487, 3441}}), null),
    DRAYNOR("Draynor", 10, new Area(3103, 3281, 3105, 3277), "Rough wall"),
    ALKHARID("Al-Kharid", 20, new Area(3270, 3197, 3277, 3195), "Rough wall"),
    VARROCK("Varrock", 30, new Area(3221, 3419, 3224, 3411), "Rough wall"),
    CANIFIS("Canifis", 40, new Area(3502, 3490, 3511, 3486), "Tall tree"), 
    FALADOR("Falador", 50, new Area(3038, 3341, 3032, 3338), "Rough wall"),
    SEERS("Seers", 60, new Area(2728, 3489, 2731, 3487), "Wall"),
    POLLNIVEACH("Pollniveach", 70, new Area(3348, 2962, 3355, 2961), "Basket"),
    RELLEKKA("Rellekka", 80, new Area(2620, 3679, 2629, 3677), "Rough wall"),
    ARDOUGNE("Ardougne (Untested)", 90, new Area(2672, 3298, 2677, 3296), "Wooden Beams");

    private final Area startArea;
    
    private List<Obstacle> obstacles = null;
    
    private final String name, startObstacleName;
    private final int level;

    private City(String name, int level, Area startArea, String startObstacleName) {
    	this.startArea = startArea;
    	this.name = name;
    	this.level = level;
    	this.startObstacleName = startObstacleName;
    }
    
    public String getStartObstacleName() {
    	return startObstacleName;
    }
    
    @Override
    public String toString() {
    	return name;
    }
    
    public int getLevel() {
    	return level;
    }
    
    public Area getStartArea() {
    	return startArea;
    }
    
    public List<Obstacle> getObstacles() {
    	if(obstacles == null) {
    		obstacles = new ArrayList<>();
    		for(Obstacle ao: Obstacle.values()) {
    			if(ao.getCity() == this)
    				obstacles.add(ao);
    		}
    	}
    	return obstacles;
    }
}
