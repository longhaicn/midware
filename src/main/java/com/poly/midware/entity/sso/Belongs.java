package com.poly.midware.entity.sso;

import java.io.Serializable;

/**
 * Created by Shaofei Du on 2017/6/26.
 */
public class Belongs implements Serializable {
    /**
     *
     */
    private String ouDirectory;

    private String belongOuUuid;

    private boolean rootNode;

    private String ddtalkDepartId;

    public Belongs() {
    }

    public String getDdtalkDepartId() {
        return ddtalkDepartId;
    }

    public void setDdtalkDepartId(String ddtalkDepartId) {
        this.ddtalkDepartId = ddtalkDepartId;
    }

    public String getOuDirectory() {
        return ouDirectory;
    }

    public void setOuDirectory(String ouDirectory) {
        this.ouDirectory = ouDirectory;
    }

    public String getBelongOuUuid() {
        return belongOuUuid;
    }

    public void setBelongOuUuid(String belongOuUuid) {
        this.belongOuUuid = belongOuUuid;
    }

    public boolean isRootNode() {
        return rootNode;
    }

    public void setRootNode(boolean rootNode) {
        this.rootNode = rootNode;
    }
}
