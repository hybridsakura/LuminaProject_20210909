package com.hybridsakura.project.app.luminabot.helper;

import com.hybridsakura.project.app.luminabot.entity.OrderSetup;
import net.lz1998.pbbot.helper.entity.LuminaRequireSetup;
import org.jetbrains.annotations.NotNull;

import static com.hybridsakura.project.common.LuminaCommon.LUMINA_KEYWORD;


public class LuminaPrebuild {

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


}
