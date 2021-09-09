package com.hybridsakura.project.plugins;

import com.hybridsakura.project.app.luminabot.extra.LuminaGacha;
import com.hybridsakura.project.app.luminabot.helper.LuminaPrebuild;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import com.hybridsakura.project.app.luminabot.helper.LuminaPluginHelper;
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
public class LuminaGroupPlugin extends BotPlugin {

    LuminaPluginHelper pluginHelper = new LuminaPluginHelper();
    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();
    LuminaGacha luminaGacha = new LuminaGacha();

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        //  [0]首次测试部分
        LuminaRequireSetup lumina_EmptyMessageWithAt = new LuminaRequireSetup();            //
        //  构造关键字匹配
        lumina_EmptyMessageWithAt.setMasterKeyword("心音");
        lumina_EmptyMessageWithAt.setRequireKeywordMatch(false);
        lumina_EmptyMessageWithAt.setSecondKeyword("在吗");
        List<String> otherKeyword = new ArrayList<>();
        otherKeyword.add("状态报告");
        otherKeyword.add("查询状态");
        lumina_EmptyMessageWithAt.setOtherKeywordList(otherKeyword);
        //  是否需要检测艾特露米娜
        lumina_EmptyMessageWithAt.setRequireAtLumina(false);
        //  构造回复信息
        Map<String, List<String>> hybridMessageMap_S0 = new HashMap<>();
        List<String> loadedReturnText_S0 = new ArrayList<>();                               //  文字表 回复哪些内容，一行文字站一个下标
        List<String> loadedReturnImage_S0 = new ArrayList<>();                              //  图片地址表 回复的图片有哪些，一张图片占用一个下标
        loadedReturnText_S0.add("咱是心音，程序已处于运行中");                                  //
        loadedReturnImage_S0.add("/image/1");                                               //
        hybridMessageMap_S0.put("return-text", loadedReturnText_S0);
        hybridMessageMap_S0.put("return-image", loadedReturnImage_S0);
        lumina_EmptyMessageWithAt.setHybridRespondMap(hybridMessageMap_S0);
        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
        lumina_EmptyMessageWithAt.setRequireRespAt(false);
        lumina_EmptyMessageWithAt.setRequireRespReply(true);

        pluginHelper.sendBasicMessage(bot, event, lumina_EmptyMessageWithAt);

        //  [0 S0_2109060924]
        LuminaRequireSetup lumina_Setup2109060924 = new LuminaRequireSetup();            //
        //  构造关键字匹配
        lumina_Setup2109060924.setMasterKeyword("心音");
        lumina_Setup2109060924.setSecondKeyword("");
        List<String> otherKeyword_S0_2109060924 = new ArrayList<>();
        otherKeyword_S0_2109060924.add("是谁");
        otherKeyword_S0_2109060924.add("是什么");
        otherKeyword_S0_2109060924.add("机器人");
        lumina_Setup2109060924.setOtherKeywordList(otherKeyword_S0_2109060924);
        //  是否需要检测艾特露米娜
        lumina_Setup2109060924.setRequireAtLumina(false);
        //  构造回复信息
        Map<String, List<String>> hybridMessageMap_S0_2109060924 = new HashMap<>();
        List<String> loadedReturnText_S0_2109060924 = new ArrayList<>();                               //  文字表 回复哪些内容，一行文字站一个下标
        List<String> loadedReturnImage_S0_2109060924 = new ArrayList<>();                              //  图片地址表 回复的图片有哪些，一张图片占用一个下标
        loadedReturnText_S0_2109060924.add("咱是心音，是美羽姐姐做的喵都机器人哦！");                                  //
        loadedReturnImage_S0_2109060924.add("/image/1");                                               //
        hybridMessageMap_S0_2109060924.put(RETURN_TEXT, loadedReturnText_S0_2109060924);
        hybridMessageMap_S0_2109060924.put(RETURN_IMAGE, loadedReturnImage_S0_2109060924);
        lumina_Setup2109060924.setHybridRespondMap(hybridMessageMap_S0_2109060924);
        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
        lumina_Setup2109060924.setRequireRespAt(false);
        lumina_Setup2109060924.setRequireRespReply(true);

