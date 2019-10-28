package cn.kgc.pcontroller;

import cn.kgc.entity.Type;
import cn.kgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "typeController2")
@RequestMapping("/page/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    /**
     * 获取房屋类型
     * @return
     */
    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> queryAll(){
        return typeService.getAllType();
    }
}
