package com.example.springboottest.module;

public class studentrank {
    public void setStudentid(Integer studentid){this.studentid = studentid;}
    public Integer getStudentid(){return studentid;}

    public void setStudentname(String studentname){this.studentname = studentname;}
    public String getStudentname(){return studentname;}

    public void setScore(Integer score){this.score = score;}
    public Integer getScore(){return score;}

    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setRank(Integer rank){this.rank = rank;}
    public Integer getRank(){return rank;}

    private Integer studentid;
    private String studentname;
    private Integer score;
    private String profile;
    private Integer rank;
}
