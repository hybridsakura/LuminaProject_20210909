package com.hybridsakura.project.app.minecraft.function;

import com.hybridsakura.project.app.minecraft.builder.*;
import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;

import java.util.List;

import static com.hybridsakura.project.common.LuminaCommon.*;

public class LuminaEngine {

    public List<String> LuminaMasterSequence(MinecraftCoordinatePair coordinatePair, MinecraftCoordinate coordinate, FlexibleParams... params) {
        String sequenceName;
        System.out.println("[AI-LM][] Lumina主序列 启动");
        if(params[0] != null && !"".equals(params[0].getSequenceName())) {
            sequenceName = params[0].getSequenceName();
            System.out.println("[AI-LM][] LuminaSystem 序列="+sequenceName+" 准备执行...");
            switch (sequenceName) {
                case LUMINA_MINECRAFT_BSN_BASICS:
                    LuminaBasicsBuilder basicsBuilder = new LuminaBasicsBuilder();
                    return basicsBuilder.lumina_InitBasicsBuild(coordinatePair, coordinate ,params[0]);
                case LUMINA_MINECRAFT_BSN_BEACON:
                    LuminaBeaconBuilder beaconBuilder = new LuminaBeaconBuilder();
                    return beaconBuilder.lumina_InitBeaconBuild(coordinatePair, coordinate ,params[0]);
                case LUMINA_MINECRAFT_BSN_BRIDGE:
                    LuminaBridgeBuilder bridgeBuilder = new LuminaBridgeBuilder();
                    return bridgeBuilder.lumina_InitBridgeBuild(coordinatePair, coordinate ,params[0]);
                case LUMINA_MINECRAFT_BSN_TUNNEL:
                    LuminaTunnelBuilder tunnelBuilder = new LuminaTunnelBuilder();
                    return tunnelBuilder.lumina_InitTunnelBuild(coordinatePair, coordinate ,params[0]);
                case LUMINA_MINECRAFT_BSN_SHELTER:
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
