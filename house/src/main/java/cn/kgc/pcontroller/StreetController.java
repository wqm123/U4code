package cn.kgc.pcontroller;

import cn.kgc.entity.Street;
import cn.kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "StreetController2")
@RequestMapping("/page/")
public class StreetController {
    @Autowired
    private StreetService streetService;
    @RequestMapping("queryStreetById")
    @ResponseBody
    public List<Street> queryStreetById(Integer districtId){
      return   streetService.queryStreetById(districtId);
    }
}
