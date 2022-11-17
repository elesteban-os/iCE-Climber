package javaGui;

import entidades.Player;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //Ajustes de pantalla

    final int originalTileSize = 16;//16x16 tile
    final int scale = 3;
    public int tileSize = originalTileSize*scale;//48x48 tile



    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol;//768 pixels
    final int screenHeight = tileSize*maxScreenRow;//576 pixels

    //Frames Per Second (Imágenes por Segundo)
    int FPS = 60;


    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);
    //Thread jump;

    //Se establece la posición default del jugador
    int playerX = 384;
    int playerY = 500;
    int playerSpeed = 4;

    boolean Condicion = true;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);//Se instancia un hilo
        gameThread.run();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS;//0.016666 segundos
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer=0;
        long drawCount=0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime=currentTime;


            if(delta>=1){
                try {
                    update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
                delta--;
                drawCount++;
            }
            /*
            if(timer >= 1000000000){
                System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }*/

        }

    }


    public void update() throws InterruptedException {
        /**
        if (keyH.upPressed == true){

            if(Condicion==true){
                Condicion=false;

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<=50; i++){
                            playerY -= playerSpeed;
                            mimir();
                        }
                        mimir();
                        for(int i=0; i<=50; i++){
                            playerY += playerSpeed;
                            mimir();
                        }
                        Condicion=true;

                    }
                });
                t1.start();
            }

        }
        else if(keyH.downPressed==true){
            //Nada hace esto porque el jugador no va hacia abajo
            playerY += playerSpeed;
        }
        else if(keyH.leftPressed==true){
            //System.out.println("was here");
            playerX -= playerSpeed;
        }
        else if(keyH.rightPressed==true){
            playerX += playerSpeed;
        }*/
        player.update();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2= (Graphics2D)g;

        //g2.setColor(Color.white);

        //g2.fillRect(playerX,playerY,tileSize,tileSize);
        player.draw(g2);

        g2.dispose();//Permite desacerse de ciertas cosas de la interfaz para optimizar el rendimiento y liberar memoria.

    }
    /**
    public void mimir(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
