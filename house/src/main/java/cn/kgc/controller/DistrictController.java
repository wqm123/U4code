package cn.kgc.controller;

import cn.kgc.entity.District;
import cn.kgc.service.DistrictService;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class DistrictController {
    @Autowired
    private DistrictService distinctService;
    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> queryAll(){
       return distinctService.getAllDistrict();
    }
    @RequestMapping("getDistrictByPage")
    @ResponseBody
    public Map<String,Object> getDistrictByPage(PageUtil pageUtil){
        PageInfo<District> pageInfo = distinctService.getDistrictByPage(pageUtil);
        List<District> list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    /**
     * 添加的业务
     * @return district
     *
     */
    @RequestMapping("addDistrict")
    @ResponseBody
    public Map<String,Object> addDistrict(District district){
        int i = distinctService.addDistrict(district);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }
    @RequestMapping("delDistrict")
    @ResponseBody
    public Map<String,Object> delDistrict(Integer id){
        int i = distinctService.delDistrict(id);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }

   /* @RequestMapping("delDistricts")
    @ResponseBody
    public Map<String,Object> delDistricts(Integer[] ids){
        System.out.println(ids);
        int i = distinctService.delDistricts(ids);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }*/
/*批量删除*/
    @RequestMapping("delMoreDistricts")
    @ResponseBody
    public Map<String,Object> delMoreDistricts(@RequestParam(value = "ids[]") Integer[] ids){
        int i = distinctService.deleteDistricts(ids);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }

    @RequestMapping("findDistrictById")
    @ResponseBody
    public District findDistrictById(Integer id){
        return distinctService.findDistrictById(id);

    }
    @RequestMapping("updateDistrict")
    @ResponseBody
    public Map<String,Object> updateDistrict(District district){
        int i = distinctService.updateDistrict(district);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }
}
