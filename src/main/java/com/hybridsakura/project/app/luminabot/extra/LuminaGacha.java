package com.hybridsakura.project.app.luminabot.extra;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LuminaGacha {

    public List<String> gachaResultGen() {

        String backWord = "抽签结果未定义";
        String backImageURL = "/";

        List<String> gachaResultList = new ArrayList<>();

        Random r = new Random(new Date().getTime());
        int ran1 = r.nextInt(1000);
//        int ran2 = r.nextInt(100);

        boolean inRangeA = ran1 >= 800;
        boolean inRangeB = ran1 < 800 && ran1 >= 600;
        boolean inRangeC = ran1 < 600 && ran1 >= 400;
        boolean inRangeD = ran1 < 400 && ran1 >= 200;
        boolean inRangeE = ran1 <= 199 && ran1 > 0;

        if(inRangeA) {
            backWord = " 抽中了大吉！";
            backImageURL = "https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png";
        } else if(inRangeB) {
            backWord = " 抽中了中吉！";
            backImageURL = "https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png";
        } else if(inRangeC) {
            backWord = " 抽中了木吉！（欸？）";
            backImageURL = "https://gchat.qpic.cn/gchatpic_new/179223207/661246876-2585424449-D7ABF276327163E9E9073843F22F78C9/0?term=3";
        } else if(inRangeD) {
            backWord = " 抽中了凶！摸摸头~";
            backImageURL = "https://gchat.qpic.cn/gchatpic_new/179223207/661246876-2585424449-D7ABF276327163E9E9073843F22F78C9/0?term=3";
        } else if(inRangeE) {
            backWord = " 抽中了大凶！\n 呜哇！喵都发火了！";
            backImageURL = "https://gchat.qpic.cn/gchatpic_new/179223207/661246876-2585424449-D7ABF276327163E9E9073843F22F78C9/0?term=3";
        } else {
            backWord = "你运气真的非常好！出现这种结果的概率是千分之一！\n 作者决定请你喝一瓶可乐，请私信领取！";
            backImageURL = "https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png";
        }

        gachaResultList.add(backWord);
        gachaResultList.add(backImageURL);

        return gachaResultList;
    }


}
