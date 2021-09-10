package com.hybridsakura.project.app.minecraft.entity;

import java.io.Serializable;

public class FlexibleParams implements Serializable {

    private static final long serialVersionUID = 470605676004264681L;

    private String sequenceName;
    private int width;
    private String directionCode;

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }
}
