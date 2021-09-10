package com.hybridsakura.project.app.minecraft.builder;


import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;
import com.hybridsakura.project.app.minecraft.function.LuminaFunction;
import com.hybridsakura.project.app.minecraft.helper.LuminaHelper;

public class LuminaBridgeBuilder {

    //  Lumina 桥梁建造者

    LuminaHelper luminaHelper = new LuminaHelper();

    public void lumina_InitBridgeBuild(MinecraftCoordinatePair coordinatePair, MinecraftCoordinate coordinate, FlexibleParams... params) {

        LuminaFunction luminaFunction = new LuminaFunction();
        //  获取起终点坐标
        MinecraftCoordinatePair tempCoordinatePair;

        tempCoordinatePair = luminaFunction.luminaFinalBridgeBuild(coordinatePair.getMinecraftCoordinate1(), luminaHelper.coordinateAxisJudgement(coordinatePair), params[0].getWidth(), luminaHelper.coordinateLengthHelper(coordinatePair));

        System.out.println("/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair) + "iron_block");
    }

//    public String Lumina_BuildBridgeSeq(MinecraftCoordinatePair coordinatePair) {
//        /* 新定义一个StringBuilder用于创建返回时生成的命令 */
//        StringBuilder stringBuilder;
//        stringBuilder = new StringBuilder();
//        /* 拼接初始语句头 */
//        stringBuilder.append("/fill ");
//        /* 定义△X、△Y、△Z等参数 */
//        float deltaX = 0, deltaY = 0, deltaZ = 0, absDeltaX = 0, absDeltaY = 0, absDeltaZ = 0;
//        System.out.println("输入的起点坐标为["+coordinatePair.getMinecraftCoordinate1().getX()+","+coordinatePair.getMinecraftCoordinate1().getY()+","+coordinatePair.getMinecraftCoordinate1().getZ()+"]");
//        System.out.println("输入的终点坐标为["+coordinatePair.getMinecraftCoordinate2().getX()+","+coordinatePair.getMinecraftCoordinate2().getY()+","+coordinatePair.getMinecraftCoordinate2().getZ()+"]");
//        deltaX = coordinatePair.getMinecraftCoordinate2().getX() - coordinatePair.getMinecraftCoordinate1().getX();
//        deltaY = coordinatePair.getMinecraftCoordinate2().getY() - coordinatePair.getMinecraftCoordinate1().getY();
//        deltaZ = coordinatePair.getMinecraftCoordinate2().getZ() - coordinatePair.getMinecraftCoordinate1().getZ();
//        absDeltaX = Math.abs(deltaX);absDeltaY = Math.abs(deltaY);absDeltaZ = Math.abs(deltaZ);
//        System.out.println("[deltaX: "+deltaX+"][deltaY: "+deltaY+"][deltaZ: "+deltaZ+"]");
//        System.out.println("[absDeltaX: "+absDeltaX+"][absDeltaY: "+absDeltaY+"][absDeltaZ: "+absDeltaZ+"]");
//
//        return "";
//    }
//
//    //  MC指令拼接
//    public String Lumina_BuildBridgeCode(MinecraftCoordinatePair coordinatePair, int width) {
//
//        LuminaFunction luminaFunction = new LuminaFunction();
//        //  获取起终点坐标
//        MinecraftCoordinatePair tempCoordinatePair = luminaFunction.LuminaBuildHelper(coordinatePair.getMinecraftCoordinate1(), luminaHelper.coordinateAxisJudgement(coordinatePair), width, luminaHelper.coordinateLengthHelper(coordinatePair));
////        String coreString = luminaSystem.CoordinateSetFormatter(tempCoordinateSet);
//
//        return "/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair) + "iron_block";
//    }

}
