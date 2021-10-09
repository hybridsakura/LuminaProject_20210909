package com.hybridsakura.project.app.minecraft.builder;

import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;
import com.hybridsakura.project.app.minecraft.helper.LuminaHelper;
import com.hybridsakura.project.app.minecraft.helper.LuminaUtil;

import java.util.ArrayList;
import java.util.List;

public class LuminaBeaconBuilder {

    //  Lumina 信标建造者

    LuminaHelper luminaHelper = new LuminaHelper();
    LuminaUtil luminaUtil = new LuminaUtil();

    //  输入一个坐标，按照坐标展开。展开数为
    public List<String> lumina_InitBeaconBuild(MinecraftCoordinatePair coordinatePair, MinecraftCoordinate coordinate, FlexibleParams... params) {
        if(coordinatePair == null && coordinate!=null) {
            return beaconDeploy(coordinate);
        } else {
            return null;
        }
    }

    private List<String> beaconDeploy(MinecraftCoordinate coordinate) {

        String blockQualifyName = "diamond_block";
        List<String> listString = new ArrayList<>();
        MinecraftCoordinatePair tempCoordinatePair;
        MinecraftCoordinatePair tempPair = new MinecraftCoordinatePair();
        coordinate.setY(coordinate.getY() - 1);
        tempPair.setMinecraftCoordinate2(coordinate);
        luminaUtil.buildOrderGenerator(tempPair, blockQualifyName);
        int stageLevel = 2;
//        MinecraftCoordinate coordinate1;
//        MinecraftCoordinate coordinate2;

        for(int radius = 1; radius < 6; radius ++) {
            tempCoordinatePair = luminaHelper.generatePanelByRadiusAndDirection(coordinate, radius, "AXIS-HOLD-Y");
            tempCoordinatePair.getMinecraftCoordinate1().setY(tempCoordinatePair.getMinecraftCoordinate1().getY() - radius);
            tempCoordinatePair.getMinecraftCoordinate2().setY(tempCoordinatePair.getMinecraftCoordinate2().getY() - radius);
            listString.add(luminaUtil.buildOrderGenerator(tempCoordinatePair, blockQualifyName).get(0));
            stageLevel += 1;
        }
        return listString;
    }


}
