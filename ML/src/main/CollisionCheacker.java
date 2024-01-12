package main;

import entity.Entity;

public class CollisionCheacker {
	String objName ="ma";
	public int hasKey=0;
	
	GamePanel gp ;
	
	public CollisionCheacker( GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		pickUpObjecttile();
		
		if(hasKey==0) {
			gp.tileM.tile[8].collisiontile = false;
			gp.tileM.tile[8].collision = true;
		}else if(hasKey>0) {
			gp.tileM.tile[8].collisiontile = true;
			gp.tileM.tile[8].collision = false;
		}
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY +  entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;//to see where it will be before it moves
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;}
				else if(gp.tileM.tile[tileNum1].collisiontile == true) {
					gp.tileM.mapTileNum[entityLeftCol][entityTopRow]=5;
				 objName = gp.tileM.tile[tileNum1].name;
				
				}else if(gp.tileM.tile[tileNum2].collisiontile == true ) {
					gp.tileM.mapTileNum[entityRightCol][entityTopRow]=5;
					 objName = gp.tileM.tile[tileNum2].name;
				 }
			
			
			
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;}
			else if(gp.tileM.tile[tileNum1].collisiontile == true) {
				gp.tileM.mapTileNum[entityLeftCol][entityBottomRow]=5;
			 objName = gp.tileM.tile[tileNum1].name;
			
			}else if(gp.tileM.tile[tileNum2].collisiontile == true ) {
				gp.tileM.mapTileNum[entityRightCol][entityBottomRow]=5;
				 objName = gp.tileM.tile[tileNum2].name;
			 }
		
		    break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
		}else if(gp.tileM.tile[tileNum1].collisiontile == true) {
			gp.tileM.mapTileNum[entityLeftCol][entityTopRow]=5;
		 objName = gp.tileM.tile[tileNum1].name;
		
		}else if(gp.tileM.tile[tileNum2].collisiontile == true ) {
			gp.tileM.mapTileNum[entityLeftCol][entityBottomRow]=5;
			 objName = gp.tileM.tile[tileNum2].name;
		 }
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
		}else if(gp.tileM.tile[tileNum1].collisiontile == true) {
			gp.tileM.mapTileNum[entityRightCol][entityTopRow]=5;
		 objName = gp.tileM.tile[tileNum1].name;
		
		}else if(gp.tileM.tile[tileNum2].collisiontile == true ) {
			 gp.tileM.mapTileNum[entityRightCol][entityBottomRow]=5;
			 objName = gp.tileM.tile[tileNum2].name;
		 }
			 
			 
			break;
		
		
		}
		
		
		
		
		}
			
		
		
	

	public int chickObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for( int i = 0 ; i < gp.obj.length ; i++) {
			
		 if (gp.obj[i] != null)	{
			 
			entity.solidArea.x = entity.worldX + entity.solidArea.x;
			entity.solidArea.y = entity.worldY + entity.solidArea.y;
			
			gp.obj[i].solidArea.x = gp.obj[i].worldX;// + gp.obj[i].solidArea.x;// WE SET 0 
			gp.obj[i].solidArea.y = gp.obj[i].worldY;// + gp.obj[i].solidArea.y;
			
			switch(entity.direction) {
			case "up":
				entity.solidArea.x -= entity.speed;
				if(entity.solidArea.intersects(gp.obj[i].solidArea)){
					
					if(gp.obj[i].collision == true){
						entity.collisionOn = true ;	
					}
					if (player == true) {
						index = i;
					}
				}
				break;
			case "down":
				entity.solidArea.x += entity.speed;
				if(entity.solidArea.intersects(gp.obj[i].solidArea)) {	
					
				if(gp.obj[i].collision == true){
					entity.collisionOn = true ;	
				}
				if (player == true) {
					index = i;
				}
					
					
				}
				break;
			case "left":
				entity.solidArea.y -= entity.speed;
				if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
					if(gp.obj[i].collision == true){
					entity.collisionOn = true ;	
				}
				if (player == true) {
					index = i;
				}
					
					
				}
				break;
			case "right":
				entity.solidArea.y += entity.speed;
				if(entity.solidArea.intersects(gp.obj[i].solidArea))//rectangle method
				{	
					if(gp.obj[i].collision == true){
					entity.collisionOn = true ;	
				}
				if (player == true) {
					index = i;
				}
					
					
				}
				break;
			}
		 	entity.solidArea.x = entity.solidAreaDefaultX;
		 	entity.solidArea.y = entity.solidAreaDefaultY;
		 	gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
			gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
		 }
		 
		}
		
		return index;
		
		
	}
	public void pickUpObjecttile() {
		
        if (objName != "ma")
        {
		
        	
		switch(objName) {
		case "key":
			gp.playSE(1);
		hasKey++;
		
		
		break;
		case "Door":
			
			if(hasKey > 0) {
				gp.playSE(2);
				
				hasKey--;
			}else 
			gp.ui.showMassage("U need a key!");
		break;
		case "boots":
			gp.playSE(3);
			gp.player.speed +=1;
			
			gp.ui.showMassage("speed up!");
			break;
		case "chest":
			gp.ui.gameFinished = true;
			gp.stopMusic();
			gp.playSE(4);
			break;
		}
			
		objName ="ma";	}
		
	}
}
