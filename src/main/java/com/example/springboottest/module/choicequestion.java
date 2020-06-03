package com.example.springboottest.module;

public class choicequestion {
    public void setQid(Integer qid){this.qid = qid;}
    public Integer getQid(){return qid;}

    public void setQname(String qname){this.qname = qname;}
    public String getQname(){return qname;}

    public void setC1(String c1){this.c1 = c1;}
    public String getC1(){return c1;}
    public void setC2(String c2){this.c2 = c2;}
    public String getC2(){return c2;}
    public void setC3(String c3){this.c3 = c3;}
    public String getC3(){return c3;}
    public void setC4(String c4){this.c4 = c4;}
    public String getC4(){return c4;}

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
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String answer;
    private Integer isexam;
    private Integer examid;
    private Integer taskid;
    private Integer score;
}
