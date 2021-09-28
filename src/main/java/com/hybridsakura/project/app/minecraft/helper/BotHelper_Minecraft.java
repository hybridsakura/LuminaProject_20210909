package com.hybridsakura.project.app.minecraft.helper;

import java.util.Arrays;
import java.util.List;

public class BotHelper_Minecraft {

    public void analyseString(String order) {
        //  分析传入参数，把字符串分析出三个部分
        //  [Coordinate1],[Coordinate2 or radius],[sequenceName],[blockName]
        //
        String testString = "\"MC-GEN\"=[1,1,1][2,2,2][sequenceA]";
        List<String> stringList = Arrays.asList(testString.split("="));
        if(stringList.size() == 2) {
            if(stringList.get(0) != null && "\"MC-GEN\"".equals(stringList.get(0))) {
                System.out.println("侦测到mcgen序列用法");
                List<String> tempList = Arrays.asList(stringList.get(1).split(","));
                if(tempList.size() == 7) {
                    for(String s : tempList) {
                        System.out.println(s);
                    }
                }else if(tempList.size() == 8) {

                }
            }
        }


    }

    public static void main(String[] args) {
        BotHelper_Minecraft minecraft = new BotHelper_Minecraft();
        minecraft.analyseString("");
    }


}
