package com.hybridsakura.project.app.minecraft.helper;

import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinatePair;

public class LuminaHelper {

    //  针对输入的坐标组进行判断靠近哪一个坐标轴，返回坐标方向
    public String coordinateAxisJudgement(MinecraftCoordinatePair coordinateSet) {
        MinecraftCoordinate baseCoordinate = coordinateSet.getMinecraftCoordinate1();
        MinecraftCoordinate targetCoordinate = coordinateSet.getMinecraftCoordinate2();
        //  [目标坐标横轴刻度]的绝对值与[目标坐标纵轴刻度]的绝对值比较大小，靠哪边延申
        boolean isXBiggerZ = Math.abs(targetCoordinate.getX() - baseCoordinate.getX()) > Math.abs(targetCoordinate.getZ() - baseCoordinate.getZ());

        System.out.println("[X轴坐标值大于Z轴坐标值]= "+ (isXBiggerZ ? "是，点更靠X轴" : "否，点更靠Z轴"));

        //  起终点坐标比较大小判断延申象限 终点X>起点X 终点Z>起点Z 第一象限
        boolean isTargetXBigger = targetCoordinate.getX() > baseCoordinate.getX();
        boolean isTargetXSmaller = targetCoordinate.getX() < baseCoordinate.getX();
        boolean isTargetZBigger = targetCoordinate.getZ() > baseCoordinate.getZ();
        boolean isTargetZSmaller = targetCoordinate.getZ() < baseCoordinate.getZ();

        System.out.println("起点坐标[baseCoordinate]=["+baseCoordinate.getX()+","+baseCoordinate.getZ()+"]");
        System.out.println("终点坐标[targetCoordinate]=["+targetCoordinate.getX()+","+targetCoordinate.getZ()+"]");


        //  用于判断以[baseCoordinate]为原点时，[targetCoordinate]所处的[平面直角坐标系][象限]
        boolean quadrant1 = isTargetXBigger && isTargetZBigger;
        boolean quadrant2 = isTargetXSmaller && isTargetZBigger;
        boolean quadrant3 = isTargetXSmaller && isTargetZSmaller;
        boolean quadrant4 = isTargetXBigger && isTargetZSmaller;

        System.out.println("参考系于原点时处于[第一象限]=" + (quadrant1 ? "是" : "否"));
        System.out.println("参考系于原点时处于[第二象限]=" + (quadrant2 ? "是" : "否"));
        System.out.println("参考系于原点时处于[第三象限]=" + (quadrant3 ? "是" : "否"));
        System.out.println("参考系于原点时处于[第四象限]=" + (quadrant4 ? "是" : "否"));

        String direct = "";
        if(quadrant1 && isXBiggerZ) {
            direct = "X+";
            System.out.println("1");
        }
        if(quadrant4 && isXBiggerZ) {
            direct = "X+";
            System.out.println("2");
        }

        if(quadrant1 && !isXBiggerZ) {
            direct = "Z+";
            System.out.println("3");
        }
        if(quadrant2 && !isXBiggerZ) {
            direct = "Z+";
            System.out.println("4");
        }

        if(quadrant2 && isXBiggerZ) {
            direct = "X-";
            System.out.println("5");
        }
        if(quadrant3 && isXBiggerZ) {
            direct = "X-";
            System.out.println("6");
        }

        if(quadrant3 && !isXBiggerZ) {
            direct = "Z-";
            System.out.println("7");
        }
        if(quadrant4 && !isXBiggerZ) {
            direct = "Z-";
            System.out.println("8");
        }
        System.out.println("[direct]= "+direct);

        return direct;
    }

