package Controller;


import Services.CollectionService;
import model.MCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import Exception.ExampleException;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("collection")
public class CollectionController {


    @Autowired
    CollectionService service;




    @RequestMapping("/setconllection")
    @ResponseBody
    public String setConllection(MCollection mCollection, HttpSession session){
        int uid = (int)session.getAttribute("id");
        mCollection.setUid(uid);
        service.setCollection(mCollection);
        return "ok" ;
    }



    @RequestMapping("/getconllection")
    @ResponseBody
    public List<MCollection>  getConllection(HttpSession session){
        return service.getCollection((Integer) session.getAttribute("id"));
    }


    @RequestMapping("/isconllection")
    @ResponseBody
    public MCollection getConllectioninfo(MCollection mCollection ,HttpSession session) throws ExampleException {
//        Integer uid = (int)session.getAttribute("id");

        mCollection.setUid(11);
        MCollection conleectionInfo = service.getConleectionInfo(mCollection);
        if (conleectionInfo == null){
            throw  new ExampleException("没有数据");
        }

        return conleectionInfo ;
    }

}
