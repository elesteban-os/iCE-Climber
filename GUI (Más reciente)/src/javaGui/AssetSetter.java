package javaGui;

import object.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        int index = 0;

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelUno();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY=32*gp.tileSize;
            index++;
        }

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelDos();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY=29*gp.tileSize;
            index++;
        }

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelTres();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY=26*gp.tileSize;
            index++;
        }

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelCuatro();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY=23*gp.tileSize;
            index++;
        }

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelCinco();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY=20*gp.tileSize;
            index++;
        }

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelSeis();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY=17*gp.tileSize;
            index++;
        }

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelSiete();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY=14*gp.tileSize;
            index++;
        }

        for(int i = 1; i<15 ; i++){
            gp.obj[index] = new NivelOcho();
            gp.obj[index].worldX = i*gp.tileSize;
            gp.obj[index].worldY = 11*gp.tileSize;
            index++;
        }

        gp.obj[index] = new Verdura();
        gp.obj[index].worldX = 3*gp.tileSize;
        gp.obj[index].worldY = 7*gp.tileSize;
        index++;

        gp.obj[index] = new VerduraDos();
        gp.obj[index].worldX = 12*gp.tileSize;
        gp.obj[index].worldY = 7*gp.tileSize;
        index++;

        gp.obj[index] = new VerduraTres();
        gp.obj[index].worldX = 6*gp.tileSize;
        gp.obj[index].worldY = 5*gp.tileSize;
        index++;

        gp.obj[index] = new VerduraCuatro();
        gp.obj[index].worldX = 9*gp.tileSize;
        gp.obj[index].worldY = 5*gp.tileSize;
        index++;



    }
}
