package com.hybridsakura.project.app.minecraft.helper;

import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;
import com.hybridsakura.project.app.minecraft.function.LuminaFunction;

import java.util.ArrayList;
import java.util.List;

public class LuminaUtil {

    //  建造
    LuminaHelper luminaHelper = new LuminaHelper();
    LuminaFunction luminaFunction = new LuminaFunction();

    //  [唯一建造指令] 输入两个坐标，指定一个默认参数（可以不指定）
    public List<String> buildOrderGenerator(MinecraftCoordinatePair coordinatePair, String blockQualifyName, int ... s) {
        String prefix;
        List<String> orderList = new ArrayList<>();
        if(!"".equals(blockQualifyName) && (coordinatePair != null)) {
            prefix = "/fill";
            String coordinateStartEnd = luminaHelper.coordinateOrderCodeFormatter(coordinatePair);
            System.out.println(prefix + coordinateStartEnd + blockQualifyName);
            orderList.add(prefix + coordinateStartEnd + blockQualifyName);
            return orderList;
        }else {
            return null;
        }
    }





}
