package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;


//this class handle all on screen UI 
public class UI {
	
    GamePanel gp;
    Font arial_80B;
    Font arial_40;
    BufferedImage keyImage;
    public boolean massageOn = false;
    public String massage = "";
    int massageCounter = 0;
    public boolean gameFinished = false;
    
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#00.00");
    
    public UI(GamePanel gp) {
    	this.gp = gp;
    	
    	arial_40 = new Font("Arial", Font.PLAIN, 40);
    	arial_80B = new Font("Arial", Font.BOLD, 50);
    	OBJ_Key key = new OBJ_Key();
    	keyImage = key.image;
    	
    	
    }
    public void showMassage(String text) {
    	
    	massage = text;
    	massageOn = true;
    }
    
    public void draw(Graphics2D g2) {
    	if(gameFinished == true) {
    		
    		g2.setFont(arial_40);
    		g2.setColor(Color.DARK_GRAY);
    		
    		 String text;
    		 int textLength;
    		 int x;
    		 int y;
    		
    		text = "u found the treasure";
    		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    		x = gp.screenWidth/2 - textLength/2;
    		y = gp.screenHeight/2 - (gp.tileSize*3);
    		g2.drawString(text, x, y);
    		
    		g2.setColor(Color.ORANGE);
    		text = " your Time is :"+ dFormat.format(playTime)+ "!";
    		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    		x = gp.screenWidth/2 - textLength/2;
    		y = gp.screenHeight/2 + (gp.tileSize*4);
    		g2.drawString(text, x, y);
    		
    		
    		g2.setFont(arial_80B);
    		g2.setColor(Color.YELLOW);
    		text = "CONGRATULATIONS";
    		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    		x = gp.screenWidth/2 - textLength/2;
    		y = gp.screenHeight/2 +(gp.tileSize*2);
    		g2.drawString(text, x, y);
    		
    		gp.gameThread = null;
    	}
    	else if(playTime<40)
    		{
    		 
    		
    	
    	g2.setFont(arial_40);
    	g2.setColor(Color.WHITE);
    	g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2,  gp.tileSize, gp.tileSize, null);
    	//g2.drawString("<"+ gp.player.hasKey,88,65);
    	g2.drawString("<"+ gp.cChecker.hasKey,88,65);
    	
    	//TIME
    	playTime +=(float)1/60;
    	g2.drawString("Time:"+dFormat.format(playTime), gp.tileSize*7, 65);
    	if(massageOn == true) {
    		
    		g2.setFont(g2.getFont().deriveFont(30F));
    		g2.drawString(massage, gp.tileSize/2, gp.tileSize*5);
    		
    		massageCounter++;
    		
    		if(massageCounter > 120) {
    			massageCounter = 0;
    			massageOn = false;
    		}
    	
    	}
    		}
    			
    		
    		
    	else if(playTime>=40) {
    	
    		 String text;
    		 int textLength;
    		 int x;
    		 int y;
    		 
    		 g2.setFont(arial_80B);
     		g2.setColor(Color.darkGray);
     		text = "Game over";
     		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
     		x = gp.screenWidth/2 - textLength/2;
     		y = gp.screenHeight/2 +(gp.tileSize*2);
     		
     		g2.drawString(text, x, y);
		
		gp.gameThread=null;
		gp.stopMusic();
		gp.playSE(5);
    	}
    
		
    		}
    		
    	
    }



