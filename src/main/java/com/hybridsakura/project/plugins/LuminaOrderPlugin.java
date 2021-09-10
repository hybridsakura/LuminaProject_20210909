package com.hybridsakura.project.plugins;

import com.hybridsakura.project.app.luminabot.helper.LuminaPrebuild;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import com.hybridsakura.project.app.luminabot.helper.LuminaPluginHelper;
import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("DuplicatedCode")
@Component
public class LuminaOrderPlugin extends BotPlugin {

    LuminaPluginHelper pluginHelper = new LuminaPluginHelper();
    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        //  [0 S0_2109060950]
        //  为新对象分配地址空间
        LuminaRequireSetup lumina_Setup2109061041 = new LuminaRequireSetup();
        List<String> otherKeyword_S0_2109061041 = new ArrayList<>();
        Map<String, List<String>> hybridMessageMap_S0_2109061041 = new HashMap<>();
        //  构建回复的文字信息包装
        List<String> loadedReturnText_S0_2109061041 = new ArrayList<>();
        //  构建回复的图片信息包装
        List<String> loadedReturnImage_S0_2109061041 = new ArrayList<>();
        //  构造关键字匹配
        lumina_Setup2109061041.setMasterKeyword("心音");
        lumina_Setup2109061041.setRequireKeywordMatch(false);
        lumina_Setup2109061041.setSecondKeyword(" /op ");
        otherKeyword_S0_2109061041.add("公主");
        otherKeyword_S0_2109061041.add("云妹");
        otherKeyword_S0_2109061041.add("伊卡");
        //  是否需要检测艾特露米娜
//        lumina_Setup2109061041.setRequireAtLumina(false);
        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
//        lumina_Setup2109061041.setRequireRespAt(false);
//        lumina_Setup2109061041.setRequireRespReply(true);
        //  构造回复信息
//        loadedReturnText_S0_2109061041.add("所选用户已设置成[luminabot]的管理员（目前无实质功能）");
//        loadedReturnImage_S0_2109061041.add("/image/1");
//        hybridMessageMap_S0_2109061041.put(RETURN_TEXT, loadedReturnText_S0_2109061041);
//        hybridMessageMap_S0_2109061041.put(RETURN_IMAGE, loadedReturnImage_S0_2109061041);
        //  构造的参数包装统一设定
//        lumina_Setup2109061041.setOtherKeywordList(otherKeyword_S0_2109061041);
//        lumina_Setup2109061041.setHybridRespondMap(hybridMessageMap_S0_2109061041);
        //  调用方法发送消息
//        pluginHelper.sendBasicMessage(bot, event, lumina_Setup2109061041);

        return MESSAGE_IGNORE;
    }



}
