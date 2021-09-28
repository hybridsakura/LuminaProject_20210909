package com.hybridsakura.project.app.minecraft.function;

import com.hybridsakura.project.app.minecraft.builder.*;
import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;

import java.util.List;

public class LuminaEngine {

    public List<String> LuminaMasterSequence(MinecraftCoordinatePair coordinatePair, MinecraftCoordinate coordinate, FlexibleParams... params) {
        String sequenceName;
        System.out.println("[AI-LM][] Lumina主序列 启动");
        if(params[0] != null && !"".equals(params[0].getSequenceName())) {
            sequenceName = params[0].getSequenceName();
            System.out.println("[AI-LM][] LuminaSystem 序列="+sequenceName+" 准备执行...");
            switch (sequenceName) {
                case "[lumina-basics]":
                    LuminaBasicsBuilder basicsBuilder = new LuminaBasicsBuilder();
                    return basicsBuilder.lumina_InitBasicsBuild(coordinatePair, coordinate ,params[0]);
                case "[lumina-beacon]":
                    LuminaBeaconBuilder beaconBuilder = new LuminaBeaconBuilder();
                    return beaconBuilder.lumina_InitBeaconBuild(coordinatePair, coordinate ,params[0]);
                case "[lumina-bridge]":
                    LuminaBridgeBuilder bridgeBuilder = new LuminaBridgeBuilder();
                    return bridgeBuilder.lumina_InitBridgeBuild(coordinatePair, coordinate ,params[0]);
                case "[lumina-tunnel]":
                    LuminaTunnelBuilder tunnelBuilder = new LuminaTunnelBuilder();
                    return tunnelBuilder.lumina_InitTunnelBuild(coordinatePair, coordinate ,params[0]);
                case "[lumina-shelter]":
                    LuminaShelterBuilder shelterBuilder = new LuminaShelterBuilder();
                    return shelterBuilder.lumina_InitShelterBuild(coordinatePair, coordinate ,params[0]);
                default:
                    System.out.println("[AI-LM][error] LuminaSystem 序列="+sequenceName+" 执行失败。原因是未找到对应序列。程序即将终止。");
                    return null;
            }
        } else {
            return null;
        }
    }

}
