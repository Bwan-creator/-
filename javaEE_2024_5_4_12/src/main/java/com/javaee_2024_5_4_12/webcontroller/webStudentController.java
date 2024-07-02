package com.javaee_2024_5_4_12.webcontroller;

import com.javaee_2024_5_4_12.Service.ClassService;
import com.javaee_2024_5_4_12.Service.CollegeService;
import com.javaee_2024_5_4_12.Service.StudentService;
import com.javaee_2024_5_4_12.entity.ClassInfo;
import com.javaee_2024_5_4_12.entity.CollegeInfo;
import com.javaee_2024_5_4_12.entity.StudentInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
//@Controller和@RestController的区别在于，第一个返回的时候整个网页
//第二个返回的时候网页需要的数据。整个网页由前端自己生成。
public class webStudentController {
    @Autowired
    private StudentService stuService;

    @Autowired
    private ClassService classService;

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("show_stu_login")
    public String showStuLogin(){
        return "stu_login";
        //stu_login的意思是，必须在templates目录下面有一个和
        // 它同名的stu_login.html后缀的网页
    }

    @RequestMapping("check_stu_login")
    public String checkStuLogin(HttpServletRequest request, Model model){
        String stuNo = request.getParameter("stu_no");
        String stuPwd = request.getParameter("stu_pwd");

        System.out.println("前端的数据是" + stuNo + "----" + stuPwd);

        StudentInfo stuInfo = stuService.checkstuLogin(stuNo,stuPwd);
        //验证数据
        if (stuInfo != null){
            //进入主页面
            System.out.println(stuInfo.toString());
            model.addAttribute("no",stuNo);
            model.addAttribute("pwd",stuPwd);
            return "stu_main";
        }
        else {
            //重定向会原来的请求，重新输入密码和账号
            return "redirect:show_stu_login";
            //redirect:重新定义方向的意思。后面的show_stu_login是请求名
        }
    }

    @RequestMapping("get_stu_list")
    public String getStuList(HttpServletRequest request,Model model){
//        int collegeId = Integer.parseInt(request.getParameter("college_id"));
        String qry_field = request.getParameter("qry_field");
        String qry_condition = request.getParameter("qry_condition");
        int current_page = Integer.parseInt(request.getParameter("current_page"));
        if (current_page <= 0)
            current_page=1;
        int page_size = Integer.parseInt(request.getParameter("page_size"));
        System.out.println("来自前端的数据：" + qry_field + "------" + qry_condition + "------" + current_page + "-------" + page_size );
        List<StudentInfo> stuList =new ArrayList<StudentInfo>();

        stuList =  stuService.getStuList(qry_field,qry_condition,current_page,page_size);
        System.out.println("来自后端collegeId的数据：" + stuList.size());

        model.addAttribute("qry_field",qry_field);
        model.addAttribute("qry_condition",qry_condition);
        model.addAttribute("current_page",current_page);
        model.addAttribute("page_size",page_size);

        model.addAttribute("stu_List",stuList);
        return "stu_lists";
    }

    @RequestMapping("show_a_edit_stu")
    public String showAEditStu(HttpServletRequest request ,Model model){
        String stuNo = request.getParameter("stu_no");
        System.out.println("来自前端的数据" + stuNo);

        StudentInfo a_stu = stuService.getAEditStu(stuNo);
        System.out.println("来自后端的数据" + a_stu.toString());

        List<ClassInfo> classInfoList = classService.getClassList();
        System.out.println("来自后端的Classinfolist数据" + classInfoList.size());

        List<CollegeInfo> collegeInfoList = collegeService.getCollegeList();
        System.out.println("来自后端的Collegeinfolist数据" +collegeInfoList.size());

        model.addAttribute("a_stu",a_stu);
        model.addAttribute("class_list",classInfoList);
        model.addAttribute("college_list",collegeInfoList);
        return "a_edit_stu";
    }

    @RequestMapping("edit_a_stu")
    public String editAStu(StudentInfo stu, RedirectAttributes attr){
        System.out.println("来自前端修改后的数据：" + stu.toString());

        int flag = 0;
        flag = stuService.saveAEditStu(stu);
        if(flag > 0){
            attr.addAttribute("college_id",1);
            attr.addAttribute("current_page",1);
            attr.addAttribute("page_size",10);
            attr.addAttribute("qry_field", "si.stu_no");
            attr.addAttribute("qry_condition", "");
            return "redirect:get_stu_list";
        }else {
            return "";
        }
    }

    @RequestMapping("show_a_add_stu")
    public String showAAddStu(HttpServletRequest request ,Model model){

        List<ClassInfo> classInfoList = classService.getClassList();
        System.out.println("来自后端的Classinfolist数据" + classInfoList.size());

        List<CollegeInfo> collegeInfoList = collegeService.getCollegeList();
        System.out.println("来自后端的Collegeinfolist数据" +collegeInfoList.size());

        model.addAttribute("class_list",classInfoList);
        model.addAttribute("college_list",collegeInfoList);
        return "a_add_stu";
    }

    @RequestMapping("add_a_stu")
    public String addAStu(StudentInfo stu, RedirectAttributes attr){
        System.out.println("来自前端添加后的数据：" + stu.toString());

        int flag = 0;
        flag = stuService.insertAStudent(stu);
        if(flag > 0){
            attr.addAttribute("college_id",1);
            attr.addAttribute("current_page",1);
            attr.addAttribute("page_size",10);
            attr.addAttribute("qry_field", "si.stu_no");
            attr.addAttribute("qry_condition", "");
            return "redirect:get_stu_list";
        }else {
            return "";
        }
    }

//    @RequestMapping("delete_a_stu")
//    public String deleteAStu(HttpServletRequest request, RedirectAttributes attr){
//        String stu_no = request.getParameter("stu_no");
//        String qry_field = request.getParameter("qry_field");
//        String qry_condition = request.getParameter("qry_condition");
//        int current_page = Integer.parseInt(request.getParameter("current_page"));
//        if (current_page <= 0)
//            current_page=1;
//        int page_size = Integer.parseInt(request.getParameter("page_size"));
//        System.out.println("来自前端的数据：" + qry_field + "------" + qry_condition + "------" + current_page + "-------" + page_size );
//
//        int flag = 0;
//        flag = stuService.deleteAStudent(stu_no);
//        if(flag > 0){
//            attr.addAttribute("qry_field",qry_field);
//            attr.addAttribute("qry_condition",qry_condition);
//            attr.addAttribute("current_page",current_page);
//            attr.addAttribute("page_size",page_size );
//            return "redirect:get_stu_list";
//        }else {
//            return "";
//        }
//    }
@RequestMapping("delete_a_stu")
public String deleteAStu(HttpServletRequest request, RedirectAttributes attr){
    String stu_no = request.getParameter("stu_no");
    int flag = 0;
    flag = stuService.deleteAStudent(stu_no);
    if(flag > 0){
        attr.addAttribute("college_id",1);
        attr.addAttribute("current_page",0);
        attr.addAttribute("page_size",10);
        attr.addAttribute("qry_field", "si.stu_no");
        attr.addAttribute("qry_condition", "");
        return "redirect:get_stu_list";
    }else {
        return "";
    }
}
}

