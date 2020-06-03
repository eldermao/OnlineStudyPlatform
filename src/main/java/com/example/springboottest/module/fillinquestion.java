package com.example.springboottest.module;

public class fillinquestion {
    public void setQid(Integer qid){this.qid = qid;}
    public Integer getQid(){return qid;}

    public void setQname(String qname){this.qname = qname;}
    public String getQname(){return qname;}

    public void setAnswer(String answer){this.answer = answer;}
    public String getAnswer(){return answer;}
    public void setIsexam(Integer isexam){this.isexam = isexam;}
    public Integer getIsexam(){return isexam;}

    public void setExamid(Integer examid){this.examid = examid;}
    public Integer getExamid(){return examid;}

    public void setTaskid(Integer taskid){this.taskid = taskid;}
    public Integer getTaskid(){return taskid;}

    public void setScore(Integer score){this.score = score;}
    public Integer getScore(){return score;}

    private Integer qid;
    private String qname;
    private String answer;
    private Integer isexam;
    private Integer examid;
    private Integer taskid;
    private Integer score;
}
