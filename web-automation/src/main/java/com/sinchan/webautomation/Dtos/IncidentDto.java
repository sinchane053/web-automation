package com.sinchan.webautomation.Dtos;

public class IncidentDto {
    String id;
    String tmstmp;
    String msg;
    String executionId;

    public IncidentDto() {
    }

    public IncidentDto(String id, String tmstmp, String msg, String executionId) {
        this.id = id;
        this.tmstmp = tmstmp;
        this.msg = msg;
        this.executionId = executionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTmstmp() {
        return tmstmp;
    }

    public void setTmstmp(String tmstmp) {
        this.tmstmp = tmstmp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    @Override
    public String toString() {
        return "IncidentDto{" +
                "id='" + id + '\'' +
                ", tmstmp='" + tmstmp + '\'' +
                ", msg='" + msg + '\'' +
                ", executionId='" + executionId + '\'' +
                '}';
    }
}
