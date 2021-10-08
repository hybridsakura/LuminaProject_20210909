package com.hybridsakura.project.app.minecraft.helper;

import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;
import com.hybridsakura.project.app.minecraft.function.LuminaEngine;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("DuplicatedCode")
public class BotHelper_Minecraft {

    LuminaEngine luminaEngine = new LuminaEngine();

    public List<String> analyseString(String order, Boolean at) {
        //  分析传入参数，把字符串分析出三个部分
        //  [Coordinate1],[Coordinate2 or radius],[sequenceName],[blockName]
        //
//        String testString = "MCG [100,65,100] [3] [lumina-beacon]";

        //  检测是否符合要求
        //  1.数组长度必须为4或5 2.包含认证参数MCG 3.要求确认at(可选)

        List<String> partList = Arrays.asList(order.split(" "));

        boolean qualifiedListLength = partList.size() == 4 || partList.size() == 5;
        boolean qualifiedRouteKeyword = order.contains("MCG");
        boolean qualifiedAtLumina = at;

        if(qualifiedListLength && qualifiedRouteKeyword && qualifiedAtLumina) {
            String seqName = "";
            MinecraftCoordinate coordinate1 = new MinecraftCoordinate();
            MinecraftCoordinate coordinate2 = new MinecraftCoordinate();
            int radius = 0;
            List<String> seqList = new ArrayList<String>();
            System.out.println("已确认到激活的序列名: " + partList.get(0));
            if(partList.size() == 4) {
                seqName = partList.get(3);
                Pattern pattern = Pattern.compile("(\\[[^\\]]*\\])");
                Matcher matcher = pattern.matcher(order);
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
            } else if(partList.size() == 5) {
                seqName = partList.get(4);
                Pattern pattern = Pattern.compile("(\\[[^\\]]*\\])");
                Matcher matcher = pattern.matcher(order);
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
                if(seqList.size() == 4 && seqList.get(1).contains(",")) {
                    System.out.println("！");
                    radius = Integer.parseInt(seqList.get(2));
                }else{
                    System.out.println("????????");
                }
            }

            FlexibleParams params = new FlexibleParams();
            params.setSequenceName(seqName);
            params.setWidth(radius);
            //  确定如何构造调用方法
            //  1.只有一个坐标 2.有一个坐标和半径 3.有两个坐标 4.有两个坐标和1个厚度
            if(coordinate1 != null && coordinate2 == null) {
                //  1.只有一个坐标
                return luminaEngine.LuminaMasterSequence(new MinecraftCoordinatePair(), coordinate1, params);
            } else if(coordinate1 != null && radius != 0) {
                //  2.有一个坐标和半径
                return luminaEngine.LuminaMasterSequence(new MinecraftCoordinatePair(), coordinate1, params);
            } else if(coordinate1 != null) {
                //  3.有两个坐标
                return luminaEngine.LuminaMasterSequence(new MinecraftCoordinatePair(coordinate1, coordinate2), new MinecraftCoordinate(), params);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public List<String> analyseStringX(String order, Boolean at) {
        //  通过分析传入的字符串来进行处理
        List<String> partList = Arrays.asList(order.split(" "));
        System.out.println("partList [size=" + partList.size() + "]");

        boolean qualifiedSize = partList.size() == 4 || partList.size() == 5;
        boolean qualifiedKeyword = order.contains("处理坐标") && ("处理坐标".equals(partList.get(0)) || "处理坐标".equals(partList.get(1)));
        boolean qualifiedSeqName = order.contains("lumina-");
        boolean qualifiedCondition = qualifiedSize && qualifiedKeyword && qualifiedSeqName;
        if(qualifiedCondition) {

            //  初始化新对象
            MinecraftCoordinate coordinate1 = new MinecraftCoordinate();
            MinecraftCoordinate coordinate2 = new MinecraftCoordinate();
            MinecraftCoordinatePair coordinatePair = null;
            int radius = 0;
            boolean radiusChanged = false;      //  无实际作用，调试辅助

            //  确定radius和seqName
            System.out.println("partList.get(3)= " + partList.get(3).substring(1,partList.get(3).length()-1));
            if(!partList.get(3).contains(",")) {
                radius = Integer.parseInt(partList.get(3).substring(1,partList.get(3).length()-1));
            }
            String sequenceName = partList.get(4);

            List<MinecraftCoordinate> matcherList = new ArrayList<MinecraftCoordinate>();
            Pattern pattern = Pattern.compile("(\\[[^\\]]*\\])");
            Matcher matcher = pattern.matcher(order);

            while (matcher.find()) {
                //  首位都是中括号，只取中间部分
                if(matcher.group() != null) {
                    matcherList.add(getCoordinateFromString(matcher.group().substring(1, matcher.group().length()-1)));
                }
            }

            //  参数设置
            FlexibleParams params = new FlexibleParams();
            params.setSequenceName(sequenceName);
            if(params.getWidth() != 0) {
                params.setWidth(radius);
            }

            List<String> returnList = null;


            if(matcherList.get(0) != null) {
                coordinate1 = matcherList.get(0);
            }else if(matcherList.get(1) != null) {
                coordinate2 = matcherList.get(1);
                coordinatePair = new MinecraftCoordinatePair(coordinate1, coordinate2);
            }

            returnList = luminaEngine.LuminaMasterSequence(new MinecraftCoordinatePair(coordinate1, coordinate2), new MinecraftCoordinate(), params);

//            if(matcherList.size() >= 2) {
//                //  1.启动双坐标处理模式
//                coordinate1 = matcherList.get(0);
//                coordinate2 = matcherList.get(1);
//
//                returnList = luminaEngine.LuminaMasterSequence(new MinecraftCoordinatePair(coordinate1, coordinate2), new MinecraftCoordinate(), params);
//            } else if(matcherList.size() == 1) {
//                //  2.启动单坐标、且包含radius的处理模式
//                if(params.getWidth() != 0) {
//                    //  单坐标
//                    returnList = luminaEngine.LuminaMasterSequence(new MinecraftCoordinatePair(), coordinate1);
//                } else {
//                    //  单坐标和半径
//                    returnList = luminaEngine.LuminaMasterSequence(new MinecraftCoordinatePair(), coordinate1, params);
//                }
//            }

            return returnList;
        } else {
            return null;
        }

    }

    private MinecraftCoordinate getCoordinateFromString(@NotNull String rawString) {
        List<String> list = Arrays.asList(rawString.split(","));
        if(list.size() == 3) {
            return new MinecraftCoordinate(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)));
        }
        return null;
    }

}
