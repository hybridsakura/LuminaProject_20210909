package com.hybridsakura.project.app.luminabot.helper;

import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.hybridsakura.project.common.LuminaCommon.RETURN_IMAGE;
import static com.hybridsakura.project.common.LuminaCommon.RETURN_TEXT;

public class LuminaSender_CourierX {

    //  增强的消息收发机，传递要回复的消息列表，发送消息
    //  本类自己构造MSG，所以只需要传递机器人参数和回答的消息列表即可
    //  在本类中，消息回复或艾特对方仍然可选

    //  [A-1] 发送一个文本消息，可选应答模式
    public void sendSingleTextMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
        assert msg != null;
        bot.sendGroupMsg(event.getGroupId(), msg.text(Objects.requireNonNull(requireSetup.getHybridRespondMap()).get(RETURN_TEXT).get(0)), false);
    }

    //  [A-2] 发送一个文本消息，可选应答模式
    public void sendSingleImageMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);
        assert msg != null;
        bot.sendGroupMsg(event.getGroupId(), msg.text(Objects.requireNonNull(requireSetup.getHybridRespondMap()).get(RETURN_IMAGE).get(0)), false);
    }

    //  [A-1] 发送一个文本和图片混合消息，可选应答模式
    public Msg sendSingleTextAndImageMessage(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);

        return null;
    }

    //  [B-1] 发送一组文本消息（多行文本），可选应答模式
    public Msg sendTextMessages(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);

        return null;
    }

    //  [B-2] 发送一组图片消息（一个消息多张图片），可选应答模式
    public Msg sendImageMessages(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);

        return null;
    }

    //  [C-1] 发送一组文本和图片混合消息，以文本图片文本图片的顺序输出，可选应答模式
    public Msg sendComplexMessages(@NotNull Bot bot, @NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {
        //  使用预构建方法预构建一个MSG
        Msg msg = LuminaHelper_Prebuild.setMsgByRule(event, requireSetup);

        return null;
    }



}
