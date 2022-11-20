package entidades;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entidades {//Superclase para los jugadores y monstruos que aparecen en el juego

    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2,up3, up4, up5, up6,
            left1, left2, left3, left4, left5,left6, left7, left8, left9, left10,
            right1, right2, right3, right4, right5,right6, right7, right8, right9, right10,
            idle;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOnBot = false;
    public boolean collisionOnRight = false;
    public boolean collisionOnLeft = false;
    public boolean collisionOnTop = false;
    public boolean collisionOn = false;


}
