package com.hybridsakura.project.app.minecraft.function;

import com.hybridsakura.project.app.minecraft.builder.*;
import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;

public class LuminaEngine {

    public void LuminaMasterSequence(MinecraftCoordinatePair coordinatePair, MinecraftCoordinate coordinate, FlexibleParams... params) {
        String sequenceName;
        System.out.println("[AI-LM][] Lumina主序列 启动");
        if(params[0] != null && !"".equals(params[0].getSequenceName())) {
            sequenceName = params[0].getSequenceName();
            System.out.println("[AI-LM][] LuminaSystem 序列="+sequenceName+" 准备执行...");
            switch (sequenceName) {
                case "[lumina-basics]":
                    LuminaBasicsBuilder basicsBuilder = new LuminaBasicsBuilder();
                    basicsBuilder.lumina_InitBasicsBuild(coordinatePair, coordinate ,params[0]);
                    break;
                case "[lumina-beacon]":
                    LuminaBeaconBuilder beaconBuilder = new LuminaBeaconBuilder();
                    beaconBuilder.lumina_InitBeaconBuild(coordinatePair, coordinate ,params[0]);
                    break;
                case "[lumina-bridge]":
                    LuminaBridgeBuilder bridgeBuilder = new LuminaBridgeBuilder();
                    bridgeBuilder.lumina_InitBridgeBuild(coordinatePair, coordinate ,params[0]);
                    break;
                case "[lumina-tunnel]":
                    LuminaTunnelBuilder tunnelBuilder = new LuminaTunnelBuilder();
                    tunnelBuilder.lumina_InitTunnelBuild(coordinatePair, coordinate ,params[0]);
                    break;
                case "[lumina-shelter]":
                    LuminaShelterBuilder shelterBuilder = new LuminaShelterBuilder();
                    shelterBuilder.lumina_InitShelterBuild(coordinatePair, coordinate ,params[0]);
                    break;
                default:
                    System.out.println("[AI-LM][error] LuminaSystem 序列="+sequenceName+" 执行失败。原因是未找到对应序列。程序即将终止。");
                    break;
            }

        }

    }

}
