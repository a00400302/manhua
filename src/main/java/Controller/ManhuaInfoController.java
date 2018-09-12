package Controller;


import ServicesInterface.ManhuaInfoService;
import model.ManhuaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import Exception.ExampleException;
import java.util.List;

@Controller
@RequestMapping("/ManhuaInfo")
public class ManhuaInfoController {

    @Autowired
    private ManhuaInfoService manhuaInfoService;

    @RequestMapping("/gettypes")
    @ResponseBody
    public List<String> selectType() throws Exception {
        List<String> typelist = null;

        typelist = manhuaInfoService.selectType();
        if ( typelist == null){
            throw  new ExampleException("获取失败");
        }
        return typelist;
    }



    @RequestMapping("/getManhuaInfoById")
    @ResponseBody
    public ManhuaInfo getManhuaInfo(Integer id) throws ExampleException {
        ManhuaInfo manhuaInfo = null;
        manhuaInfo = manhuaInfoService.selectManhhuaInfoById(id);
        if(manhuaInfo == null) {
            throw  new ExampleException("获取失败");
        }
        return manhuaInfo;
    }


    @RequestMapping("/getManhuaInfoByName/name/{name}/page/{page}")
    @ResponseBody
    public List<ManhuaInfo> getManhuaInfo(@PathVariable("name") String name,@PathVariable("page") int page) {
        return manhuaInfoService.selectManhuaInfoByName(name,page);
    }




    @RequestMapping("/getAll/page/{page}")
    @ResponseBody
    public List<ManhuaInfo> getAll(@PathVariable("page") int page){
        return manhuaInfoService.selectAll(page);
    }



    @RequestMapping("/getManhuaInfosByType/type/{type}/page/{page}")
    @ResponseBody
    public List<ManhuaInfo> getManhuaInfos(@PathVariable("type") String type,@PathVariable("page") int page) throws Exception {
        return manhuaInfoService.selectManhuaInfosByType(type,page);
    }









}
