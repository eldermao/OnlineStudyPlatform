package com.example.springboottest.Controller;

import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/exam")
public class examController {
    @Autowired
    private CourseServiceImpl courseServer;
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private ExamServiceImpl examServer;
    @Autowired
    private ScoreServiceImpl scoreServer;
    @RequestMapping("")
    public String examHomePage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
    {
        user theUser = userServer.loginUser(userid, userpassword);
        if(theUser==null){
            user fakeUser = new user();
            fakeUser.setUsername("");
            map.addAttribute("isExist", false);
            map.addAttribute("theUser", fakeUser);
        }else{
            map.addAttribute("isExist", true);
            map.addAttribute("theUser", theUser);
        }
        List<exam> examlist = examServer.getExamList(theUser.getUserid());
        map.addAttribute("examlist", examlist);
        List<contest> contestlist = examServer.getContestbyStudentid(theUser.getUserid());
        map.addAttribute("contestlist", contestlist);
        return "examHome";
    }

    @RequestMapping("manageexam")
    public String examManagePage(ModelMap map, Integer courseid, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
    {
        user theUser = userServer.loginUser(userid, userpassword);
        if(theUser==null){
            user fakeUser = new user();
            fakeUser.setUsername("");
            map.addAttribute("isExist", false);
            map.addAttribute("theUser", fakeUser);
        }else{
            map.addAttribute("isExist", true);
            map.addAttribute("theUser", theUser);
        }
        map.addAttribute("courseid", courseid);
        List<exam> examList = examServer.getExamListbyCourseid(courseid);
        map.addAttribute("examList", examList);
        List<coursecontest> coursecontestList = examServer.getCoursecontestbyCourseid(courseid);
        map.addAttribute("coursecontestList", coursecontestList);
        return "examManage";
    }

    @RequestMapping("manage")
    public String examManage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
    {
        user theUser = userServer.loginUser(userid, userpassword);
        if(theUser==null){
            user fakeUser = new user();
            fakeUser.setUsername("");
            map.addAttribute("isExist", false);
            map.addAttribute("theUser", fakeUser);
        }else{
            map.addAttribute("isExist", true);
            map.addAttribute("theUser", theUser);
        }
        List<course> courselist = courseServer.getCourseListbyTeacherid(theUser.getUserid());
        map.addAttribute("courselist", courselist);
        return "examManagePage";
    }

    @RequestMapping("isexamed")
    @ResponseBody
    public String isexamed(Integer examid, Integer studentid){
        if(scoreServer.isStudentExamed(studentid, examid)){
            return examid.toString();
        }
        return "已考试过，不能重复考试";
    }

    @RequestMapping("examing")
    public String examing(ModelMap map, Integer examid, Integer groupid, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
    {
        user theUser = userServer.loginUser(userid, userpassword);
        if(theUser==null){
            user fakeUser = new user();
            fakeUser.setUsername("");
            map.addAttribute("isExist", false);
            map.addAttribute("theUser", fakeUser);
        }else{
            map.addAttribute("isExist", true);
            map.addAttribute("theUser", theUser);
        }
        map.addAttribute("examid", examid);
        map.addAttribute("groupid", groupid);
        List<choicequestion> choicequestionlist = examServer.getChoicequestionInExam(examid);
        map.addAttribute("choicequestionlist", choicequestionlist);
        List<fillinquestion> fillinquestionlist = examServer.getFillinquestionInExam(examid);
        map.addAttribute("fillinquestionlist", fillinquestionlist);
        List<tfquestion> tfquestionlist = examServer.getTfquestionInExam(examid);
        map.addAttribute("tfquestionlist", tfquestionlist);
        List<subjectivequestion> subjectivequestionlist = examServer.getSubjectivequestionInExam(examid);
        map.addAttribute("subjectivequestionlist", subjectivequestionlist);
        return "examPage";
    }

    @RequestMapping("challenge")
    @ResponseBody
    public String challengeGroup(Integer examid, Integer g1id, Integer g2id, Integer starttime, Integer endtime){
        Random r = new Random();
        Integer contestid = r.nextInt(1000000);
        while(courseServer.searchChoicequestionInTask(contestid)!=null){
            contestid = r.nextInt(1000000);
        }
        examServer.challengeGroup(contestid, examid, g1id, g2id, starttime, endtime);
        return "挑战成功";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String editExam(ModelMap map, Integer examid, String examname, Integer starttime, Integer endtime){
        examServer.editExam(examid, examname, starttime, endtime);
        return "修改成功";
    }

    @RequestMapping("insertexam")
    @ResponseBody
    public String insertExam(String examname, Integer starttime, Integer endtime, Integer courseid){
        Random r = new Random();
        Integer examid = r.nextInt(1000000);
        while(examServer.searchExam(examid)!=null){
            examid = r.nextInt(1000000);
        }
        examServer.insertExam(examid, examname, starttime, endtime, courseid);
        return "添加考试成功";
    }

    @RequestMapping("insertcontest")
    @ResponseBody
    public String insertContest(String examname, Integer courseid){
        Random r = new Random();
        Integer examid = r.nextInt(1000000);
        while(examServer.searchExam(examid)!=null){
            examid = r.nextInt(1000000);
        }
        examServer.insertContest(examid, examname, courseid);
        return "添加比赛成功";
    }

    @RequestMapping("dltexam")
    @ResponseBody
    public String dltExam(Integer examid){
        examServer.dltExam(examid);
        return "删除";
    }

    @RequestMapping("choicequestion")
    @ResponseBody
    public List<choicequestion> getChoiceQuestionListExam(ModelMap map, Integer examid){
        List<choicequestion> res = examServer.getChoicequestionInExam(examid);
        return res;
    }

    @RequestMapping("insertchoice")
    @ResponseBody
    public String insertChoicequestion(String qname, String c1, String c2, String c3, String c4, String answer, Integer examid, Integer score){
        Random r = new Random();
        Integer qid = r.nextInt(1000000);
        while(courseServer.searchChoicequestionInTask(qid)!=null){
            qid = r.nextInt(1000000);
        }
        examServer.insertChoicequestionInExam(qid, qname, c1, c2, c3, c4, answer, examid, score);
        return "添加成功";
    }

    @RequestMapping("fillinquestion")
    @ResponseBody
    public List<fillinquestion> getFillinQuestionListExam(ModelMap map, Integer examid){
        List<fillinquestion> res = examServer.getFillinquestionInExam(examid);
        return res;
    }

    @RequestMapping("insertfillin")
    @ResponseBody
    public String insertFillinquestion(String qname,String answer, Integer examid, Integer score){
        Random r = new Random();
        Integer qid = r.nextInt(1000000);
        while(courseServer.searchFillinquestionInTask(qid)!=null){
            qid = r.nextInt(1000000);
        }
        examServer.insertFillinquestionInExam(qid, qname, answer, examid, score);
        return "添加成功";
    }
    @RequestMapping("tfquestion")
    @ResponseBody
    public List<tfquestion> getTfQuestionListExam(ModelMap map, Integer examid){
        List<tfquestion> res = examServer.getTfquestionInExam(examid);
        return res;
    }

    @RequestMapping("inserttf")
    @ResponseBody
    public String insertTfquestion(String qname,String answer, Integer examid, Integer score){
        Random r = new Random();
        Integer qid = r.nextInt(1000000);
        while(courseServer.searchTfquestionInTask(qid)!=null){
            qid = r.nextInt(1000000);
        }
        examServer.insertTfquestionInExam(qid, qname, answer, examid, score);
        return "添加成功";
    }
    @RequestMapping("subquestion")
    @ResponseBody
    public List<subjectivequestion> getSubQuestionListExam(ModelMap map, Integer examid){
        List<subjectivequestion> res = examServer.getSubjectivequestionInExam(examid);
        return res;
    }
    @RequestMapping("insertsub")
    @ResponseBody
    public String insertSubquestion(String qname, Integer examid, Integer score){
        Random r = new Random();
        Integer qid = r.nextInt(1000000);
        while(courseServer.searchTfquestionInTask(qid)!=null){
            qid = r.nextInt(1000000);
        }
        examServer.insertSubquestionInExam(qid, qname, examid, score);
        return "添加成功";
    }

    @RequestMapping("editsub")
    @ResponseBody
    public String editSubquestion(Integer qid, String qname, Integer score){
        examServer.editSubquestionInExam(qid, qname, score);
        return "编辑成功";
    }

    @RequestMapping("dltsub")
    @ResponseBody
    public String dltSubquestion(Integer qid){
        examServer.dltSubquestionInExam(qid);
        return "删除成功";
    }

    @RequestMapping("sqstudentanswer")
    @ResponseBody
    public List<sqstudentanswer> getSQstudentanswer(ModelMap map, Integer examid){
        List<sqstudentanswer> res = examServer.getSQstudentanswer(examid);
        return res;
    }
}
