package com.hybridsakura.project.app.minecraft.builder;

import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;
import com.hybridsakura.project.app.minecraft.function.LuminaFunction;
import com.hybridsakura.project.app.minecraft.helper.LuminaHelper;

import java.util.ArrayList;
import java.util.List;

public class LuminaTunnelBuilder {

    LuminaHelper luminaHelper = new LuminaHelper();

    //  Lumina 隧道建造者
    public List<String> lumina_InitTunnelBuild(MinecraftCoordinatePair coordinatePair, MinecraftCoordinate coordinate, FlexibleParams... params) {

        if(coordinatePair.getMinecraftCoordinate1() != null && coordinatePair.getMinecraftCoordinate2() != null) {
            return deploySingleLineBaseTunnel(coordinatePair);
        } else {
            return null;
        }
    }

    //  封闭方式：管道型、封闭型
    //  层数：单层（适用于直径为+2或+3）、双层（适用于直径+4到+5）、三层（适用于直径+5及以上的）
    //  填充模式：全封闭区间（单种方块，不加火把就漆黑一片）、半封闭区间（露天的）、观光封闭区间（顶部或两侧使用透光方块）
    //  1.确定展开点坐标 2.确定展开方向 3.确定展开距离 4.确定展开半径
    //                或将展开方向和距离结合，使用两个坐标点来确定（拟合【方向】和【距离】）

    public List<String> deploySingleLineBaseTunnel(MinecraftCoordinatePair coordinatePair) {

        List<String> orderList = new ArrayList<>();

        //  最基本的测试版本，指定起点和终点，用两点拟合方向并计算距离，生成半径为+2的基础型隧道
        String direction = luminaHelper.coordinateAxisJudgement(coordinatePair);
        int length = luminaHelper.coordinateLengthHelper(coordinatePair);

        //  获取起终点坐标
        MinecraftCoordinatePair tempCoordinatePair1, tempCoordinatePair2, tempCoordinatePair3, tempCoordinatePair4;

        LuminaFunction luminaFunction = new LuminaFunction();
        tempCoordinatePair1 = luminaFunction.luminaFinalTunnelBuild(coordinatePair.getMinecraftCoordinate1(), direction, 4, length, "").get(0);
        tempCoordinatePair2 = luminaFunction.luminaFinalTunnelBuild(coordinatePair.getMinecraftCoordinate1(), direction, 3, length, "").get(1);
//        tempCoordinatePair3 = luminaFunction.luminaFinalTunnelBuild(coordinatePair.getMinecraftCoordinate1(), direction, 2, length, "").get(2);
//        tempCoordinatePair4 = luminaFunction.luminaFinalTunnelBuild(coordinatePair.getMinecraftCoordinate1(), direction, 2, length, "").get(3);

        System.out.println("/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair1) + "iron_block");
        System.out.println("/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair2) + "air");
//        System.out.println("/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair3) + "iron_block");
//        System.out.println("/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair4) + "iron_block");

        orderList.add("/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair1) + "iron_block");
        orderList.add("/fill" + luminaHelper.coordinateOrderCodeFormatter(tempCoordinatePair2) + "air");
        return orderList;

    }



}
