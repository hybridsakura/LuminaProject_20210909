package com.hybridsakura.project.plugins;

import com.hybridsakura.project.app.luminabot.helper.LuminaSender_LuminaRobot;
import com.hybridsakura.project.app.minecraft.entity.FlexibleParams;
import com.hybridsakura.project.app.minecraft.entity.MinecraftCoordinate;
import com.hybridsakura.project.app.minecraft.function.LuminaEngine;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
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
public class GroupPlugin_Minecraft extends BotPlugin {

    LuminaSender_LuminaRobot pluginHelper = new LuminaSender_LuminaRobot();
    LuminaEngine luminaEngine = new LuminaEngine();

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
        lumina_MinecraftTest.setMasterKeyword("心音");
        lumina_MinecraftTest.setRequireKeywordMatch(false);
        lumina_MinecraftTest.setSecondKeyword(" MC代码生成测试 ");
//        otherKeyword_MinecraftTest.add("");
        //  是否需要检测艾特露米娜
        lumina_MinecraftTest.setRequireAtLumina(false);
        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
        lumina_MinecraftTest.setRequireRespAt(false);
        lumina_MinecraftTest.setRequireRespReply(true);

        MinecraftCoordinate coordinate5 = new MinecraftCoordinate(-150, 76, -433);
        FlexibleParams flexibleParams_4 = new FlexibleParams();
        flexibleParams_4.setSequenceName("[lumina-basics]");
        luminaEngine.LuminaMasterSequence(null, coordinate5, flexibleParams_4);

        //  构造回复信息
        loadedReturnText_MinecraftTest.add("喵喵喵？");
        loadedReturnText_MinecraftTest.add("已执行，请查看控制台");
        hybridMessageMap_MinecraftTest.put(RETURN_TEXT, loadedReturnText_MinecraftTest);
        hybridMessageMap_MinecraftTest.put(RETURN_IMAGE, loadedReturnImage_MinecraftTest);
        //  构造的参数包装统一设定
        lumina_MinecraftTest.setOtherKeywordList(otherKeyword_MinecraftTest);
        lumina_MinecraftTest.setHybridRespondMap(hybridMessageMap_MinecraftTest);
        //  调用方法发送消息
        pluginHelper.sendBasicMessage(bot, event, lumina_MinecraftTest);



        //  1
//        MinecraftCoordinate coordinateUnit1 = new MinecraftCoordinate(2600 ,69 ,686);
//        MinecraftCoordinate coordinateUnit2 = new MinecraftCoordinate(2216, 69 ,695);
//        MinecraftCoordinatePair coordinatePair = new MinecraftCoordinatePair(coordinateUnit1, coordinateUnit2);
//
//        LuminaBridgeBuilder luminaBridgeBuilder = new LuminaBridgeBuilder();
//        FlexibleParams flexibleParams_1 = new FlexibleParams();
//        flexibleParams_1.setSequenceName("[lumina-bridge]");
//        flexibleParams_1.setWidth(3);
//
//        luminaEngine.LuminaMasterSequence(coordinatePair, null, flexibleParams_1);


        //  2
//        MinecraftCoordinate coordinate1 = new MinecraftCoordinate(1718, 63, 8);
//
//        FlexibleParams flexibleParams_2 = new FlexibleParams();
//        flexibleParams_2.setSequenceName("[lumina-beacon]");
//        flexibleParams_2.setDirectionCode("AXIS-HOLD-Y");
//
//        luminaEngine.LuminaMasterSequence(null, coordinate1, flexibleParams_2);

        //  3
//        MinecraftCoordinate coordinate2 = new MinecraftCoordinate(-416, 80, -246);
//        MinecraftCoordinate coordinate3 = new MinecraftCoordinate(-489, 50, -234);

//        MinecraftCoordinate coordinate3 = new MinecraftCoordinate(-489, 50, -234);
//        MinecraftCoordinate coordinate2 = new MinecraftCoordinate(1209, 56, 4);
//        MinecraftCoordinate coordinate3 = new MinecraftCoordinate(1309, 56, -2);
//        MinecraftCoordinatePair coordinatePair2 = new MinecraftCoordinatePair(coordinate2, coordinate3);
//        FlexibleParams flexibleParams_3 = new FlexibleParams();
//        flexibleParams_3.setSequenceName("[lumina-tunnel]");
//        luminaEngine.LuminaMasterSequence(coordinatePair2, null, flexibleParams_3);

        //  4
//        MinecraftCoordinate coordinate5 = new MinecraftCoordinate(-150, 76, -433);
//        FlexibleParams flexibleParams_4 = new FlexibleParams();
//        flexibleParams_4.setSequenceName("[lumina-basics]");
//        luminaEngine.LuminaMasterSequence(null, coordinate5, flexibleParams_4);

        return MESSAGE_IGNORE;
    }
}