        pluginHelper.sendBasicMessage(bot, event, lumina_Setup2109060924);


        //  [0 S0_2109060950]
        LuminaRequireSetup lumina_Setup2109060950 = new LuminaRequireSetup();
        List<String> otherKeyword_S0_2109060950 = new ArrayList<>();
        Map<String, List<String>> hybridMessageMap_S0_2109060950 = new HashMap<>();
        //  文字表 回复哪些内容，一行文字站一个下标
        List<String> loadedReturnText_S0_2109060950 = new ArrayList<>();
        //  图片地址表 回复的图片有哪些，一张图片占用一个下标
        List<String> loadedReturnImage_S0_2109060950 = new ArrayList<>();
        //  构造关键字匹配
        lumina_Setup2109060950.setMasterKeyword("喵都叫");
        lumina_EmptyMessageWithAt.setRequireKeywordMatch(false);
        lumina_Setup2109060950.setSecondKeyword("");
        otherKeyword_S0_2109060950.add("一键");
        //  是否需要检测艾特露米娜
        lumina_Setup2109060950.setRequireAtLumina(false);
        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
        lumina_Setup2109060950.setRequireRespAt(false);
        lumina_Setup2109060950.setRequireRespReply(true);
        //  构造回复信息
        loadedReturnText_S0_2109060950.add("瞄~（喵都叫）");
        loadedReturnText_S0_2109060950.add("瞄~（喵都叫）");
        loadedReturnText_S0_2109060950.add("瞄~（喵都叫）");
        loadedReturnImage_S0_2109060950.add("/image/1");
        hybridMessageMap_S0_2109060950.put(RETURN_TEXT, loadedReturnText_S0_2109060950);
        hybridMessageMap_S0_2109060950.put(RETURN_IMAGE, loadedReturnImage_S0_2109060950);
        //  构造的参数包装统一设定
        lumina_Setup2109060950.setOtherKeywordList(otherKeyword_S0_2109060950);
        lumina_Setup2109060950.setHybridRespondMap(hybridMessageMap_S0_2109060950);
        //  调用方法发送消息
        pluginHelper.sendBasicMessage(bot, event, lumina_Setup2109060950);


//        List<LuminaRequireSetup> requireSetupList = new ArrayList<>();
//

        //  [1]是抽签
        LuminaRequireSetup setupGacha = new LuminaRequireSetup();
//        List<String> otherKeyword_Gacha = new ArrayList<>();
        Map<String, List<String>> hybridMessageMap_Gacha = new HashMap<>();

