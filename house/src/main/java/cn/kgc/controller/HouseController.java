package cn.kgc.controller;

import cn.kgc.entity.ExtHouse;
import cn.kgc.service.HouseService;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("queryHouseByIspass")
    @ResponseBody
    //查询未审核的房屋
    public Map<String,Object> queryHouseByIspass(PageUtil pageUtil){
        PageInfo<ExtHouse> pageInfo = houseService.queryHouseByIspass(pageUtil,0);
        Map map=new HashMap();
        //返回分页的数据
        map.put("rows",pageInfo.getList());
        //返回总记录数
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("queryHouseHavingCheck")
    @ResponseBody
    //查询审核通过的房屋
    public Map<String,Object> queryHouseHavingCheck(PageUtil pageUtil){
        PageInfo<ExtHouse> pageInfo = houseService.queryHouseByIspass(pageUtil,1);
        Map map=new HashMap();
        //返回分页的数据
        map.put("rows",pageInfo.getList());
        //返回总记录数
        map.put("total",pageInfo.getTotal());
        return map;
    }

    //审核未通过的房屋
    @RequestMapping("checkHouse")
    @ResponseBody
    public String checkHouse(String id){
        int i = houseService.checkHouse(id, 1);
        return "{\"result\":"+i+"}";

    }

    //取消审核通过的房屋
    @RequestMapping("CancelCheckHouse")
    @ResponseBody
    public String CancelCheckHouse(String id){
        int i = houseService.checkHouse(id, 0);
        return "{\"result\":"+i+"}";

    }
}
