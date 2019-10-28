package cn.kgc.controller;

import cn.kgc.entity.Type;
import cn.kgc.service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> queryAll(){
       return typeService.getAllType();
    }
    @RequestMapping("getTypeByPage")
    @ResponseBody
    public Map<String,Object> getTypeByPage(PageUtil pageUtil){
        PageInfo<Type> pageInfo = typeService.getTypeByPage(pageUtil);
        List<Type> list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    /**
     * 添加的业务
     * @return
     */
    @RequestMapping("addType")
    @ResponseBody
    public Map<String,Object> addType(Type Type){
        int i = typeService.addType(Type);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }
    @RequestMapping("delType")
    @ResponseBody
    public Map<String,Object> delType(Integer id){
        int i = typeService.delType(id);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }

   /* @RequestMapping("delTypes")
    @ResponseBody
    public Map<String,Object> delTypes(Integer[] ids){
        System.out.println(ids);
        int i = typeService.delTypes(ids);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }*/
/*批量删除*/
    @RequestMapping("delMoreTypes")
    @ResponseBody
    public Map<String,Object> delMoreTypes(@RequestParam(value = "ids[]") Integer[] ids){
        int i = typeService.deleteTypes(ids);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }

    @RequestMapping("findTypeById")
    @ResponseBody
    public Type findTypeById(Integer id){
        return typeService.findTypeById(id);

    }
    @RequestMapping("updateType")
    @ResponseBody
    public Map<String,Object> updateType(Type Type){
        int i = typeService.updateType(Type);
        Map map=new HashMap();
        map.put("result",i);
        return map;
    }
}
