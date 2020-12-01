package com.example.demo.entity;

import org.springframework.beans.BeanUtils;

public class FileModel {
    private String simpleName;
    private String name;
    private String logicName;
    private String suffix;
    private String catalogPath;
    private String path;
    private String absolutePath;
    private long fileSize;

    public FileModel() {
    }

    public <T> T copyTo(T t) {
        try {
            BeanUtils.copyProperties(t, this);
            return t;
        } catch (Exception var3) {
            return null;
        }
    }

    public String getSimpleName() {
        return this.simpleName;
    }

    public String getName() {
        return this.name;
    }

    public String getLogicName() {
        return this.logicName;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getCatalogPath() {
        return this.catalogPath;
    }

    public String getPath() {
        return this.path;
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogicName(String logicName) {
        this.logicName = logicName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setCatalogPath(String catalogPath) {
        this.catalogPath = catalogPath;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
