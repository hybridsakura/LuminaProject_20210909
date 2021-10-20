package com.hybridsakura.project.app.minecraft.function;

import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;
import com.hybridsakura.project.app.minecraft.helper.LuminaHelper;

import java.util.ArrayList;
import java.util.List;

public class LuminaFunction {

    //  LuminaFunction MC主要功能逻辑 详细

    LuminaHelper luminaHelper = new LuminaHelper();

    //  根据[原点坐标]和[展开方向]以及指定的[桥梁宽度]和[桥梁长度]，生成最终MC指令中要用的[坐标组]
    public MinecraftCoordinatePair luminaFinalBridgeBuild(MinecraftCoordinate locateCoordinate, String direction, int width, int length) {
        if(width == 0) {
            width = 2;
            System.out.println("[AI-LM][HELP_INFO] 侦测到未对<width>进行定义或定义为0，露米娜已自动将<width>重设为2");
        }
        MinecraftCoordinate coordinateStart, coordinateEnd;
        switch (direction) {
            case "X+":
                System.out.println("沿X轴正方向延申");
                System.out.println("[第一象限 X2>X1,Z2>Z1][第四象限 X2>X1,Z2<Z1]");
                System.out.println("[起点坐标 0,-W][终点坐标 +L,-W]");
                coordinateStart = new MinecraftCoordinate(locateCoordinate.getX(), locateCoordinate.getY(), locateCoordinate.getZ() - width);
                coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() + length, locateCoordinate.getY(), locateCoordinate.getZ() + width);
                break;
            case "Z+":
                System.out.println("沿Z轴正方向延申");
                System.out.println("[第一象限 X2>X1,Z2>Z1][第二象限 X2<X1,Z2>Z1]");
                System.out.println("[起点坐标 +W,0][终点坐标 -W,+L]");
                coordinateStart = new MinecraftCoordinate(locateCoordinate.getX() + width, locateCoordinate.getY(), locateCoordinate.getZ());
                coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() - width, locateCoordinate.getY(), locateCoordinate.getZ() + length);
                break;
            case "X-":
                System.out.println("沿X轴负方向延申");
                System.out.println("[第二象限 X2<X1,Z2>Z1][第三象限 X2<X1,Z2<Z1]");
                System.out.println("[起点坐标 0,+W][终点坐标 -L,-W]");
                coordinateStart = new MinecraftCoordinate(locateCoordinate.getX(), locateCoordinate.getY(), locateCoordinate.getZ() + width);
                coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() - length, locateCoordinate.getY(), locateCoordinate.getZ() - width);
                break;
            case "Z-":
                System.out.println("沿Z轴负方向延申");
                System.out.println("[第三象限 X2<X1,Z2<Z1][第四象限 X2>X1,Z2<Z1]");
                System.out.println("[起点坐标 -W,0][终点坐标 +W,-L]");
                coordinateStart = new MinecraftCoordinate(locateCoordinate.getX() - width, locateCoordinate.getY(), locateCoordinate.getZ());
                coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() + width, locateCoordinate.getY(), locateCoordinate.getZ() - length);
                break;
            default:
                System.out.println("不属于任何一种结果，这根本不可能！请确保你传入的参数[direction]填写正确！");
                coordinateStart = new MinecraftCoordinate(0, 0, 0);
                coordinateEnd = new MinecraftCoordinate(0, 0, 0);
                break;
        }

        return new MinecraftCoordinatePair(coordinateStart, coordinateEnd);
    }

        public List<MinecraftCoordinatePair> luminaFinalTunnelBuild(MinecraftCoordinate locateCoordinate, String direction, int radius, int length, String buildMode) {
            List<MinecraftCoordinatePair> coordinatePairList = new ArrayList<>();
            MinecraftCoordinate outer_coordinateStart, outer_coordinateEnd, inner_coordinateStart, inner_coordinateEnd;
            MinecraftCoordinate decorate1_coordinateStart, decorate1_coordinateEnd, decorate2_coordinateStart, decorate2_coordinateEnd;
            switch (direction) {
                case "X+":
                    //  默认解法 改版
                    outer_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX(), locateCoordinate.getY() - radius, locateCoordinate.getZ() - radius);
                    outer_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() + length, locateCoordinate.getY() + radius, locateCoordinate.getZ() + radius);
                    inner_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX(), locateCoordinate.getY() - (radius - 1), locateCoordinate.getZ() - (radius - 1));
                    inner_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() + length, locateCoordinate.getY() + (radius - 1), locateCoordinate.getZ() + (radius - 1));
                    //  构建返回的数据list
                    coordinatePairList.add(new MinecraftCoordinatePair(outer_coordinateStart, outer_coordinateEnd));
                    coordinatePairList.add(new MinecraftCoordinatePair(inner_coordinateStart, inner_coordinateEnd));
                    break;
                case "Z+":
                    //  默认解法 改版
                    outer_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX() + radius, locateCoordinate.getY() - radius, locateCoordinate.getZ());
                    outer_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() - radius, locateCoordinate.getY() + radius, locateCoordinate.getZ() + length);
                    inner_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX() + (radius - 1), locateCoordinate.getY() - (radius - 1), locateCoordinate.getZ());
                    inner_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() - (radius - 1), locateCoordinate.getY() + (radius - 1), locateCoordinate.getZ() + length);
                    //  构建返回的数据list
                    coordinatePairList.add(new MinecraftCoordinatePair(outer_coordinateStart, outer_coordinateEnd));
                    coordinatePairList.add(new MinecraftCoordinatePair(inner_coordinateStart, inner_coordinateEnd));
                    break;
                case "X-":
                    //  默认解法 改版
                    outer_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX(), locateCoordinate.getY() - radius, locateCoordinate.getZ() + radius);
                    outer_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() - length, locateCoordinate.getY() + radius, locateCoordinate.getZ() - radius);
                    inner_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX(), locateCoordinate.getY() - (radius - 1), locateCoordinate.getZ() + (radius - 1));
                    inner_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() - length, locateCoordinate.getY() + (radius - 1), locateCoordinate.getZ() - (radius - 1));
                    //  构建返回的数据list
                    coordinatePairList.add(new MinecraftCoordinatePair(outer_coordinateStart, outer_coordinateEnd));
                    coordinatePairList.add(new MinecraftCoordinatePair(inner_coordinateStart, inner_coordinateEnd));
                    break;
                case "Z-":
                    //  默认解法 改版
                    outer_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX() - radius, locateCoordinate.getY() - radius, locateCoordinate.getZ());
                    outer_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() + radius, locateCoordinate.getY() + radius, locateCoordinate.getZ() - length);
                    inner_coordinateStart = new MinecraftCoordinate(locateCoordinate.getX() - (radius - 1), locateCoordinate.getY() - (radius - 1), locateCoordinate.getZ());
                    inner_coordinateEnd = new MinecraftCoordinate(locateCoordinate.getX() + (radius - 1), locateCoordinate.getY() + (radius - 1), locateCoordinate.getZ() - length);
                    //  构建返回的数据list
                    coordinatePairList.add(new MinecraftCoordinatePair(outer_coordinateStart, outer_coordinateEnd));
                    coordinatePairList.add(new MinecraftCoordinatePair(inner_coordinateStart, inner_coordinateEnd));
                    break;
                default:
                    System.out.println("不属于任何一种结果，这根本不可能！请确保你传入的参数[direction]填写正确！");
                    outer_coordinateStart = new MinecraftCoordinate(0, 0, 0);
                    outer_coordinateEnd = new MinecraftCoordinate(0, 0, 0);

                    coordinatePairList.add(new MinecraftCoordinatePair(outer_coordinateStart, outer_coordinateEnd));

                    break;
            }
            return coordinatePairList;
        }




}
