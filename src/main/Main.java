package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nodes.*;

import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.api.util.ExperienceTracker;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import utils.Utils;

@ScriptManifest(author = "", info = "", logo = "", name = "Rooftop Agility", version = 0)
public class Main extends Script {
	private final Font font = new Font(Font.DIALOG, Font.PLAIN, 14);
	
	private Utils utils;
	
	private final List<StaticNode> nodes = new ArrayList<>();
	private ExperienceTracker et;
	
	private GUI gui;

    @Override
    public void onStart() throws InterruptedException {
    	gui = new GUI();
    	
    	while(!gui.getStarted())
    		sleep(500);
    	
    	utils = new Utils(this, gui.getCity());
    	StaticNode.setup(utils);
    	
    	Collections.addAll(nodes, new ReturnHandler(), new CourseHandler(), new ReenterHandler());
    	
    	et = getExperienceTracker();
    	et.start(Skill.AGILITY);
    	
    }

    @Override
    public int onLoop() throws InterruptedException {
    	for(StaticNode node: nodes)
    		if(node.validate())
    			return node.execute();
    	return 0;
    }

    @Override
    public void onPaint(Graphics2D g) {
    	super.onPaint(g);
    	g.setColor(Color.GREEN);
    	g.setFont(font);
    	
    	int startY = 100; 
		g.drawString("Time ran: " + utils.getTimer().toString(), 5, startY);
		g.drawString("Status: " + utils.getStatus() + "...", 5, startY += 15);
		drawSkills(g, startY + 20, Skill.AGILITY);
    }
    
    public void drawSkills(Graphics2D g, int startY, Skill... skills) {
    	for(Skill s: skills) {
    		if(et.getGainedXP(s) > 0) {
    			g.drawString(s.toString() + " XP gained: " + et.getGainedXP(s), 5, startY);
    			g.drawString(s.toString() + " XP per hour: " + et.getGainedXPPerHour(s), 5, startY += 15);
    			g.drawString(s.toString() + " Level: " + getSkills().getStatic(s) + "(+" + et.getGainedLevels(s) + ")", 5, startY += 15);
    			startY += 20;
    		}
    	}
    }
}