package com.example.springboottest.module;

public class vedio {

    public vedio(){};

    public Integer getVedioid() {
        return vedioid;
    }
    public void setVedioid(Integer vedioid){
        this.vedioid = vedioid;
    }

    public String getVedioname() {
        return vedioname;
    }
    public void setVedioname(String vedioname){
        this.vedioname = vedioname;
    }


    public Integer getCrspointid() {
        return crspointid;
    }
    public void setCrspointid(Integer crspointid){
        this.crspointid = crspointid;
    }



    private Integer vedioid;
    private String vedioname;
    private Integer crspointid;
}
