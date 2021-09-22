package com.hybridsakura.project.app.luminabot.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class LuminaRequireSetup implements Serializable {

    private static final long serialVersionUID = 9158483452708692944L;

    private String masterKeyword;                                       //  主要关键字，用于匹配单一内容或者
    private String secondKeyword;                                       //  次要关键字，可能用于命令或者其他
    private List<String> otherKeywordList;                              //  消息中侦测到的关键字表
    private boolean requireKeywordMatch;                                //  当且仅当[主]关键字存在且其他关键字不存在时，此项为true
    private Map<String, List<String>> hybridRespondMap;                 //  进行回应的消息 <K:文字或图片 V:回复文字列表或回复图片的地址列表>
    private boolean detectAtLumina;                                     //  是否在消息中侦测到艾特露米娜
    private boolean requireAtLumina;                                    //  是否要回复 取决于 露米娜是否被艾特
    private boolean requireRespAt;                                      //  回复时是否 @(at) 对方 （和下方冲突）
    private boolean requireRespReply;                                   //  回复时是否 对消息进行回复 对方 （和上方冲突）
    private String respMode;                                            //  自动设置项 回复模式
    private List<Long> blackQQUserList;                                 //  QQ用户黑名单
    private List<Long> blackQQGroupList;                                //  QQ群黑名单

    public String getMasterKeyword() {
        return masterKeyword;
    }

    public void setMasterKeyword(String masterKeyword) {
        this.masterKeyword = masterKeyword;
    }

    public String getSecondKeyword() {
        return secondKeyword;
    }

    public void setSecondKeyword(String secondKeyword) {
        this.secondKeyword = secondKeyword;
    }

    public List<String> getOtherKeywordList() {
        return otherKeywordList;
    }

    public void setOtherKeywordList(List<String> otherKeywordList) {
        this.otherKeywordList = otherKeywordList;
    }

    public boolean isRequireKeywordMatch() {
        return requireKeywordMatch;
    }

    public void setRequireKeywordMatch(boolean requireKeywordMatch) {
        this.requireKeywordMatch = requireKeywordMatch;
    }

    public Map<String, List<String>> getHybridRespondMap() {
        return hybridRespondMap;
    }

    public void setHybridRespondMap(Map<String, List<String>> hybridRespondMap) {
        this.hybridRespondMap = hybridRespondMap;
    }

    public boolean isDetectAtLumina() {
        return detectAtLumina;
    }

    public void setDetectAtLumina(boolean detectAtLumina) {
        this.detectAtLumina = detectAtLumina;
    }

    public boolean isRequireAtLumina() {
        return requireAtLumina;
    }

    public void setRequireAtLumina(boolean requireAtLumina) {
        this.requireAtLumina = requireAtLumina;
    }

    public boolean isRequireRespAt() {
        return requireRespAt;
    }

    public void setRequireRespAt(boolean requireRespAt) {
//        if("lumina-reply_with_at".equals(this.respMode)) {
//            this.requireRespAt = true;
//            this.requireRespReply = false;
//        }else if("lumina-reply_last_message".equals(this.respMode)) {
//            this.requireRespAt = false;
//            this.requireRespReply = true;
//        }else {
            this.requireRespAt = requireRespAt;
//            this.requireRespReply = !this.requireRespAt;
//        }
    }

    public boolean isRequireRespReply() {
        return requireRespReply;
    }

    public void setRequireRespReply(boolean requireRespReply) {
//        if("lumina-reply_last_message".equals(this.respMode)) {
//            this.requireRespReply = true;
//            this.requireRespAt = false;
//        }else if("lumina-reply_with_at".equals(this.respMode)) {
//            this.requireRespReply = false;
//            this.requireRespAt = true;
//        }else {
            this.requireRespReply = requireRespReply;
//            this.requireRespAt = !this.requireRespReply;
//        }
    }

    public String getRespMode() {
        return respMode;
    }

    public void setRespMode(String respMode) {
        if(this.requireRespAt && !this.requireRespReply) {
            this.respMode = "lumina-reply_with_at";
        } else if(!this.requireRespAt && this.requireRespReply) {
            this.respMode = "lumina-reply_last_message";
        } else {
            this.respMode = respMode;
        }
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
