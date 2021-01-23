package com.apeshko.fastfilemover.model;

public class PerfTestArgs {
    private String smFilePath;
    private String mdFilePath;
    private String lgFilePath;
    private String xlgFilePath;

    public PerfTestArgs(String smFilePath, String mdFilePath, String lgFilePath, String xlgFilePath) {
        this.smFilePath = smFilePath;
        this.mdFilePath = mdFilePath;
        this.lgFilePath = lgFilePath;
        this.xlgFilePath = xlgFilePath;
    }

    public String getSmFilePath() {
        return smFilePath;
    }

    public void setSmFilePath(String smFilePath) {
        this.smFilePath = smFilePath;
    }

    public String getMdFilePath() {
        return mdFilePath;
    }

    public void setMdFilePath(String mdFilePath) {
        this.mdFilePath = mdFilePath;
    }

    public String getLgFilePath() {
        return lgFilePath;
    }

    public void setLgFilePath(String lgFilePath) {
        this.lgFilePath = lgFilePath;
    }

    public String getXlgFilePath() {
        return xlgFilePath;
    }

    public void setXlgFilePath(String xlgFilePath) {
        this.xlgFilePath = xlgFilePath;
    }
}