    //  将一组坐标（两个坐标点）转换成Minecraft所规定的代码形式 " x1 y1 z1 x2 y2 z2 "
    public String coordinateOrderCodeFormatter(MinecraftCoordinatePair coordinatePair) {
        if(coordinatePair.getMinecraftCoordinate1() != null && coordinatePair.getMinecraftCoordinate2() != null) {
            return " " + String.valueOf(coordinatePair.getMinecraftCoordinate2().getX()) + " " + String.valueOf(coordinatePair.getMinecraftCoordinate2().getY())
                    + " " + String.valueOf(coordinatePair.getMinecraftCoordinate2().getZ() + " " + String.valueOf(coordinatePair.getMinecraftCoordinate1().getX())
                    + " " + String.valueOf(coordinatePair.getMinecraftCoordinate1().getY()) + " " + String.valueOf(coordinatePair.getMinecraftCoordinate1().getZ())
                    + " ");
        } else if(coordinatePair.getMinecraftCoordinate1() != null || coordinatePair.getMinecraftCoordinate2() != null) {
            MinecraftCoordinate coordinate = new MinecraftCoordinate(0, 0 , 0);
            if(coordinatePair.getMinecraftCoordinate1() != null) {
                coordinate = coordinatePair.getMinecraftCoordinate1();
            }
            if(coordinatePair.getMinecraftCoordinate2() != null) {
                coordinate = coordinatePair.getMinecraftCoordinate2();
            }
            return " " + String.valueOf(coordinate.getX()) + " " + String.valueOf(coordinate.getY())+ " " + String.valueOf(coordinate.getZ() + " ");
        } else {
            return "[x2 y2 z2 x1 y1 z1]";
        }
    }

    //  计算两个坐标间的距离，以较长轴为主
    public int coordinateLengthHelper(MinecraftCoordinatePair coordinatePair) {
        return (int) Math.max(Math.abs(coordinatePair.getMinecraftCoordinate2().getX() - coordinatePair.getMinecraftCoordinate1().getX())
                , Math.abs(coordinatePair.getMinecraftCoordinate2().getZ() - coordinatePair.getMinecraftCoordinate1().getZ()));
    }

    //  按照一个核心点和半径、展开形式，获取
    public MinecraftCoordinatePair generatePanelByRadiusAndDirection(MinecraftCoordinate coordinate, int radius, String directionCode) {
        radius = Math.abs(radius);
        //  按点展开，按轴展开
        MinecraftCoordinate coordinate1;
        MinecraftCoordinate coordinate2;
        //  根据传值来判断展开的方向
        if("AXIS-HOLD-Z".equals(directionCode)) {
            //  以Z轴展开
//            System.out.println("[AI-LM][Z-AXIS 纵向展开 按照Z轴]");
            coordinate1 = new MinecraftCoordinate(coordinate.getX(), coordinate.getY() - radius, coordinate.getZ() - radius);
            coordinate2 = new MinecraftCoordinate(coordinate.getX(), coordinate.getY() + radius, coordinate.getZ() + radius);
        } else if("AXIS-HOLD-X".equals(directionCode)) {
            //  以Z轴展开
//            System.out.println("[AI-LM][Z-AXIS 纵向展开 按照Z轴]");
            coordinate1 = new MinecraftCoordinate(coordinate.getX() + radius, coordinate.getY() - radius, coordinate.getZ());
            coordinate2 = new MinecraftCoordinate(coordinate.getX() - radius, coordinate.getY() + radius, coordinate.getZ());
        } else if("AXIS-HOLD-Y".equals(directionCode)) {
            //  以Y轴展开
//            System.out.println("[AI-LM][Y-AXIS 按照平面展开]");
            coordinate1 = new MinecraftCoordinate(coordinate.getX() - radius, coordinate.getY(), coordinate.getZ() + radius);
            coordinate2 = new MinecraftCoordinate(coordinate.getX() + radius, coordinate.getY(), coordinate.getZ() - radius);
        } else {
            System.err.println("[AI-LM][??? 未知限定名，无法展开]");
            coordinate1 = null;
            coordinate2 = null;
        }
        return new MinecraftCoordinatePair(coordinate1, coordinate2);
    }

}
