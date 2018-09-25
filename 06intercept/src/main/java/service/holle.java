package service;

import entin.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class holle {
    //    过滤器
    @RequestMapping("/login")
    public ModelAndView mm2(@Validated User user, BindingResult result) {
        System.out.println(" 走1");
        ModelAndView mv = new ModelAndView("index2.jsp");
        System.out.println(user.getName());
        if (result.hasErrors()) {
            System.out.println(" 走2");
            if (result.getFieldError("name") != null)
                mv.addObject("nameErrors", result.getFieldError("name").getDefaultMessage());

            if (result.getFieldError("pwd") != null)
                mv.addObject("pwdErrors", result.getFieldError("pwd").getDefaultMessage());

            if (result.getFieldError("email") != null)
                mv.addObject("emailErrors", result.getFieldError("email").getDefaultMessage());

            if (result.getFieldError("phone") != null)
                mv.addObject("phoneErrors", result.getFieldError("phone").getDefaultMessage());

            mv.setViewName("index.jsp");
        }
        return mv;
    }

    //    上传多个
    @RequestMapping("/file")
    public String filesingle(@RequestParam MultipartFile[] file, HttpSession session) {
        String path = session.getServletContext().getRealPath("/index3");
        File file1 = new File(path);
        if (!file1.exists()) file1.mkdir();  // 如果文件不存在  则创建文件夹
//        获取上传文件夹的名称
        for (MultipartFile multipartFile : file) {
            String fileName = multipartFile.getOriginalFilename();
            try {
                multipartFile.transferTo(new File(path, fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(path);
        }
        return "index2.jsp";
    }


    //    下载
    @RequestMapping(value = "/download", method = RequestMethod.GET) //匹配的是href中的download请求
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename) throws IOException {

        String downloadFilePath = request.getSession().getServletContext().getRealPath("/js");//从我们的上传文件夹中去取

        File file = new File(downloadFilePath ,filename);//新建一个文件

        HttpHeaders headers = new HttpHeaders();//http头信息

        String downloadFileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");//设置编码

        headers.setContentDispositionFormData("attachment", downloadFileName);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

    }

    //json
    @RequestMapping("/json")
    @ResponseBody
    public List<User> getJson() {
        System.out.println("3=====>进入 User");
        List<User> list = new ArrayList<>();
        list.add(new User("d", "d", "d", "d"));
        list.add(new User("d", "d", "d", "d"));
        list.add(new User("d", "d", "d", "d"));
        list.add(new User("d", "d", "d", "d"));
        return list;
    }
}