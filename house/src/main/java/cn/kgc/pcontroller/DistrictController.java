package cn.kgc.pcontroller;

import cn.kgc.entity.District;
import cn.kgc.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("districtController2")
@RequestMapping("/page/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
     return    districtService.getAllDistrict();
    }
}
