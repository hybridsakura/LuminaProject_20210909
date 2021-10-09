package com.hybridsakura.project.app.minecraft.builder;

import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;
import com.hybridsakura.project.app.minecraft.helper.LuminaHelper;

import java.util.ArrayList;
import java.util.List;

public class LuminaBasicsBuilder {

    //  基础建筑物快速生成
    //  小型村庄

    //  基本构思

    LuminaHelper luminaHelper = new LuminaHelper();

    public List<String> lumina_InitBasicsBuild(MinecraftCoordinatePair coordinatePair, MinecraftCoordinate coordinate, FlexibleParams... params) {
        if(coordinatePair == null && coordinate != null) {
            return basicMiningBuild(coordinate);
        } else {
            return null;
        }
    }

    public List<String> basicMiningBuild(MinecraftCoordinate coordinate) {

        int radius = 4, depth = 60, height = 12;
        //  制造挖矿竖井
        //  选取展开中心点 半径为 4 建造高度加2 建造深度指定 60，但总高度不小于5
        MinecraftCoordinate outer_coordinateStart = new MinecraftCoordinate(coordinate.getX() - radius, coordinate.getZ() - radius);
        MinecraftCoordinate outer_coordinateEnd = new MinecraftCoordinate(coordinate.getX() + radius, coordinate.getZ() + radius);
        outer_coordinateEnd.setY(coordinate.getY() + height);

        MinecraftCoordinate inner_coordinateStart = new MinecraftCoordinate(coordinate.getX() - (radius - 1), coordinate.getZ() - (radius - 1));
        MinecraftCoordinate inner_coordinateEnd = new MinecraftCoordinate(coordinate.getX() + (radius - 1), coordinate.getZ() + (radius - 1));
        inner_coordinateEnd.setY(coordinate.getY() + (height - 1));

        if(coordinate.getY() - depth <= 5 ) {
            outer_coordinateStart.setY(5);
            inner_coordinateStart.setY(6);
        } else {
            outer_coordinateStart.setY(coordinate.getY() - depth);
            inner_coordinateStart.setY(coordinate.getY() - depth + 1);
        }
        List<String> orderList = new ArrayList<>();

        System.out.println("/fill" + luminaHelper.coordinateOrderCodeFormatter(new MinecraftCoordinatePair(outer_coordinateStart, outer_coordinateEnd)) + "iron_block");
        System.out.println("/fill" + luminaHelper.coordinateOrderCodeFormatter(new MinecraftCoordinatePair(inner_coordinateStart, inner_coordinateEnd)) + "air");

        orderList.add("/fill" + luminaHelper.coordinateOrderCodeFormatter(new MinecraftCoordinatePair(outer_coordinateStart, outer_coordinateEnd)) + "iron_block");
        orderList.add("/fill" + luminaHelper.coordinateOrderCodeFormatter(new MinecraftCoordinatePair(inner_coordinateStart, inner_coordinateEnd)) + "air");
        return orderList;
    }


}
