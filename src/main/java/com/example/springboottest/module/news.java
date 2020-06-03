package com.example.springboottest.module;

public class news {
    public void setNewsid(Integer newsid){this.newsid = newsid;}
    public Integer getNewsid(){return newsid;}

    public void setSenderid(Integer senderid){this.senderid = senderid;}
    public Integer getSenderid(){return senderid;}

    public void setSendername(String sendername){this.sendername = sendername;}
    public String getSendername(){return sendername;}

    public void setReceiverid(Integer receiverid){this.receiverid = receiverid;}
    public Integer getReceiverid(){return receiverid;}

    public void setReceivername(String receivername){this.receivername = receivername;}
    public String getReceivername(){return receivername;}

    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}

    public void setContent(String content){this.content = content;}
    public String getContent(){return content;}

    public void setTime(Integer time){this.time = time;}
    public Integer getTime(){return time;}

    public void setRead(Integer read){this.read = read;}
    public Integer getRead(){return read;}


    private Integer newsid;
    private Integer senderid;
    private String sendername;
    private Integer receiverid;
    private String receivername;
    private String title;
    private String content;
    private Integer time;
    private Integer read;
}
