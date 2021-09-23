package com.hybridsakura.project.app.luminabot.helper;

import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import net.lz1998.pbbot.bot.Bot;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.hybridsakura.project.common.LuminaCommon.RETURN_IMAGE;
import static com.hybridsakura.project.common.LuminaCommon.RETURN_TEXT;

public class LuminaSender_DragonCounter {

    LuminaSender_CourierX courierX = new LuminaSender_CourierX();

    //  龙王反制装置：对指定群聊的指定QQ号进行龙王反制
    public void sendCounterMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaRequireSetup luminaRequireSetup) {

        //  获取群号
        System.out.println("龙王反制模块 [AI-LM][UserID/用户QQ号] " + event.getUserId());
        System.out.println("龙王反制模块 [AI-LM][GroupID/QQ群号] " + event.getGroupId());
        System.out.println("龙王反制模块 [AI-LM][RawMessage/原始消息] " + event.getRawMessage());
        //  装箱操作
        Long userIdBox = event.getUserId();
        Long groupIdBox = event.getGroupId();
        //  定义龙王所在群聊
//        Long dragonUerID = 1317274709L;
//        Long dragonGroupID = 1036113904L;
        Long dragonUerID = 179223207L;
        Long dragonGroupID = 768610859L;
        boolean isDragonDetect = userIdBox.equals(dragonUerID) && groupIdBox.equals(dragonGroupID);

        System.out.println("侦测到龙王发言： "+ (isDragonDetect ? "是" : "否"));


        if(isDragonDetect) {
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
