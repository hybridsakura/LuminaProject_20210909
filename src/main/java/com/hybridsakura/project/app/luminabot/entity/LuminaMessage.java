package com.hybridsakura.project.app.luminabot.entity;

import java.io.Serializable;
import java.util.List;

public class LuminaMessage implements Serializable {

    private static final long serialVersionUID = -3540600716589743723L;

    String messageDetected;                             //  消息中侦测到的关键字
    boolean messageDetected_requireEquals;              //  是否要求[侦测到的关键字]必须全匹配
    String messageResponse;                             //  进行回应的消息
    boolean atLumina;                                   //  是否针对@(at)进行反应，还是只要侦测到关键字就反应
    boolean atRespond;                                  //  是否以回复方式进行反应，还是另开一个消息
    List<Long> blackQQUserList;                         //  QQ用户黑名单
    List<Long> blackQQGroupList;                        //  QQ群黑名单

    public String getMessageDetected() {
        return messageDetected;
    }

    public void setMessageDetected(String messageDetected) {
        this.messageDetected = messageDetected;
    }

    public boolean isMessageDetected_requireEquals() {
        return messageDetected_requireEquals;
    }

    public void setMessageDetected_requireEquals(boolean messageDetected_requireEquals) {
        this.messageDetected_requireEquals = messageDetected_requireEquals;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public boolean isAtLumina() {
        return atLumina;
    }

    public void setAtLumina(boolean atLumina) {
        this.atLumina = atLumina;
    }

    public boolean isAtRespond() {
        return atRespond;
    }

    public void setAtRespond(boolean atRespond) {
        this.atRespond = atRespond;
    }

    public List<Long> getBlackQQUserList() {
        return blackQQUserList;
    }

    public void setBlackQQUserList(List<Long> blackQQUserList) {
        this.blackQQUserList = blackQQUserList;
    }

    public List<Long> getBlackQQGroupList() {
        return blackQQGroupList;
    }

    public void setBlackQQGroupList(List<Long> blackQQGroupList) {
        this.blackQQGroupList = blackQQGroupList;
    }
}
