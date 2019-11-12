package com.hecheng.demo.entity;

public class Demo {
    private Long demoId;
    private String demoName;

    public Demo() {
    }

    public Demo(Long demoId, String demoName) {
        this.demoId = demoId;
        this.demoName = demoName;
    }

    public Long getDemoId() {
        return demoId;
    }

    public void setDemoId(Long demoId) {
        this.demoId = demoId;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }
}
