package service;

import entin.User;
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

    @RequestMapping("studen1/login")
    public String mm(String idd, String nam, HttpSession session) {
        System.out.println(" 走1");
        System.out.println( idd + "--------" + nam);
        session.setAttribute("idd",idd);
        session.setAttribute("nam",nam);
        return "ii2";
    }

    @RequestMapping("studen2/login")
    public String mm2(User user, HttpSession session) {
        System.out.println(" 走2");
        System.out.println( user.getIdd() + "--------" + user.getNam());
        session.setAttribute("idd",user.getIdd());
        session.setAttribute("nam",user.getNam());
        return "ii2";
    }

    @RequestMapping("studen3/login")
    public String mm3(HttpServletRequest request,User user) {
        System.out.println( user.getIdd() + "--------" + user.getNam());
        request.setAttribute("idd",user.getIdd());
        request.setAttribute("nam",user.getNam());
        System.out.println("转发");
      request.setAttribute("a","吃飯");
        System.out.println(" 转发数据"+request.getAttribute("a"));
        //转发方式
        return "forward:/mvc/log";
    }
    @RequestMapping("log")
    public String mm31(User user, HttpServletRequest request) {
        System.out.println(" 转发数据"+request.getAttribute("a"));
        return "ii2";
    }

}
