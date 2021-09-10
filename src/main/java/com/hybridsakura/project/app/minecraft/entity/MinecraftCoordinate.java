package com.hybridsakura.project.app.minecraft.entity;

import java.io.Serializable;

public class MinecraftCoordinate implements Serializable {

    private static final long serialVersionUID = -6632722297595660193L;

    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public MinecraftCoordinate() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public MinecraftCoordinate(int y) {
        this.y = y;
        
    }

    public MinecraftCoordinate(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public MinecraftCoordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
