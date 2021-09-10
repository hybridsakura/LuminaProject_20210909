package com.hybridsakura.project.plugins;

import com.hybridsakura.project.app.luminabot.extra.LuminaGacha;
import com.hybridsakura.project.app.luminabot.helper.LuminaPluginHelper;
import com.hybridsakura.project.app.luminabot.helper.LuminaPrebuild;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;
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
public class MinecraftGroupPlugin extends BotPlugin {

    LuminaPluginHelper pluginHelper = new LuminaPluginHelper();
    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();
    LuminaGacha luminaGacha = new LuminaGacha();

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        //  [0 S0_2109060950]
        LuminaRequireSetup lumina_MinecraftTest = new LuminaRequireSetup();
        List<String> otherKeyword_MinecraftTest = new ArrayList<>();
        Map<String, List<String>> hybridMessageMap_MinecraftTest = new HashMap<>();
        //  文字表 回复哪些内容，一行文字站一个下标
        List<String> loadedReturnText_MinecraftTest = new ArrayList<>();
        //  图片地址表 回复的图片有哪些，一张图片占用一个下标
        List<String> loadedReturnImage_MinecraftTest = new ArrayList<>();
        //  构造关键字匹配
        lumina_MinecraftTest.setMasterKeyword("喵都叫");
        lumina_MinecraftTest.setRequireKeywordMatch(false);
        lumina_MinecraftTest.setSecondKeyword("");
        otherKeyword_MinecraftTest.add("一键");
        //  是否需要检测艾特露米娜
        lumina_MinecraftTest.setRequireAtLumina(false);
        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
        lumina_MinecraftTest.setRequireRespAt(false);
        lumina_MinecraftTest.setRequireRespReply(true);
        //  构造回复信息
        loadedReturnText_MinecraftTest.add("瞄~（喵都叫）");
        loadedReturnText_MinecraftTest.add("瞄~（喵都叫）");
        loadedReturnText_MinecraftTest.add("瞄~（喵都叫）");
        loadedReturnImage_MinecraftTest.add("/image/1");
        hybridMessageMap_MinecraftTest.put(RETURN_TEXT, loadedReturnText_MinecraftTest);
        hybridMessageMap_MinecraftTest.put(RETURN_IMAGE, loadedReturnImage_MinecraftTest);
        //  构造的参数包装统一设定
        lumina_MinecraftTest.setOtherKeywordList(otherKeyword_MinecraftTest);
        lumina_MinecraftTest.setHybridRespondMap(hybridMessageMap_MinecraftTest);
        //  调用方法发送消息
        pluginHelper.sendBasicMessage(bot, event, lumina_MinecraftTest);

        return MESSAGE_IGNORE;
    }
}