        //  构建回复的文字信息包装
        List<String> loadedReturnText_Gacha = new ArrayList<>();
        //  构建回复的图片信息包装
        List<String> loadedReturnImage_Gacha = new ArrayList<>();
        //  构造关键字匹配
        setupGacha.setMasterKeyword("抽签");
        setupGacha.setRequireKeywordMatch(true);
//        lumina_Setup2109061041.setSecondKeyword("");
//        otherKeyword_S0_2109061041.add("公主");
        //  是否需要检测艾特露米娜
        setupGacha.setRequireAtLumina(false);
        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
        setupGacha.setRequireRespAt(false);
        setupGacha.setRequireRespReply(true);
        //  构造回复信息
        loadedReturnText_Gacha.add(luminaGacha.gachaResultGen().get(0));
        loadedReturnImage_Gacha.add(luminaGacha.gachaResultGen().get(1));
        hybridMessageMap_Gacha.put(RETURN_TEXT, loadedReturnText_Gacha);
        hybridMessageMap_Gacha.put(RETURN_IMAGE, loadedReturnImage_Gacha);
        //  构造的参数包装统一设定
//        setupGacha.setOtherKeywordList(otherKeyword_Gacha);
        setupGacha.setHybridRespondMap(hybridMessageMap_Gacha);
        //  调用方法发送消息
        pluginHelper.sendMultiMessage(bot, event, setupGacha);


//        //  [1]是抽签
//        LuminaRequireSetup setupSequence1 = new LuminaRequireSetup();
//        //  构造map1
//        Map<String, Boolean> keywordRequireMap_S1 = new HashMap<>();
//        keywordRequireMap_S1.put("抽签", false);
//        keywordRequireMap_S1.put("抽卡", true);
//        keywordRequireMap_S1.put("此刻运势", false);
//        setupSequence1.setKeywordRequireMap(keywordRequireMap_S1);
//        //  回复时需要检测艾特露米娜吗？
//        setupSequence1.setRequireAtLumina(false);
//        //  构造map2
//        Map<String, List<String>> hybridMessageMap_S1 = new HashMap<>();
//        List<String> loadedReturnText_S1 = new ArrayList<>();                                   //  文字表 回复哪些内容，一行文字站一个下标
//        List<String> loadedReturnImage_S1 = new ArrayList<>();                                  //  图片地址表 回复的图片有哪些，一张图片占用一个下标
//        loadedReturnText_S1.add("<text_empty(no need)>");                                       //  因为不需要，抽签结果返回的文字将由其他函数、提供提供
//        loadedReturnImage_S1.add("/<image_empty(no need)>");                                    //  因为不需要，抽签结果返回的图片将由其他函数、方法提供
//        hybridMessageMap_S1.put("return-text", loadedReturnText_S1);
//        hybridMessageMap_S1.put("return-image", loadedReturnImage_S1);
//        setupSequence1.setHybridRespondMap(hybridMessageMap_S1);
//        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
//        setupSequence1.setRequireRespAt(false);
//        setupSequence1.setRequireRespReply(true);
//
//        //  [2]摸摸蹭蹭抱抱
//        LuminaRequireSetup setupSequence2 = new LuminaRequireSetup();
//
//
//        //  [3]常规消息响应 露米娜在吗
//        LuminaRequireSetup setupSequence3 = new LuminaRequireSetup();
//        //  构造map1
//        Map<String, Boolean> keywordRequireMap_S3 = new HashMap<>();
//        keywordRequireMap_S3.put("露米娜在吗", false);
//        keywordRequireMap_S3.put("心音在吗", false);
//        setupSequence3.setKeywordRequireMap(keywordRequireMap_S3);
//        //  回复时需要检测艾特露米娜吗？
//        setupSequence3.setRequireAtLumina(false);
//        //  构造map2
//        Map<String, List<String>> hybridMessageMap_S3 = new HashMap<>();
//        List<String> loadedReturnText_S3 = new ArrayList<>();                                   //  文字表 回复哪些内容，一行文字站一个下标
//        List<String> loadedReturnImage_S3 = new ArrayList<>();                                  //  图片地址表 回复的图片有哪些，一张图片占用一个下标
//        loadedReturnText_S3.add("咱在的，程序目前运行中~");                                         //
//        loadedReturnText_S3.add("目前时间："+new Date());
//        loadedReturnImage_S3.add("/image/1");
//        loadedReturnImage_S3.add("/image/2");
//        hybridMessageMap_S3.put("return-text", loadedReturnText_S3);
//        hybridMessageMap_S3.put("return-image", loadedReturnImage_S3);
//        setupSequence3.setHybridRespondMap(hybridMessageMap_S3);
//        //  需要以艾特回复对方吗/需要使用回复框回复对方吗
//        setupSequence3.setRequireRespAt(false);
//        setupSequence3.setRequireRespReply(true);
//
//        //  [4]
//        LuminaRequireSetup setupSequence4 = new LuminaRequireSetup();
//
//
//        //  [5]
//        LuminaRequireSetup setupSequence5 = new LuminaRequireSetup();
//
//
//        requireSetupList.add(setupSequence1);
//        requireSetupList.add(setupSequence2);
//        requireSetupList.add(setupSequence3);
//        requireSetupList.add(setupSequence4);
//        requireSetupList.add(setupSequence5);

//        pluginHelper.sendBundleMessageWithAt(bot, event, requireSetupList);

        return MESSAGE_IGNORE;
    }



}
