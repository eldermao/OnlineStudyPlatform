package com.example.springboottest.Controller;

import com.example.springboottest.dao.VedioMapper;
import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.CommentsServiceImpl;
import com.example.springboottest.serviceimpl.CourseServiceImpl;
import com.example.springboottest.serviceimpl.ExamServiceImpl;
import com.example.springboottest.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/point")
public class pointController {
    @Autowired
    private VedioMapper vedioMapper;
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private CourseServiceImpl courseServer;
    @Autowired
    private ExamServiceImpl examServer;
    @Autowired
    private CommentsServiceImpl commentsServer;
    @RequestMapping("")
    public String chapterHomePage(ModelMap map, Integer crspointid, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        course Course = courseServer.getCoursebyCrspointid(crspointid);
        map.addAttribute("courseid", Course.getCourseid());

        map.addAttribute("crspointid", crspointid);
        List<choicequestion> choicequestionlist = courseServer.getChoicequestionInTask(crspointid);
        map.addAttribute("choicequestionlist", choicequestionlist);
        List<fillinquestion> fillinquestionlist = courseServer.getFillinquestionInTask(crspointid);
        map.addAttribute("fillinquestionlist", fillinquestionlist);
        List<tfquestion> tfquestionlist = courseServer.getTfquestionInTask(crspointid);
        map.addAttribute("tfquestionlist", tfquestionlist);
        Map<comments, List<reply>> commentsList = commentsServer.getCommentslist(crspointid);
        map.addAttribute("commentsList", commentsList);
        return "crspointPage";
    }

    @RequestMapping("choicequestion")
    @ResponseBody
    public List<choicequestion> getChoiceQuestionList(ModelMap map, Integer crspointid){
        List<choicequestion> res = courseServer.getChoicequestionInTask(crspointid);
        return res;
    }


    @RequestMapping("fillinquestion")
    @ResponseBody
    public List<fillinquestion> getFillinQuestionList(ModelMap map, Integer crspointid){
        List<fillinquestion> res = courseServer.getFillinquestionInTask(crspointid);
        return res;
    }


    @RequestMapping("tfquestion")
    @ResponseBody
    public List<tfquestion> getTfQuestionList(ModelMap map, Integer crspointid){
        List<tfquestion> res = courseServer.getTfquestionInTask(crspointid);
        return res;
    }


    @RequestMapping("get")
    @ResponseBody
    public Map<chapter, List<crspoint>> getCoursepointList(ModelMap map, Integer courseid){
        Map<chapter, List<crspoint>> chapterlist = courseServer.chapterCrspoint(courseid);
        return chapterlist;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insertCoursepoint(ModelMap map, String crspointname, Integer chapterid){
        Random r = new Random();
        Integer crspointid = r.nextInt(1000000);
        while(courseServer.searchCourseByCourseid(crspointid)!=null){
            crspointid = r.nextInt(1000000);
        }
        courseServer.insertCrspoint(crspointid, crspointname, chapterid);
        return "添加成功";
    }

    @RequestMapping("insertchoice")
    @ResponseBody
    public String insertChoicequestion(String qname, String c1, String c2, String c3, String c4, String answer, Integer taskid, Integer score){
        Random r = new Random();
        Integer qid = r.nextInt(1000000);
        while(courseServer.searchChoicequestionInTask(qid)!=null){
            qid = r.nextInt(1000000);
        }
        courseServer.insertChoicequestionInTask(qid, qname, c1, c2, c3, c4, answer, taskid, score);
        return "添加成功";
    }

    @RequestMapping("editchoice")
    @ResponseBody
    public String editChoicequestion(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer score){
        courseServer.editChoicequestionInTask(qid, qname, c1, c2, c3, c4, answer, score);
        return "编辑成功";
    }

    @RequestMapping("dltchoice")
    @ResponseBody
    public String dltChoicequestion(Integer qid){
        courseServer.dltChoicequestionInTask(qid);
        return "删除成功";
    }

    @RequestMapping("insertfillin")
    @ResponseBody
    public String insertFillinquestion(String qname,String answer, Integer taskid, Integer score){
        Random r = new Random();
        Integer qid = r.nextInt(1000000);
        while(courseServer.searchFillinquestionInTask(qid)!=null){
            qid = r.nextInt(1000000);
        }
        courseServer.insertFillinquestionInTask(qid, qname, answer, taskid, score);
        return "添加成功";
    }

    @RequestMapping("editfillin")
    @ResponseBody
    public String editFillinquestion(Integer qid, String qname,String answer, Integer score){
        courseServer.editFillinquestion(qid, qname, answer, score);
        return "编辑成功";
    }

    @RequestMapping("dltfillin")
    @ResponseBody
    public String dltFillinquestion(Integer qid){
        courseServer.dltFillinquestion(qid);
        return "删除成功";
    }

    @RequestMapping("inserttf")
    @ResponseBody
    public String insertTfquestion(String qname,String answer, Integer taskid, Integer score){
        Random r = new Random();
        Integer qid = r.nextInt(1000000);
        while(courseServer.searchTfquestionInTask(qid)!=null){
            qid = r.nextInt(1000000);
        }
        courseServer.insertTfquestionInTask(qid, qname, answer, taskid, score);
        return "添加成功";
    }

    @RequestMapping("edittf")
    @ResponseBody
    public String editTfquestion(Integer qid, String qname,String answer, Integer score){
        courseServer.editTfquestionInTask(qid, qname, answer, score);
        return "编辑成功";
    }

    @RequestMapping("dlttf")
    @ResponseBody
    public String dltTfquestion(Integer qid){
        courseServer.dltTfquestionInTask(qid);
        return "删除成功";
    }

    @RequestMapping("uploadvideo")
    public String upLoadVideo(ModelMap map, Integer crspointid, MultipartFile videofile)
    {
        String originalFilename = videofile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String headpath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\vedio\\";
        String Filename = crspointid + substring;
        File uploadFile = new File(headpath+Filename);
        System.out.println(uploadFile);
        try {
            videofile.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("editinfo")
    public String updateCrspoint(ModelMap map, Integer crspointid, String crspointname)
    {
        courseServer.updateCrspoint(crspointid, crspointname);
        return "success";
    }


}
