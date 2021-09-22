package com.hybridsakura.project.app.luminabot.repo;

import java.io.Serializable;

public class ProfileData implements Serializable {

    private static final long serialVersionUID = 2422802823469417292L;

    //  配置记录类

    private String uuid;                                                            //  记录全局ID
    private String operator;                                                        //  操作者
    private String createDateTime;                                                  //  记录创建时间
    private String updateDateTime;                                                  //  记录更新时间
    private String reqMasterKeyword;                                                //  侦测匹配主关键字
    private String reqSecondKeyword;                                                //  侦测匹配次关键字
    private Boolean reqMasterMatched;                                               //
    private Boolean reqSecondMatched;                                               //
    private String respKeyword;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getReqMasterKeyword() {
        return reqMasterKeyword;
    }

    public void setReqMasterKeyword(String reqMasterKeyword) {
        this.reqMasterKeyword = reqMasterKeyword;
    }

    public String getReqSecondKeyword() {
        return reqSecondKeyword;
    }

    public void setReqSecondKeyword(String reqSecondKeyword) {
        this.reqSecondKeyword = reqSecondKeyword;
    }

    public Boolean getReqMasterMatched() {
        return reqMasterMatched;
    }

    public void setReqMasterMatched(Boolean reqMasterMatched) {
        this.reqMasterMatched = reqMasterMatched;
    }

    public Boolean getReqSecondMatched() {
        return reqSecondMatched;
    }

    public void setReqSecondMatched(Boolean reqSecondMatched) {
        this.reqSecondMatched = reqSecondMatched;
    }

    public String getRespKeyword() {
        return respKeyword;
    }

    public void setRespKeyword(String respKeyword) {
        this.respKeyword = respKeyword;
    }
}
