package com.hybridsakura.project.app.luminabot.entity;

public class OrderSetup {

    private String masterName;
    private String orderOperator;
    private String orderContent;

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getOrderOperator() {
        return orderOperator;
    }

    public void setOrderOperator(String orderOperator) {
        this.orderOperator = orderOperator;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }
}
