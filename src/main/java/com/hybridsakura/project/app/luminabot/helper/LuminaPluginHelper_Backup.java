//package com.hybridsakura.project.app.luminabot.helper;//package net.lz1998.pbbot.helper;
//
//import net.lz1998.pbbot.bot.Bot;
//import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;
//import net.lz1998.pbbot.utils.Msg;
//import onebot.OnebotEvent;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//import java.util.Map;
//
//import static com.hybridsakura.project.common.LuminaCommon.RETURN_TEXT;
//
//
//@SuppressWarnings("DuplicatedCode")
//public class LuminaPluginHelper_Backup {
//
//    LuminaPrebuild luminaPrebuild = new LuminaPrebuild();
//    LuminaDetectHelper luminaDetectHelper = new LuminaDetectHelper();
//    LuminaCourier luminaCourier = new LuminaCourier();
//    private String RETURN_IMAGE;
//
//    public void sendBasicMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaRequireSetup luminaRequireSetup) {
//
//        //  获取群号
//        System.out.println("LuminaPluginHelper#[AI-LM][UserID/用户QQ号] " + event.getUserId());
//        System.out.println("LuminaPluginHelper#[AI-LM][GroupID/QQ群号] " + event.getGroupId());
//        System.out.println("LuminaPluginHelper#[AI-LM][RawMessage/原始消息] " + event.getRawMessage());
//        //  装箱操作
////        Long userIdBox = event.getUserId();
////        Long groupIdBox = event.getGroupId();
//
//
//        //  对消息中是否包含at露米娜的内容进行侦测
//        luminaRequireSetup = luminaPrebuild.setLuminaAtRule(luminaRequireSetup, event.getRawMessage());
//
//        //  消息状况报告
//        System.out.println("=============================");
//        System.out.println("是否要求 检测艾特露米娜：" + (luminaRequireSetup.isRequireAtLumina() ? "是":"否"));
//        System.out.println("侦测到的信息 是否艾特了露米娜：" + (luminaRequireSetup.isDetectAtLumina() ? "是":"否"));
//
//        System.out.println("要求侦测的主关键字：" + luminaRequireSetup.getMasterKeyword());
//        System.out.println("要求侦测的从关键字：" + luminaRequireSetup.getMasterKeyword());
//
//        List<String> otherKeywordList = luminaRequireSetup.getOtherKeywordList();
//        StringBuilder otherKeywordListStr;
//        otherKeywordListStr = new StringBuilder();
//        int count = 0;
//        for(String s : otherKeywordList) {
//            count += 1;
//            otherKeywordListStr.append("[OtherKeyword#").append(count).append("=").append(s).append("]");
//        }
//        System.out.println("要求匹配的其他关键字:" + otherKeywordListStr);
//        System.out.println("侦测到的信息 全字匹配要求：" + (luminaRequireSetup.isRequireKeywordMatch() ? "是":"否"));
//        System.out.println("回复时 使用回复框回复对话：" + (luminaRequireSetup.isRequireRespReply() ? "是":"否"));
//        System.out.println("回复时 对对方进行艾特操作：" + (luminaRequireSetup.isRequireRespAt() ? "是":"否"));
//        System.out.println("=============================");
////
//        boolean atDetectAndRequire = luminaRequireSetup.isRequireAtLumina() && luminaRequireSetup.isDetectAtLumina();
//        boolean atNotDetect = !luminaRequireSetup.isDetectAtLumina();
//        boolean matchedKeyword = luminaDetectHelper.checkDetectMainKeyword(event.getRawMessage(), luminaRequireSetup.getMasterKeyword(), luminaRequireSetup.getSecondKeyword(), luminaRequireSetup.isRequireKeywordMatch());
//        //  测试区 测试完需删除
//        boolean otherKeywordListMatched = luminaDetectHelper.checkDetectOtherKeywordList(event.getRawMessage(), luminaRequireSetup.getOtherKeywordList());
//
//        System.out.println("Master和Second其中一个匹配？" + (matchedKeyword ? "是" : "否"));
//        System.out.println("OtherKeyword其中一个匹配？" + (otherKeywordListMatched ? "是" : "否"));
//
//        Map<String, List<String>> tempMap = luminaRequireSetup.getHybridRespondMap();
//        List<String> listText = tempMap.get(RETURN_TEXT);
//        List<String> textImage = tempMap.get(RETURN_IMAGE);
//
//
//        Msg msg_running;
//        if(luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.getRawMessage(), luminaRequireSetup.getOtherKeywordList())) {
////            msg_running = Msg.builder()
////                    .reply(event.getMessageId())
////                    .text(listText.get(0));
//            bot.sendGroupMsg(event.getGroupId(), luminaCourier.buildBasicReplyMessage(event, listText), false);
//        } else if(!luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.getRawMessage(), luminaRequireSetup.getOtherKeywordList())){
////            msg_running = Msg.builder()
////                    .at(event.getUserId())
////                    .text(listText.get(0));
//            bot.sendGroupMsg(event.getGroupId(), luminaCourier.buildBasicAtUserMessage(event, listText), false);
//        }
////        bot.sendGroupMsg(event.getGroupId(), Msg.builder().reply(event.getMessageId()).text("lumina-factory-test"), false);
//    }
//
//    public void sendMultiMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, LuminaRequireSetup luminaRequireSetup) {
//
//        //  获取群号
//        System.out.println("LuminaPluginHelper#[AI-LM][UserID/用户QQ号] " + event.getUserId());
//        System.out.println("LuminaPluginHelper#[AI-LM][GroupID/QQ群号] " + event.getGroupId());
//        System.out.println("LuminaPluginHelper#[AI-LM][RawMessage/原始消息] " + event.getRawMessage());
//        //  装箱操作
////        Long userIdBox = event.getUserId();
////        Long groupIdBox = event.getGroupId();
//
//
//        //  对消息中是否包含at露米娜的内容进行侦测
//        luminaRequireSetup = luminaPrebuild.setLuminaAtRule(luminaRequireSetup, event.getRawMessage());
//
//        //  消息状况报告
//        System.out.println("=============================");
//        System.out.println("是否要求 检测艾特露米娜：" + (luminaRequireSetup.isRequireAtLumina() ? "是":"否"));
//        System.out.println("侦测到的信息 是否艾特了露米娜：" + (luminaRequireSetup.isDetectAtLumina() ? "是":"否"));
//
//        System.out.println("要求侦测的主关键字：" + luminaRequireSetup.getMasterKeyword());
//        System.out.println("要求侦测的从关键字：" + luminaRequireSetup.getMasterKeyword());
//
//        List<String> otherKeywordList = luminaRequireSetup.getOtherKeywordList();
//
//        if(otherKeywordList != null) {
//
//            StringBuilder otherKeywordListStr;
//            otherKeywordListStr = new StringBuilder();
//            int count = 0;
//            for(String s : otherKeywordList) {
//                count += 1;
//                otherKeywordListStr.append("[OtherKeyword#").append(count).append("=").append(s).append("]");
//            }
//            System.out.println("要求匹配的其他关键字:" + otherKeywordListStr);
//        }
//
//        System.out.println("侦测到的信息 全字匹配要求：" + (luminaRequireSetup.isRequireKeywordMatch() ? "是":"否"));
//        System.out.println("回复时 使用回复框回复对话：" + (luminaRequireSetup.isRequireRespReply() ? "是":"否"));
//        System.out.println("回复时 对对方进行艾特操作：" + (luminaRequireSetup.isRequireRespAt() ? "是":"否"));
//        System.out.println("=============================");
////
//        boolean atDetectAndRequire = luminaRequireSetup.isRequireAtLumina() && luminaRequireSetup.isDetectAtLumina();
//        boolean atNotDetect = !luminaRequireSetup.isDetectAtLumina();
//        boolean matchedKeyword = luminaDetectHelper.checkDetectMainKeyword(event.getRawMessage(), luminaRequireSetup.getMasterKeyword(), luminaRequireSetup.getSecondKeyword(), luminaRequireSetup.isRequireKeywordMatch());
//
//        System.out.println("Master和Second其中一个匹配？" + (matchedKeyword ? "是" : "否"));
//
//        //  测试区 测试完需删除
//        if(luminaRequireSetup.getOtherKeywordList() != null) {
//            boolean otherKeywordListMatched = luminaDetectHelper.checkDetectOtherKeywordList(event.getRawMessage(), luminaRequireSetup.getOtherKeywordList());
//            System.out.println("OtherKeyword其中一个匹配？" + (otherKeywordListMatched ? "是" : "否"));
//        }
//
//        Map<String, List<String>> tempMap = luminaRequireSetup.getHybridRespondMap();
//
//        if(luminaRequireSetup.getOtherKeywordList() == null) {
//            if(luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword) {
//                bot.sendGroupMsg(event.getGroupId(), luminaCourier.buildMultiReplyPairMessage(event, luminaRequireSetup.getHybridRespondMap()), false);
//            } else if(!luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.getRawMessage(), luminaRequireSetup.getOtherKeywordList())){
//                bot.sendGroupMsg(event.getGroupId(), luminaCourier.buildMultiAtUserPairMessage(event, luminaRequireSetup.getHybridRespondMap()), false);
//            }
//        }else {
//            if(luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.getRawMessage(), luminaRequireSetup.getOtherKeywordList())) {
//                bot.sendGroupMsg(event.getGroupId(), luminaCourier.buildMultiReplyPairMessage(event, luminaRequireSetup.getHybridRespondMap()), false);
//            } else if(!luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.getRawMessage(), luminaRequireSetup.getOtherKeywordList())){
//                bot.sendGroupMsg(event.getGroupId(), luminaCourier.buildMultiAtUserPairMessage(event, luminaRequireSetup.getHybridRespondMap()), false);
//            }
//        }
//
//    }
//
//
//
//
//
//}
