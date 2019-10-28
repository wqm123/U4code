package cn.kgc.pcontroller;

import cn.kgc.entity.Users;
import cn.kgc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller(value = "pUsersContoller")
@RequestMapping("/page/")
public class UsersController {
    @Autowired
    private UsersService usersService;



    @RequestMapping("addUsers")

    public String addUsers(Users users){
        int i = usersService.addUsers(users);
        if (i>0){
            return "login";
        }
        return "regs";
    }
    @RequestMapping("loginUsers")
    public String loginUsers(String name, String password, HttpSession session){
        Users users = usersService.loginUser(name, password);
        if (users==null){
            return "login";
        }
        session.setAttribute("userInfo",users);
        session.setMaxInactiveInterval(600);
        return "redirect:showHouseInfoByUsers";
    }
//退出登录
    @RequestMapping("exist")
    public String exist( HttpSession session){
       session.setAttribute("userInfo",null);
        return "login";
    }

    @RequestMapping("confirmName")
    @ResponseBody
    public Map<String,Object> confirmName(String name){
        System.out.println("enter");
        int i = usersService.confirmName(name);
       Map map=new HashMap();
       map.put("result",i);
       return map;

    }
}
