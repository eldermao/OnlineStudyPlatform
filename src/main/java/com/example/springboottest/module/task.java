package com.example.springboottest.module;

public class task {
    public Integer getTaskid(){
        return taskid;
    }
    public void setTaskid(Integer taskid){
        this.taskid = taskid;
    }
    public String getTaskname(){
        return taskname;
    }
    public void setTaskname(String taskname){
        this.taskname = taskname;
    }
    public Integer getCrspointid(){
        return crspointid;
    }
    public void setCrspointid(Integer crspointid){
        this.crspointid = crspointid;
    }
    private Integer taskid;
    private String taskname;
    private Integer crspointid;
}
