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

    public  int screenX;
    public final int screenY;
    int playerX;
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);


        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX=gp.tileSize*2;//Posiciones del jugador en el mapa
        worldY=gp.tileSize*35-50;
        //playerX = gp.tileSize*35-40;
        speed = 3;
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

        //Evaluar colisiones.
        collisionOn = false;
        collisionOnBot = false;
        collisionOnLeft=false;
        collisionOnRight=false;
        collisionOnTop=false;
        gp.cChecker.checkTile(this);

        if (keyH.upPressed == true){//Salto

            if(Condicion==true && !collisionOn){
                direction = "up";
                Condicion=false;

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int memory=0;
                        for(int i=0; i<=50; i++){
                            worldY -= speed;
                            /**if(collisionOn == true){
                                i=100;
                                //worldY += 5;
                                break;
                            }*/
                            mimir(10);
                        }
                        mimir(10);

                        for(int i=0; i<=50; i++){

                            if(collisionOnBot == true){
                                i=100;
                                break;
                            }
                            worldY += speed;
                            mimir(10);
                        }
                        direction = "idle";
                        Condicion=true;

                    }
                });
                t1.start();
            }
        }
        else if(keyH.leftPressed==true){//Movimiento a la izquierda
            //System.out.println("was here");
            posAnterior = true;
            if(collisionOnLeft == false){
                worldX -= speed;
                direction = "left";
            }

        }
        else if(keyH.rightPressed==true){//Movimiento a la derecha
            posAnterior = false;
            if(collisionOnRight == false){
                worldX += speed;
                direction = "right";
            }

        }
        else if(keyH.shootPressed){//Accion de disparo
            if(posAnterior){
                direction = "shootLeft";
            }else{
                direction = "shootRight";
            }

        } else if(keyH.downPressed){//Movimiento hacia abajo
            if(collisionOnBot == false){
                direction = "idle";
                //worldY += speed;
            }

        }else{
            if(collisionOnBot == false && direction!="up"){
                direction = "idle";
                worldY += speed;
            }

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
                image = idle;

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
        g2.drawImage(image, worldX,screenY, gp.tileSize,gp.tileSize, null);


    }
    public void mimir(int num){
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
