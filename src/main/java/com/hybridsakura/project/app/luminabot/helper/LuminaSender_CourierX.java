package com.hybridsakura.project.app.luminabot.helper;

import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.hybridsakura.project.common.LuminaCommon.RETURN_IMAGE;
import static com.hybridsakura.project.common.LuminaCommon.RETURN_TEXT;

@SuppressWarnings("DuplicatedCode")
public class LuminaSender_CourierX {

    //  增强的消息收发机，传递要回复的消息列表，发送消息
    //  本类自己构造MSG，所以只需要传递机器人参数和回答的消息列表即可
    //  在本类中，消息回复或艾特对方仍然可选

    //  [A-1] 发送一个文本消息，可选应答模式
    public void sendSingleTextMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
        if(msg != null) {
            bot.sendGroupMsg(event.getGroupId(), msg.text(Objects.requireNonNull(requireSetup.getHybridRespondMap()).get(RETURN_TEXT).get(0)), false);
        }

    }

    //  [A-2] 发送一个图片消息，可选应答模式
    public void sendSingleImageMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
        if(msg != null) {
            bot.sendGroupMsg(event.getGroupId(), msg.text(Objects.requireNonNull(requireSetup.getHybridRespondMap()).get(RETURN_IMAGE).get(0)), false);
        }

    }

    //  [A-1] 发送一个文本和图片混合消息，可选应答模式
    public void sendSingleTextAndImageMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
        if(msg!=null) {
            List<String> textList = requireSetup.getHybridRespondMap().get(RETURN_TEXT);
            List<String> imageList = requireSetup.getHybridRespondMap().get(RETURN_IMAGE);
            if(textList.get(0) != null) {
                msg.text(textList.get(0));
            }
            if(imageList.get(0) != null) {
                msg.image(imageList.get(0));
            }
            bot.sendGroupMsg(event.getGroupId(), msg, false);
        }
    }

    //  [B-1] 发送一组文本消息（多行文本），可选应答模式
    public void sendTextMessages(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
        if(msg != null) {
            List<String> textList = requireSetup.getHybridRespondMap().get(RETURN_TEXT);
            for(String text : textList) {
                msg.text(text+"\n");
            }
            bot.sendGroupMsg(event.getGroupId(), msg, false);
        }
    }

    //  [B-1-1] 发送多个文本消息，可选应答模式
    public void sendMultiTextMessages(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        List<String> textList = requireSetup.getHybridRespondMap().get(RETURN_TEXT);
        Msg msg;
        for(String text : textList) {
            msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
            assert msg != null;
            msg.text(text);
            bot.sendGroupMsg(event.getGroupId(), msg, false);
        }
    }

    //  [B-2] 发送一组图片消息（一个消息多张图片），可选应答模式
    public void sendImageMessages(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
        if(msg != null) {
            List<String> imageList = requireSetup.getHybridRespondMap().get(RETURN_IMAGE);
            for(String image : imageList) {
                msg.image(image);
            }
            bot.sendGroupMsg(event.getGroupId(), msg, false);
        }
    }

    //  [B-2-1] 发送多个图片消息，可选应答模式
    public void sendMultiImageMessages(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        List<String> imageList = requireSetup.getHybridRespondMap().get(RETURN_IMAGE);
        Msg msg;
        for(String image : imageList) {
            msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
            assert msg != null;
            msg.image(image);
            bot.sendGroupMsg(event.getGroupId(), msg, false);
        }
    }
}
