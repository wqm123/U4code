package cn.kgc.controller;

import cn.kgc.entity.Users;
import cn.kgc.service.UsersService;
import cn.kgc.utils.UsersCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("getUsersByPage")
    @ResponseBody
    public Map<String,Object> getUsersByPage(UsersCondition usersCondition){
        PageInfo<Users> usersByCondition = usersService.getUsersByCondition(usersCondition);
        List<Users> list = usersByCondition.getList();
        long total = usersByCondition.getTotal();
        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
}
