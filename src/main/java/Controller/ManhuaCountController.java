package Controller;

import Services.ManhuaCountService;
import model.ManhuaCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ManhuaCount")
public class ManhuaCountController {
    @Autowired
    private ManhuaCountService manhuaCountService;

    @RequestMapping("/selectManhuaCountByIid")
    @ResponseBody
    public List<ManhuaCount> selectManhuaCountByIid(Integer id){
        return  manhuaCountService.selectManhuaHuaByIid(id);
    }
}
