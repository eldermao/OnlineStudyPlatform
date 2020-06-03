package com.example.springboottest.module;

public class chapter {

    public Integer getChapterid(){return chapterid;}
    public void setChapterid(Integer chapterid){
        this.chapterid = chapterid;
    }

    public String getChaptername(){
        return chaptername;
    }
    public void setChaptername(String chaptername){
        this.chaptername = chaptername;
    }
    public Integer getCrspoint_sum(){
        return crspoint_sum;
    }
    public void setCrspoint_sum(Integer crspoint_sum){
        this.crspoint_sum = crspoint_sum;
    }
    public Integer getCourseid(){
        return chapterid;
    }
    public void setCourseid(Integer courseid){
        this.courseid = courseid;
    }

    private Integer chapterid;
    private String chaptername;
    private Integer crspoint_sum;
    private Integer courseid;
}
