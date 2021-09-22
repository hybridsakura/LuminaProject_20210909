package com.hybridsakura.project.app.luminabot.helper;

import com.hybridsakura.project.app.luminabot.entity.OrderSetup;
import com.hybridsakura.project.app.luminabot.entity.LuminaRequireSetup;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;

import static com.hybridsakura.project.common.LuminaCommon.LUMINA_KEYWORD;


public class LuminaHelper_Prebuild {

    public LuminaRequireSetup setLuminaAtRule(LuminaRequireSetup requireSetup, String rawMessage) {

        if(requireSetup != null) {
            //  指定lumina响应的at名

            boolean atLumina_raw = rawMessage.contains("<at qq=\"2792556795\"/>");
            boolean atLumina_name = rawMessage.contains("@メガミテンセイ");
            boolean atLumina_avatar = rawMessage.contains("@露米娜");
            boolean atLumina_kokone_1 = rawMessage.contains("@心音");
            boolean atLumina_kokone_2 = rawMessage.contains("@心音妹妹");

            boolean atLumina_miyako_1 = rawMessage.contains("@女神转生的喵都厨");
            boolean atLumina_miyako_2 = rawMessage.contains("@喵都厨");

            boolean atLumina_lm_1 = rawMessage.contains("@lumina");
            boolean atLumina_lm_2 = rawMessage.contains("@luminabot");

            boolean atLumina_basic = atLumina_raw || atLumina_name || atLumina_avatar || atLumina_kokone_1 || atLumina_kokone_2;
            boolean atLumina_miyako = atLumina_miyako_1 || atLumina_miyako_2;
            boolean atLumina_lm = atLumina_lm_1 || atLumina_lm_2;

            boolean atLumina = atLumina_basic || atLumina_miyako || atLumina_lm;

            requireSetup.setDetectAtLumina(atLumina);
            return requireSetup;
        }else {
            System.err.println("setLuminaAtRule传入参数不得为空！");
            return null;
        }

    }

    public OrderSetup simplyRequireSetupGetOrder(@NotNull LuminaRequireSetup requireSetup) {
        if(requireSetup.getMasterKeyword() != null && requireSetup.getMasterKeyword().equals(LUMINA_KEYWORD)) {
            System.out.println("AwarenessIntegrateLumina - 侦测到使用LuminaSystem关键字");
            OrderSetup rtn_OrderSetup = new OrderSetup();
            if(requireSetup.getSecondKeyword() != null) {
                rtn_OrderSetup.setOrderOperator(requireSetup.getSecondKeyword());
            }
            if(requireSetup.getOtherKeywordList() != null && requireSetup.getOtherKeywordList().get(0) != null) {
                rtn_OrderSetup.setOrderContent(requireSetup.getOtherKeywordList().get(0));
            }
            return rtn_OrderSetup;
        }else {
            System.out.println("simplyRequireSetupGetOrder 返回为Null");
            return null;
        }
    }

    //  根据setup来确定此次应答使用怎样的Msg（普通消息、回复形式、艾特形式）
    public static Msg setMsgByRule(@NotNull OnebotEvent.GroupMessageEvent event, @NotNull LuminaRequireSetup requireSetup) {

        Msg msg = Msg.builder();

        if(requireSetup.isRequireRespAt() && !requireSetup.isRequireRespReply()) {
            //  对消息的发出者进行艾特
            msg.at(event.getUserId());
            return msg;
        } else if(requireSetup.isRequireRespReply() && !requireSetup.isRequireRespAt()) {
            //  对消息的本身进行回复
            msg.reply(event.getMessageId());
            return msg;
        } else if(!requireSetup.isRequireRespAt() && !requireSetup.isRequireRespReply()) {
            //  说明只需要发送普通消息
            return msg;
        } else {
            return null;
        }

    }


}
