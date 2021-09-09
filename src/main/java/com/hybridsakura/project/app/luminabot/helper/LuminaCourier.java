package com.hybridsakura.project.app.luminabot.helper;

import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

import static com.hybridsakura.project.common.LuminaCommon.RETURN_IMAGE;
import static com.hybridsakura.project.common.LuminaCommon.RETURN_TEXT;


@SuppressWarnings("DuplicatedCode")
public class LuminaCourier {

    //  通过上层传输的MSG直接追加构造，再传出
    public Msg buildBasicMessage(@NotNull Msg msg, @NotNull List<String> textList) {
        for (String text : textList) {
            msg.text(text);
            msg.text(" \n");
        }
        return msg;
    }

    public Msg buildMultiMessage(@NotNull Msg msg, @NotNull Map<String, List<String>> respMap) {
        List<String> textList = respMap.get(RETURN_TEXT);
        List<String> imageList = respMap.get(RETURN_IMAGE);
        for (String text : textList) {
            msg.text(text);
            msg.text(" \n");
        }
        for (String image : imageList) {
            msg.image(image);
            msg.text(" \n");
        }
        return msg;
    }

    public Msg buildMultiPairMessage(@NotNull Msg msg, @NotNull Map<String, List<String>> respMap) {
        List<String> textList = respMap.get(RETURN_TEXT);
        List<String> imageList = respMap.get(RETURN_IMAGE);
        msg.text(textList.get(0));
        msg.image(imageList.get(0));
        return msg;
    }

    //  通过上层对象构造MSG类，再传出
    public Msg buildBasicReplyMessage(@NotNull OnebotEvent.GroupMessageEvent event, @NotNull List<String> textList) {
        Msg msg = Msg.builder()
                .reply(event.getMessageId());
        for (String text : textList) {
            msg.text(text);
            msg.text(" \n");
        }
        return msg;
    }

    //  通过上层对象构造MSG类，再传出
    public Msg buildBasicAtUserMessage(@NotNull OnebotEvent.GroupMessageEvent event, @NotNull List<String> textList) {
        Msg msg = Msg.builder()
                .at(event.getUserId());
        for (String text : textList) {
            msg.text(text);
            msg.text(" \n");
        }
        return msg;
    }

    public Msg buildMultiReplyPairMessage(@NotNull OnebotEvent.GroupMessageEvent event, @NotNull Map<String, List<String>> respMap) {
        Msg msg = Msg.builder()
                .reply(event.getMessageId());
        List<String> textList = respMap.get(RETURN_TEXT);
        List<String> imageList = respMap.get(RETURN_IMAGE);
        msg.text(textList.get(0));
        msg.image(imageList.get(0));
        return msg;
    }

    public Msg buildMultiAtUserPairMessage(@NotNull OnebotEvent.GroupMessageEvent event, @NotNull Map<String, List<String>> respMap) {
        Msg msg = Msg.builder()
                .at(event.getUserId());
        List<String> textList = respMap.get(RETURN_TEXT);
        List<String> imageList = respMap.get(RETURN_IMAGE);
        msg.text(textList.get(0));
        msg.image(imageList.get(0));
        return msg;
    }

    public Msg buildMultiReplyMessage(@NotNull OnebotEvent.GroupMessageEvent event, @NotNull Map<String, List<String>> respMap) {
        Msg msg = Msg.builder()
                .reply(event.getMessageId());
        List<String> textList = respMap.get(RETURN_TEXT);
        List<String> imageList = respMap.get(RETURN_IMAGE);
        for (String text : textList) {
            msg.text(text);
            msg.text(" \n");
        }
        for (String image : imageList) {
            msg.image(image);
            msg.text(" \n");
        }
        return msg;
    }

    public Msg buildMultiAtUserMessage(@NotNull OnebotEvent.GroupMessageEvent event, @NotNull Map<String, List<String>> respMap) {
        Msg msg = Msg.builder()
                .at(event.getUserId());
        List<String> textList = respMap.get(RETURN_TEXT);
        List<String> imageList = respMap.get(RETURN_IMAGE);
        for (String text : textList) {
            msg.text(text);
            msg.text(" \n");
        }
        for (String image : imageList) {
            msg.image(image);
            msg.text(" \n");
        }
        return msg;
    }



}
