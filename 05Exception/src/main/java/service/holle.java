package service;

import entin.User;
import exception.AgeException;
import exception.NameException;
import exception.PwdException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mvc/")
public class holle {



    @RequestMapping("ageexception")
    public String mm1() {
        System.out.println("异常");
        if (true){
            throw  new AgeException("年齡異常");
        }
        return "ii2";
    }
    @RequestMapping("nameexception")
    public String mm2() {
        System.out.println("异常");
        if (true){
            throw  new NameException("名称異常");
        }
        return "ii2";
    }
    @RequestMapping("pwdexception")
    public String mm3() {
        System.out.println("异常");
        if (true){
            throw  new PwdException("密码異常");
        }
        return "ii2";
    }
    @RequestMapping("ortexception")
    public String mm() {
        System.out.println(5/0);
        return "ii2";
    }
}
