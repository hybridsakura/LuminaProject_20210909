package com.hybridsakura.project.plugins;

import com.hybridsakura.project.app.luminabot.helper.LuminaSender_CourierX;
import com.hybridsakura.project.app.luminabot.helper.LuminaSender_LuminaRobot;
import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.function.LuminaEngine;
import com.hybridsakura.project.app.minecraft.helper.BotHelper_Minecraft;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import onebot.OnebotEvent;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
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
public class GroupPlugin_Minecraft extends BotPlugin {

    LuminaSender_LuminaRobot pluginHelper = new LuminaSender_LuminaRobot();
    BotHelper_Minecraft minecraft = new BotHelper_Minecraft();
    LuminaSender_CourierX courierX = new LuminaSender_CourierX();

    @SuppressWarnings("ConstantConditions")
    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        boolean requireAtLumina = true;

        List<String> orderList = new ArrayList<>();
        if(minecraft.analyseStringX(event.getRawMessage(), requireAtLumina) != null) {
            orderList = minecraft.analyseStringX(event.getRawMessage(), requireAtLumina);

            //  [0 S0_2109060950]
            LuminaRequireSetup lumina_MinecraftTest = new LuminaRequireSetup();
            List<String> otherKeyword_MinecraftTest = new ArrayList<>();
            Map<String, List<String>> hybridMessageMap_MinecraftTest = new HashMap<>();
            //  文字表 回复哪些内容，一行文字站一个下标
            //  图片地址表 回复的图片有哪些，一张图片占用一个下标
            List<String> loadedReturnImage_MinecraftTest = new ArrayList<>();
            //  构造关键字匹配
            lumina_MinecraftTest.setMasterKeyword("坐标处理");
            lumina_MinecraftTest.setRequireKeywordMatch(false);
//        lumina_MinecraftTest.setSecondKeyword("  ");
//        otherKeyword_MinecraftTest.add("");
            //  是否需要检测艾特露米娜
            lumina_MinecraftTest.setRequireAtLumina(requireAtLumina);
            //  需要以艾特回复对方吗/需要使用回复框回复对方吗
            lumina_MinecraftTest.setRequireRespAt(false);
            lumina_MinecraftTest.setRequireRespReply(false);

            //  构造回复信息
//        System.out.println(orderList);
            List<String> loadedReturnText_MinecraftTest = new ArrayList<>(orderList);
            hybridMessageMap_MinecraftTest.put(RETURN_TEXT, loadedReturnText_MinecraftTest);
            hybridMessageMap_MinecraftTest.put(RETURN_IMAGE, loadedReturnImage_MinecraftTest);
            //  构造的参数包装统一设定
            lumina_MinecraftTest.setOtherKeywordList(otherKeyword_MinecraftTest);
            lumina_MinecraftTest.setHybridRespondMap(hybridMessageMap_MinecraftTest);
            //  调用方法发送消息
            courierX.sendTextMessages(bot, event, lumina_MinecraftTest);
        } else {
            System.out.println("侦测到消息不符合设定的策略，计算已跳过 ");
        }
        return MESSAGE_IGNORE;
    }
}
