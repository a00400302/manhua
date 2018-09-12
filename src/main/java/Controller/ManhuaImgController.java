package Controller;

import ServicesInterface.ManhuaImgService;
import model.ManhuaImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ManhuaImg")
public class ManhuaImgController {

    @Autowired
    private ManhuaImgService manhuaImgService;

    @RequestMapping("/getManhuaImgByCid")
    @ResponseBody
    public List<ManhuaImg> getManhuaImgByCid(Integer cid){
        return  manhuaImgService.getManhuaImgByCid(cid);
    }
}
