package com.hybridsakura.project.app.luminabot.helper

import com.hybridsakura.project.common.LuminaCommon
import net.lz1998.pbbot.bot.Bot
import net.lz1998.pbbot.helper.entity.LuminaRequireSetup
import net.lz1998.pbbot.utils.Msg
import onebot.OnebotEvent.GroupMessageEvent

class LuminaPluginHelper {
    var luminaPrebuild = LuminaPrebuild()
    var luminaDetectHelper = LuminaDetectHelper()
    var luminaCourier = LuminaCourier()
    fun sendBasicMessage(bot: Bot, event: GroupMessageEvent, luminaRequireSetup: LuminaRequireSetup) {

        //  获取群号
        var luminaRequireSetup = luminaRequireSetup
        println("LuminaPluginHelper#[AI-LM][UserID/用户QQ号] " + event.userId)
        println("LuminaPluginHelper#[AI-LM][GroupID/QQ群号] " + event.groupId)
        println("LuminaPluginHelper#[AI-LM][RawMessage/原始消息] " + event.rawMessage)
        //  装箱操作
//        Long userIdBox = event.getUserId();
//        Long groupIdBox = event.getGroupId();


        //  对消息中是否包含at露米娜的内容进行侦测
        luminaRequireSetup = luminaPrebuild.setLuminaAtRule(luminaRequireSetup, event.rawMessage)

        //  消息状况报告
        println("=============================")
        println("是否要求 检测艾特露米娜：" + if (luminaRequireSetup.isRequireAtLumina) "是" else "否")
        println("侦测到的信息 是否艾特了露米娜：" + if (luminaRequireSetup.isDetectAtLumina) "是" else "否")
        println("要求侦测的主关键字：" + luminaRequireSetup.masterKeyword)
        println("要求侦测的从关键字：" + luminaRequireSetup.masterKeyword)
        val otherKeywordList = luminaRequireSetup.otherKeywordList
        val otherKeywordListStr: StringBuilder
        otherKeywordListStr = StringBuilder()
        var count = 0
        for (s in otherKeywordList!!) {
            count += 1
            otherKeywordListStr.append("[OtherKeyword#").append(count).append("=").append(s).append("]")
        }
        println("要求匹配的其他关键字:$otherKeywordListStr")
        println("侦测到的信息 全字匹配要求：" + if (luminaRequireSetup.isRequireKeywordMatch) "是" else "否")
        println("回复时 使用回复框回复对话：" + if (luminaRequireSetup.isRequireRespReply()) "是" else "否")
        println("回复时 对对方进行艾特操作：" + if (luminaRequireSetup.isRequireRespAt()) "是" else "否")
        println("=============================")
        //
        val atDetectAndRequire = luminaRequireSetup.isRequireAtLumina && luminaRequireSetup.isDetectAtLumina
        val atNotDetect = !luminaRequireSetup.isDetectAtLumina
        val matchedKeyword = luminaDetectHelper.checkDetectMainKeyword(event.rawMessage, luminaRequireSetup.masterKeyword!!, luminaRequireSetup.secondKeyword, luminaRequireSetup.isRequireKeywordMatch)
        //  测试区 测试完需删除
        val otherKeywordListMatched = luminaDetectHelper.checkDetectOtherKeywordList(event.rawMessage, luminaRequireSetup.otherKeywordList!!)
        println("Master和Second其中一个匹配？" + if (matchedKeyword) "是" else "否")
        println("OtherKeyword其中一个匹配？" + if (otherKeywordListMatched) "是" else "否")
        val tempMap = luminaRequireSetup.hybridRespondMap
        val listText = tempMap?.get(LuminaCommon.RETURN_TEXT)
        val textImage = tempMap?.get(LuminaCommon.RETURN_IMAGE)
        var msg_running: Msg
        if (luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.rawMessage, luminaRequireSetup.otherKeywordList!!)) {
//            msg_running = Msg.builder()
//                    .reply(event.getMessageId())
//                    .text(listText.get(0));
            bot.sendGroupMsg(event.groupId, luminaCourier.buildBasicReplyMessage(event, listText as MutableList<String>), false)
        } else if (!luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.rawMessage, luminaRequireSetup.otherKeywordList!!)) {
//            msg_running = Msg.builder()
//                    .at(event.getUserId())
//                    .text(listText.get(0));
            bot.sendGroupMsg(event.groupId, luminaCourier.buildBasicAtUserMessage(event, listText as MutableList<String>), false)
        }
        //        bot.sendGroupMsg(event.getGroupId(), Msg.builder().reply(event.getMessageId()).text("lumina-factory-test"), false);
    }

    fun sendMultiMessage(bot: Bot, event: GroupMessageEvent, luminaRequireSetup: LuminaRequireSetup) {

        //  获取群号
        var luminaRequireSetup = luminaRequireSetup
        println("LuminaPluginHelper#[AI-LM][UserID/用户QQ号] " + event.userId)
        println("LuminaPluginHelper#[AI-LM][GroupID/QQ群号] " + event.groupId)
        println("LuminaPluginHelper#[AI-LM][RawMessage/原始消息] " + event.rawMessage)
        //  装箱操作
//        Long userIdBox = event.getUserId();
//        Long groupIdBox = event.getGroupId();


        //  对消息中是否包含at露米娜的内容进行侦测
        luminaRequireSetup = luminaPrebuild.setLuminaAtRule(luminaRequireSetup, event.rawMessage)

        //  消息状况报告
        println("=============================")
        println("是否要求 检测艾特露米娜：" + if (luminaRequireSetup.isRequireAtLumina) "是" else "否")
        println("侦测到的信息 是否艾特了露米娜：" + if (luminaRequireSetup.isDetectAtLumina) "是" else "否")
        println("要求侦测的主关键字：" + luminaRequireSetup.masterKeyword)
        println("要求侦测的从关键字：" + luminaRequireSetup.masterKeyword)
        val otherKeywordList = luminaRequireSetup.otherKeywordList
        if (otherKeywordList != null) {
            val otherKeywordListStr: StringBuilder
            otherKeywordListStr = StringBuilder()
            var count = 0
            for (s in otherKeywordList) {
                count += 1
                otherKeywordListStr.append("[OtherKeyword#").append(count).append("=").append(s).append("]")
            }
            println("要求匹配的其他关键字:$otherKeywordListStr")
        }
        println("侦测到的信息 全字匹配要求：" + if (luminaRequireSetup.isRequireKeywordMatch) "是" else "否")
        println("回复时 使用回复框回复对话：" + if (luminaRequireSetup.isRequireRespReply()) "是" else "否")
        println("回复时 对对方进行艾特操作：" + if (luminaRequireSetup.isRequireRespAt()) "是" else "否")
        println("=============================")
        //
        val atDetectAndRequire = luminaRequireSetup.isRequireAtLumina && luminaRequireSetup.isDetectAtLumina
        val atNotDetect = !luminaRequireSetup.isDetectAtLumina
        val matchedKeyword = luminaDetectHelper.checkDetectMainKeyword(event.rawMessage, luminaRequireSetup.masterKeyword!!, luminaRequireSetup.secondKeyword, luminaRequireSetup.isRequireKeywordMatch)
        println("Master和Second其中一个匹配？" + if (matchedKeyword) "是" else "否")

        //  测试区 测试完需删除
        if (luminaRequireSetup.otherKeywordList != null) {
            val otherKeywordListMatched = luminaDetectHelper.checkDetectOtherKeywordList(event.rawMessage, luminaRequireSetup.otherKeywordList!!)
            println("OtherKeyword其中一个匹配？" + if (otherKeywordListMatched) "是" else "否")
        }
        val tempMap = luminaRequireSetup.hybridRespondMap
        if (luminaRequireSetup.otherKeywordList == null) {
            if (luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword) {
                bot.sendGroupMsg(event.groupId, luminaCourier.buildMultiReplyPairMessage(event, luminaRequireSetup.hybridRespondMap!!), false)
            } else if (!luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.rawMessage, luminaRequireSetup.otherKeywordList!!)) {
                bot.sendGroupMsg(event.groupId, luminaCourier.buildMultiAtUserPairMessage(event, luminaRequireSetup.hybridRespondMap!!), false)
            }
        } else {
            if (luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.rawMessage, luminaRequireSetup.otherKeywordList!!)) {
                bot.sendGroupMsg(event.groupId, luminaCourier.buildMultiReplyPairMessage(event, luminaRequireSetup.hybridRespondMap!!), false)
            } else if (!luminaRequireSetup.isRequireRespReply() && atNotDetect && matchedKeyword && luminaDetectHelper.checkDetectOtherKeywordList(event.rawMessage, luminaRequireSetup.otherKeywordList!!)) {
                bot.sendGroupMsg(event.groupId, luminaCourier.buildMultiAtUserPairMessage(event, luminaRequireSetup.hybridRespondMap!!), false)
            }
        }
    }
}