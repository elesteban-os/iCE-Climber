package tile;

import javaGui.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager{
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp=gp;

        tile = new Tile[7];

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/map/map.txt");

    }

    public void getTileImage(){
        try{

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/BG.png"));
            tile[0].breakable=true;
            tile[0].collision = false;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/IceBreak.png"));
            tile[1].breakable=true;
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/IceUnbreak.png"));
            tile[2].breakable=false;
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall.png"));
            tile[3].breakable=false;
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wood.png"));
            tile[4].breakable=true;
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Brick.png"));
            tile[5].breakable=true;
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/IceBreak 2.png"));
            tile[6].breakable=true;
            tile[6].collision = true;

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String path){//Carga la inforamción del mapa (archivo map.txt) en la variable numérica maptileNum
        try{
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int columna = 0;
            int fila=0;

            while(columna<gp.maxWorldCol && fila<gp.maxWorldRow){//Se recorren los ciclo para asignar al mapTileNum los números que contenía el archivo

                String line = br.readLine();//Se asigna a la variable line una nueva línea del archivo de texto cada nuevo ciclo.

                while(columna <gp.maxWorldCol){

                    String numbers[]=line.split(" ");//Se eliminan los espacios del archivo y se asginan a un array de Strings

                    int num = Integer.parseInt(numbers[columna]);//Se transforma cada elemento del array en un número
                    mapTileNum[columna][fila]=num;//Se asigna el valor del número al mapa.
                    columna++;
                }
                if(columna == gp.maxWorldCol){
                    columna =0;
                    fila++;
                }
            }

            br.close();//Se cierra el archivo.

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){


        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow<gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            g2.drawImage(tile[tileNum].image,worldX,screenY,gp.tileSize, gp.tileSize, null);
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }

        }

    }


}
