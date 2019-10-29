package cn.kgc.pcontroller;

import cn.kgc.entity.ExtHouse;
import cn.kgc.entity.House;
import cn.kgc.entity.Users;
import cn.kgc.service.HouseService;
import cn.kgc.utils.HouseCondition;
import cn.kgc.utils.sms.SentMsgUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller("HouseController2")
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("addHouse")
    public String addHouse(House house, HttpSession session, @RequestParam(value = "pfile",required = false) MultipartFile pfile){
        try {
            //文件名字
            /* System.out.println(pfile.getOriginalFilename());*/
            //获取文件名和后缀
            String originalFilename = pfile.getOriginalFilename();
            //截取后缀
            String extName=originalFilename.substring(originalFilename.lastIndexOf("."));
            //毫秒
            String bh=System.currentTimeMillis()+"";
            //文件名。毫秒时间加后缀
            String fileName=bh+extName;
            //文件保存的位置
            String path="D:\\uploads\\"+fileName;
            //创建文件
            File saveFile = new File(path);
            //上传文件
            pfile.transferTo(saveFile);
            //设置编号
            house.setId(bh);
            house.setPath(fileName);
            house.setIsdel(0);
            house.setIspass(0);
            Users userInfo = (Users) session.getAttribute("userInfo");
            house.setUserId(userInfo.getId());
            houseService.addHouse(house);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fabu";
    }


    @RequestMapping("showHouseInfoByUsers")
    public String showHouseInfoByUsers(HttpSession session, HttpServletRequest request){
        Users users = (Users) session.getAttribute("userInfo");
        List<ExtHouse> list = houseService.showHouseInfoByUsers(users.getId());
        request.setAttribute("list",list);
        return "guanli";
    }

    //回显修改房屋信息
    @RequestMapping("queryHouseById")
    public String queryHouseById(String id, Model model){//HttpSession session, @RequestParam(value = "pfile",required = false) MultipartFile pfile
        ExtHouse house = houseService.queryHouseById(id);
        model.addAttribute("house",house);
        return "upfabu";
    }

    //更新房屋操作
    @RequestMapping("updateHouse")
    public String updateHouse(ExtHouse house,String oldFile, @RequestParam(value = "pfile")MultipartFile file){
        try {
            if (!file.isEmpty()) {
                //文件名字
                String originalFilename = file.getOriginalFilename();
                String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
                long timeName = System.currentTimeMillis();
                String fileName=timeName+extName;
                //文件保存的位置
                String path="D:\\uploads\\"+fileName;
                File file1 = new File(path);
                file.transferTo(file1);
                house.setPath(fileName);

            }
            houseService.updateHouse(house);
            if (!file.isEmpty()){
                //更新图片后删除旧图片
                File delFile = new File("D:\\uploads\\"+oldFile);
                delFile.delete();
            }
            return "redirect:showHouseInfoByUsers";
        } catch (IOException e) {
            e.printStackTrace();
        }
       return "error";
    }



    //删除房屋操作
    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
        int i = houseService.delHouse(id, 1);
        return "{\"result\":"+i+"}";

    }
//带条件查询房屋信息
    @RequestMapping("searchHouse")
    public String queryHouseByCondition(HouseCondition condition,Model model){
       condition.setRows(2);
        PageInfo<ExtHouse> pageInfo = houseService.queryHouseByCondition(condition);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("condition",condition);
        return "list";

    }


    //手机号发送短信
    @RequestMapping("sendMess")
    @ResponseBody
    public String sendMess(String tel,HttpSession session){
        String code= (int) Math.random() * 1000 + 1000+"";
        session.setAttribute("code",code);
        int i=0;
        if (tel!=null&&!tel.isEmpty()){
            i = SentMsgUtil.sendMsg(tel, code);
        }
        if (i>0){
            return "{\"result\":"+1+"}";
        }
        return "{\"result\":"+0+"}";
    }
//通过手机验证码验证
    @RequestMapping("confirm")
    public String confirm(String code,HttpSession session){
        Object o = session.getAttribute("code");
        if (code.equals(o.toString())){
            return "界面";
        }
        return "登录";
    }
}
