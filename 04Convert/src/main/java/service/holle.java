package service;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class holle {

    @RequestMapping("/studen")
    public void studen(String idd, String nam, Date birthday) {
        System.out.println(4444);
        System.out.println(idd + "--------" + nam);
        System.out.println(birthday);
    }

    //    提前加载
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println(1111);
        binder.registerCustomEditor(Date.class, new MyEditor());
    }


    @RequestMapping("ll")
    public String mmm() {
        System.out.println("进来");
        return "ii";
    }
}
