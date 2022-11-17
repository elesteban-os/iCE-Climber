package entidades;

import javaGui.GamePanel;
import javaGui.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entidades{
    GamePanel gp;
    KeyHandler keyH;
    boolean Condicion = true;
    boolean posAnterior = true;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x=100;
        y=500;
        speed = 4;
        direction = "idle";

    }

    public void getPlayerImage(){
        try{
            //left1, left2, left3, right1, right2, right3
            idle = ImageIO.read(getClass().getResourceAsStream("/player/P1.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/P1L1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/P1L2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/P1L3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/P1L4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/P1L5.png"));

            left6 = ImageIO.read(getClass().getResourceAsStream("/player/P1LS1.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/player/P1LS2.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/player/P1LS3.png"));
            left9 = ImageIO.read(getClass().getResourceAsStream("/player/P1LS4.png"));
            left10 = ImageIO.read(getClass().getResourceAsStream("/player/P1LS5.png"));


            right1 = ImageIO.read(getClass().getResourceAsStream("/player/P1R1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/P1R2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/P1R3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/P1R4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/P1R5.png"));

            right6 = ImageIO.read(getClass().getResourceAsStream("/player/P1RS1.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/player/P1RS2.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/player/P1RS3.png"));
            right9 = ImageIO.read(getClass().getResourceAsStream("/player/P1RS4.png"));
            right10 = ImageIO.read(getClass().getResourceAsStream("/player/P1RS5.png"));


            up1 = ImageIO.read(getClass().getResourceAsStream("/player/P1U1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/P1U2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/P1U3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/P1U4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/P1U5.png"));




        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if (keyH.upPressed == true){

            if(Condicion==true){
                direction = "up";
                Condicion=false;
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<=50; i++){
                            y -= speed;
                            //repaint();
                            mimir(10);
                        }
                        mimir(1);
                        for(int i=0; i<=50; i++){
                            y += speed;
                            //repaint();
                            mimir(10);
                        }
                        direction = "idle";
                        Condicion=true;

                    }
                });
                t1.start();
            }
        }
        else if(keyH.leftPressed==true){
            //System.out.println("was here");
            posAnterior = true;
            x -= speed;
            direction = "left";
        }
        else if(keyH.rightPressed==true){
            posAnterior = false;
            direction = "right";
            x += speed;
        }
        else if(keyH.shootPressed){
            if(posAnterior){
                direction = "shootLeft";
            }else{
                direction = "shootRight";
            }

        }
        else{
            direction = "idle";
        }

        spriteCounter++;

        if(spriteCounter>10){//Funcionalidad para animación.
            if(spriteNum==1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 3;
            }
            else if(spriteNum == 3){
                spriteNum = 4;
            }
            else if(spriteNum == 4){
                spriteNum = 5;
            }
            else if(spriteNum == 5){
                spriteNum = 1;
            }
            spriteCounter=0;
        }
    }

    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch (direction){
            case "idle":
                if(spriteNum==1 || spriteNum==2 || spriteNum==3 || spriteNum==4 || spriteNum==5){
                image = idle;
                }
                break;
            case "shootLeft":
                if(spriteNum==1){
                    image = left6;
                }
                if(spriteNum==2){
                    image = left7;
                }
                if(spriteNum==3){
                    image = left8;
                }
                if(spriteNum==4){
                    image = left9;
                }
                if(spriteNum==5){
                    image = left10;
                }
                break;
            case "shootRight":
                if(spriteNum==1){
                    image = right6;
                }
                if(spriteNum==2){
                    image = right7;
                }
                if(spriteNum==3){
                    image = right8;
                }
                if(spriteNum==4){
                    image = right9;
                }
                if(spriteNum==5){
                    image = right10;
                }
                break;

            case "up":
                if(spriteNum==1){
                    image = up1;
                }
                if(spriteNum==2){
                    image = up2;
                }
                if(spriteNum==3){
                    image = up3;
                }
                if(spriteNum==4){
                    image = up4;
                }
                if(spriteNum==5){
                    image = up5;
                }
                break;

            case "left":
                if(spriteNum==1){
                    image = left1;
                }
                if(spriteNum==2){
                    image = left2;
                }
                if(spriteNum==3){
                    image = left3;
                }
                if(spriteNum==4){
                    image = left4;
                }
                if(spriteNum==5){
                    image = left5;
                }
                break;

            case "right":
                if(spriteNum==1){
                    image = right1;
                }
                if(spriteNum==2){
                    image = right2;
                }
                if(spriteNum==3){
                    image = right3;
                }
                if(spriteNum==4){
                    image = right4;
                }
                if(spriteNum==5){
                    image = right5;
                }
                break;

        }
        g2.drawImage(image, x,y, 65,65, null);


    }
    public void mimir(int num){
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
