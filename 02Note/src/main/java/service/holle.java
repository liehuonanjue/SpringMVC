package service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mvc/")
public class holle {
    @RequestMapping("iii")
    public String showPerson(Map<String, Object> map) {
        System.out.println("主");
        map.put("p", "s");
        return "ii";
    }

    @RequestMapping(value = "add", params = "name")
    public ModelAndView add() {
        System.out.println("新增");
        ModelAndView mod = new ModelAndView("forward:iii");
        mod.addObject("p", "d");
        return mod;
    }

    @RequestMapping(value = "update", params = {"name=1", "pwd!=1"})
    public String update(Map<String, Object> map) {
        System.out.println("修改");
        map.put("p", "修改");
        //转发方式
        return "forward:iii";
    }

    @RequestMapping(value = "delete", params = "name=a")
    public String delete(Map<String, Object> map) {
        System.out.println("重定向刪除");
        map.put("p", "刪除");
        return "redirect:ii";
    }

    @RequestMapping(value = "select1")
    public String select(Map<String, Object> map) {
        System.out.println("查詢1");
        map.put("p", "查詢1");
        //List
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        map.put("bookList", list);
        //Map
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("zhangsan", "北京");
        map1.put("lisi", "上海");
        map1.put("wangwu", "深圳");
        map.put("map", map1);

        //重定向方式
        return "ii";
    }


    @RequestMapping(value = "select2")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("ii");
        mav.addObject("p", "查詢2");
        //List
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        mav.addObject("bookList", list);
        //Map
        Map<String, String> map = new HashMap<String, String>();
        map.put("zhangsan", "北京");
        map.put("lisi", "上海");
        map.put("wangwu", "深圳");
        mav.addObject("map", map);
        return mav;
    }

    /**
     * @param map  給前台传
     * @param id   PathVariable 获取路径上的id
     * @param name PathVariable  获取路径上的name
     * @param idd  @RequestParam("idd") 获取传过来的name值    表单值要一样
     * @param nam  @RequestParam("nam") 获取传过来的name值    表单值要一样
     * @return
     */
    @RequestMapping("/studen/{id}/{name}")
    public String mm(Map<String, Object> map, @PathVariable int id, @PathVariable String name, @RequestParam("idd") int idd, @RequestParam("nam") String nam) {
        System.out.println(id + "---" + name + "------" + idd + "--------" + nam);
        map.put("a", id);
        map.put("b", name);
        map.put("c", idd);
        map.put("d", nam);
        //重定向方式
        return "ii";
    }

}
