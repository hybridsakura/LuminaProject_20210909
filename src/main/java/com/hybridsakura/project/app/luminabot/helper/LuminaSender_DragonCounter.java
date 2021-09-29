package com.hybridsakura.project.app.luminabot.helper;

import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hybridsakura.project.common.LuminaCommon.RETURN_IMAGE;
import static com.hybridsakura.project.common.LuminaCommon.RETURN_TEXT;

public class LuminaSender_DragonCounter {

    LuminaSender_CourierX courierX = new LuminaSender_CourierX();

    //  龙王反制装置：对指定群聊的指定QQ号进行龙王反制
    public void sendCounterMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaRequireSetup luminaRequireSetup) {

        //  获取群号
//        System.out.println("龙王反制模块 [AI-LM][UserID/用户QQ号] " + event.getUserId());
//        System.out.println("龙王反制模块 [AI-LM][GroupID/QQ群号] " + event.getGroupId());
//        System.out.println("龙王反制模块 [AI-LM][RawMessage/原始消息] " + event.getRawMessage());
        //  装箱操作
        Long userIdBox = event.getUserId();
        Long groupIdBox = event.getGroupId();
        //  定义龙王所在群聊
        Long dragonUerID_YM = 1317274709L;
        Long dragonGroupID_YM_1 = 1036113904L;
        Long dragonGroupID_YM_2 = 698146016L;
        Long dragonUerID_MY = 179223207L;
        Long dragonGroupID_MY_1 = 768610859L;
        Long dragonGroupID_MY_2 = 1036113904L;
        Long dragonGroupID_MY_3 = 556136295L;
        boolean isDragonDetect_YM_1 = userIdBox.equals(dragonUerID_YM) && groupIdBox.equals(dragonGroupID_YM_1);
        boolean isDragonDetect_YM_2 = userIdBox.equals(dragonUerID_YM) && groupIdBox.equals(dragonGroupID_YM_2);
        boolean isDragonDetect_MY_1 = userIdBox.equals(dragonUerID_MY) && groupIdBox.equals(dragonGroupID_MY_1);
        boolean isDragonDetect_MY_2 = userIdBox.equals(dragonUerID_MY) && groupIdBox.equals(dragonGroupID_MY_2);
        boolean isDragonDetect_MY_3 = userIdBox.equals(dragonUerID_MY) && groupIdBox.equals(dragonGroupID_MY_3);

        System.out.println("侦测到[云妹]发言1： "+ (isDragonDetect_YM_1 ? "是" : "否"));
        System.out.println("侦测到[云妹]发言2： "+ (isDragonDetect_YM_2 ? "是" : "否"));
        System.out.println("侦测到[美羽]发言： "+ (isDragonDetect_MY_3 ? "是" : "否"));

//        if(isDragonDetect_YM) {
//            luminaRequireSetup = new LuminaRequireSetup();
//            luminaRequireSetup.setHybridRespondMap(new HashMap<String, List<String>>());
//
//            courierX.sendMultiTextMessages(bot, event, luminaRequireSetup);
//        }

        //  测试区
        LuminaRequireSetup luminaRequireSetup_temp1 = new LuminaRequireSetup();
        List<String> dragonCounter_OtherKeywordList = new ArrayList<>();
        Map<String, List<String>> dragonCounter_HybridMessageMap = new HashMap<>();
        //  文字表 回复哪些内容，一行文字站一个下标
        List<String> dragonCounter_TextList4Map = new ArrayList<>();
        //  图片地址表 回复的图片有哪些，一张图片占用一个下标
        List<String> dragonCounter_ImageList4Map = new ArrayList<>();
        //  是否需要检测艾特露米娜
        luminaRequireSetup_temp1.setRequireAtLumina(false);
        //  [不需要以回答形式，以普通消息发出] 需要以艾特回复对方吗/需要使用回复框回复对方吗
        luminaRequireSetup_temp1.setRequireRespAt(false);
        luminaRequireSetup_temp1.setRequireRespReply(false);
        dragonCounter_TextList4Map.add("[RosettaBot-云妹侦测模块] \n侦测到云妹在水群");
        dragonCounter_TextList4Map.add("云妹同学，美羽提醒你：\n 今天的灰打完了？\n 天气不错，运动了吗？\n 不要找借口，赶紧去运动！\n 日语学到哪里了，五十音图背完了？");
        dragonCounter_HybridMessageMap.put(RETURN_TEXT, dragonCounter_TextList4Map);
        dragonCounter_HybridMessageMap.put(RETURN_IMAGE, dragonCounter_ImageList4Map);
        //  构造的参数包装统一设定
        luminaRequireSetup_temp1.setOtherKeywordList(dragonCounter_OtherKeywordList);
        luminaRequireSetup_temp1.setHybridRespondMap(dragonCounter_HybridMessageMap);

        if(isDragonDetect_YM_1 || isDragonDetect_YM_2) {
            courierX.sendMultiTextMessages(bot, event, luminaRequireSetup_temp1);
        }

        if(isDragonDetect_MY_3) {
            courierX.sendMultiTextMessages(bot, event, luminaRequireSetup);
        }

//        if(luminaRequireSetup.getHybridRespondMap() != null) {
//            List<String> textList = luminaRequireSetup.getHybridRespondMap().get(RETURN_TEXT);
//            List<String> imageList = luminaRequireSetup.getHybridRespondMap().get(RETURN_IMAGE);
//            //  构建返回的文字消息 序号[1]
//
//
//            //  构建返回的图片消息 序号[1]
//
//
//            //  构建返回的文字消息 序号[2]
//
//
//            //  构建返回的图片消息 序号[2]
//
//
//        }

    }

}
