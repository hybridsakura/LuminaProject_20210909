package com.hybridsakura.project.app.minecraft.entity;

import java.io.Serializable;

public class MinecraftCoordinatePair implements Serializable {

    private static final long serialVersionUID = -3363767091242766028L;

    private MinecraftCoordinate minecraftCoordinate1;
    private MinecraftCoordinate minecraftCoordinate2;

    public MinecraftCoordinate getMinecraftCoordinate1() {
        return minecraftCoordinate1;
    }

    public void setMinecraftCoordinate1(MinecraftCoordinate minecraftCoordinate1) {
        this.minecraftCoordinate1 = minecraftCoordinate1;
    }

    public MinecraftCoordinate getMinecraftCoordinate2() {
        return minecraftCoordinate2;
    }

    public void setMinecraftCoordinate2(MinecraftCoordinate minecraftCoordinate2) {
        this.minecraftCoordinate2 = minecraftCoordinate2;
    }

    public MinecraftCoordinatePair() {
    }

    public MinecraftCoordinatePair(MinecraftCoordinate minecraftCoordinate1, MinecraftCoordinate minecraftCoordinate2) {
        this.minecraftCoordinate1 = minecraftCoordinate1;
        this.minecraftCoordinate2 = minecraftCoordinate2;
    }
}
