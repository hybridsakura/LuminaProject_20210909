package com.hybridsakura.project.plugins;

import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class MiyakoGroupPlugin extends BotPlugin {

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event) {

        //  获取群号
        long userId = event.getUserId();
        long groupId = event.getGroupId();
        String rawMessage = event.getRawMessage();
        System.out.println("1[AI-LM][UserID/用户QQ号] " + userId);
        System.out.println("1[AI-LM][GroupID/QQ群号] " + groupId);
        System.out.println("1[AI-LM][RawMessage/原始消息] " + rawMessage);

        //  装箱操作
        Long userIdBox = userId;
        Long groupIdBox = groupId;

        //  构建消息
        Msg msg1 = Msg.builder()
                .text("露米娜应答测试： \n")
                .at(userId).text(" 你好，我是露米娜-心音！")
                .image("https://i.loli.net/2021/08/30/6Jf1RWQVBaCDmS3.png");

        Date date = new Date();
        Msg msg2 = Msg.builder()
                .reply(event.getMessageId()).at(userId).text(" 你好，我是心音 LuminaRobot目前运行中...\n")
                .text("new Date() = "+date);

        Msg msgLevel_0 = Msg.builder()
//                .text("[msgLevel_0]= \n")
                .reply(event.getMessageId()).at(userId).text(" 抽中了大吉！");
        Msg msgLevel_1 = Msg.builder()
//                .text("[msgLevel_1]= \n")
                .reply(event.getMessageId()).at(userId).text(" 抽中了中吉！");
        Msg msgLevel_2 = Msg.builder()
//                .text("[msgLevel_2]= \n")
                .reply(event.getMessageId()).at(userId).text(" 抽中了木吉！（欸？）");
        Msg msgLevel_3 = Msg.builder()
//                .text("[msgLevel_3]= \n")
                .reply(event.getMessageId()).at(userId).text(" 抽中了凶！摸摸头~");
        Msg msgLevel_4 = Msg.builder()
//                .text("[msgLevel_4]= \n")
                .reply(event.getMessageId()).at(userId).text(" 抽中了大凶！呜哇！喵都发火了！");

        Msg publicMessage_1_1 = Msg.builder()
                .reply(event.getMessageId()).at(userId).text("欸嘿嘿，被摸耳朵了！");
        Msg publicMessage_1_2 = Msg.builder()
                .reply(event.getMessageId()).at(userId).text("欸嘿嘿，被摸头了！");
        Msg publicMessage_1_3 = Msg.builder()
                .reply(event.getMessageId()).at(userId).text("抱抱！");
        Msg publicMessage_2_1 = Msg.builder()
                .reply(event.getMessageId()).at(userId).text("az \n")
                .text("那就。。。抱住蹭蹭！（喵呜~喵呜~）");
        Msg publicMessage_2_2 = Msg.builder()
                .reply(event.getMessageId()).at(userId)
                .text("咱。。。咱不认识你的说（躲远远）");

        Msg publicMessage_3 = Msg.builder()
                .reply(event.getMessageId()).at(userId)
                .text("咱在的，程序目前运行中");


        //  构建判断标识
        boolean atLumina_raw = rawMessage.contains("<at qq=\"2792556795\"/>");
        boolean atLumina_miyako = rawMessage.contains("@女神转生的喵都厨");
        boolean atLumina_lm = rawMessage.contains("@lumina");
        boolean atLumina_lm_1 = rawMessage.contains("@luminabot");
        boolean findStringGacha = rawMessage.contains("抽签");
        boolean userID_Master = userId == 179223207 || userId == 1209237247 || userId == 1053310366 || userId == 1354169744 || userId == 1317274709 || userId == 1679619685 || userId == 1761133869;

        Random r = new Random(new Date().getTime());
        int ran = r.nextInt(100);
        //  随机化

        boolean inRangeA = ran >= 80;
        boolean inRangeB = ran < 80 && ran >= 60;
        boolean inRangeC = ran < 60 && ran >= 40;
        boolean inRangeD = ran < 40 && ran >= 20;
        boolean inRangeE = ran <= 19 && ran > 0;


        //  构建消息并发出
        if (rawMessage.contains("心音，收到请回答")) {
            bot.sendGroupMsg(groupId, msg1, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm || atLumina_lm_1) && inRangeA && findStringGacha) {
            bot.sendGroupMsg(groupId, msgLevel_0, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm || atLumina_lm_1) && inRangeB && findStringGacha) {
            bot.sendGroupMsg(groupId, msgLevel_1, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm || atLumina_lm_1) && inRangeC && findStringGacha) {
            bot.sendGroupMsg(groupId, msgLevel_2, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm || atLumina_lm_1) && inRangeD && findStringGacha) {
            bot.sendGroupMsg(groupId, msgLevel_3, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm || atLumina_lm_1) && inRangeE && findStringGacha) {
            bot.sendGroupMsg(groupId, msgLevel_4, false);
        }

        if((atLumina_raw || atLumina_miyako || atLumina_lm) && (rawMessage.contains("摸摸猫耳朵") || rawMessage.contains("摸摸耳朵"))) {
            bot.sendGroupMsg(groupId, publicMessage_1_1, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && rawMessage.contains("摸摸头")) {
            bot.sendGroupMsg(groupId, publicMessage_1_2, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && rawMessage.contains("摸摸")) {
            bot.sendGroupMsg(groupId, publicMessage_1_3, false);
        } else if((rawMessage.contains("露米娜") || rawMessage.contains("心音")) && rawMessage.contains("在吗")) {
            bot.sendGroupMsg(groupId, publicMessage_3, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && rawMessage.contains("lumina-test")) {
            bot.sendGroupMsg(groupId, msg2, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && userID_Master && (rawMessage.contains("老婆！") || rawMessage.contains("老婆"))) {
            bot.sendGroupMsg(groupId, publicMessage_2_1, false);
        } else if((atLumina_raw || atLumina_miyako || atLumina_lm) && rawMessage.contains("老婆！")) {
            bot.sendGroupMsg(groupId, publicMessage_2_2, false);
        }

//        else if((atLumina_raw || atLumina_miyako) && findStringGacha && userIdBox == 179223207) {
//            bot.sendGroupMsg(groupId, msgLevel_4, false);
//        }else if((atLumina_raw || atLumina_miyako) && findStringGacha) {
//            bot.sendGroupMsg(groupId, msgLevel_0, false);
//        }

        return MESSAGE_IGNORE;
    }
}
