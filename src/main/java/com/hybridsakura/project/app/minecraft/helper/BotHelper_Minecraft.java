package com.hybridsakura.project.app.minecraft.helper;

import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.function.LuminaEngine;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotHelper_Minecraft {

    LuminaEngine luminaEngine = new LuminaEngine();

    public void analyseString(String order) {
        //  分析传入参数，把字符串分析出三个部分
        //  [Coordinate1],[Coordinate2 or radius],[sequenceName],[blockName]
        //
        String testString = "MCG [100,65,100] [3] [lumina-beacon]";
        List<String> partList = Arrays.asList(testString.split(" "));

        String seqName = "";
        String seqMode = "";
        MinecraftCoordinate coordinate1 = new MinecraftCoordinate();
        MinecraftCoordinate coordinate2 = new MinecraftCoordinate();
        int radius = 0;
        if(partList.size() == 4) {
            seqName = partList.get(0);
            seqMode = partList.get(3);

            List<String> seqList = new ArrayList<String>();
            Pattern pattern = Pattern.compile("(\\[[^\\]]*\\])");
            Matcher matcher = pattern.matcher(testString);
            while (matcher.find()) {
                seqList.add(matcher.group().substring(1, matcher.group().length()-1));
            }

            if(seqList.get(0).contains(",")) {
                coordinate1 = getCoordinateFromString(seqList.get(0));
            }
            if(seqList.get(1).contains(",")) {
                coordinate2 = getCoordinateFromString(seqList.get(1));
            } else {
                radius = Integer.parseInt(seqList.get(1));
            }
        }

        System.out.println("");



    }

    public static void main(String[] args) {
        BotHelper_Minecraft minecraft = new BotHelper_Minecraft();
        minecraft.analyseString("");
    }

    public MinecraftCoordinate getCoordinateFromString(@NotNull String rawString) {
        List<String> list = Arrays.asList(rawString.split(","));
        if(list.size() == 3) {
            return new MinecraftCoordinate(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)));
        }
        return null;
    }


}
