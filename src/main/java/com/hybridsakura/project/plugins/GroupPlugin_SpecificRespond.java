package com.hybridsakura.project.plugins;

import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import com.hybridsakura.project.app.luminabot.helper.LuminaSender_DragonCounter;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hybridsakura.project.common.LuminaCommon.RETURN_IMAGE;
import static com.hybridsakura.project.common.LuminaCommon.RETURN_TEXT;

@SuppressWarnings("DuplicatedCode")
@Component
public class GroupPlugin_SpecificRespond extends BotPlugin {

//    LuminaPluginHelper pluginHelper = new LuminaPluginHelper();
    LuminaSender_DragonCounter app_dragonCounter = new LuminaSender_DragonCounter();

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {
        //  [0 S0_2109060950]
        LuminaRequireSetup dragonCounter = new LuminaRequireSetup();
        List<String> dragonCounter_OtherKeywordList = new ArrayList<>();
        Map<String, List<String>> dragonCounter_HybridMessageMap = new HashMap<>();
        //  文字表 回复哪些内容，一行文字站一个下标
        List<String> dragonCounter_TextList4Map = new ArrayList<>();
        //  图片地址表 回复的图片有哪些，一张图片占用一个下标
        List<String> dragonCounter_ImageList4Map = new ArrayList<>();
        //  [不需要关键字] 构造关键字匹配
//        dragonCounter.setMasterKeyword("");
//        dragonCounter.setRequireKeywordMatch(false);
//        dragonCounter.setSecondKeyword("");
//        dragonCounter_OtherKeywordList.add("一键");
        //  是否需要检测艾特露米娜
        dragonCounter.setRequireAtLumina(false);
        //  [不需要以回答形式，以普通消息发出] 需要以艾特回复对方吗/需要使用回复框回复对方吗
        dragonCounter.setRequireRespAt(false);
        dragonCounter.setRequireRespReply(false);
        //  构造回复信息
        dragonCounter_TextList4Map.add("[LuminaBot-龙王反制模块] 侦测到龙王发言");
        dragonCounter_TextList4Map.add("云妹今天学习了吗？");
        dragonCounter_TextList4Map.add("云妹今天锻炼了吗？");
        dragonCounter_TextList4Map.add("云妹别水群了，快去努力学努力练！");
//        dragonCounter_ImageList4Map.add("/image/1");
        dragonCounter_HybridMessageMap.put(RETURN_TEXT, dragonCounter_TextList4Map);
        dragonCounter_HybridMessageMap.put(RETURN_IMAGE, dragonCounter_ImageList4Map);
        //  构造的参数包装统一设定
        dragonCounter.setOtherKeywordList(dragonCounter_OtherKeywordList);
        dragonCounter.setHybridRespondMap(dragonCounter_HybridMessageMap);
        //  调用方法发送消息
        app_dragonCounter.sendCounterMessage(bot, event, dragonCounter);
        return MESSAGE_IGNORE;
    }

}
