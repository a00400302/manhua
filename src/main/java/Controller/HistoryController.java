package Controller;


import Services.HistoryService;
import Services.ManhuaCountService;
import model.History;
import model.ManhuaCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("history")
public class HistoryController {




    @Autowired
    HistoryService historyService;



    @Autowired
    ManhuaCountService manhuaCountService;

    @RequestMapping("/sethistory")
    @ResponseBody
    public String setHistory(History history,HttpSession session){
        int uid = (int)session.getAttribute("id");
        if(manhuaCountService.selectByPrimaryKey(history.getCid()) == null){
            history.setUid(uid);
            historyService.setHistory(history);
        }else {
            History history1 = historyService.selectHistory(history);
            history1.setUid(uid);
            history1.setCid(history.getCid());
            historyService.updateHistory(history1);
        }
        return "ok" ;
    }



    @RequestMapping("/gethistory")
    @ResponseBody
    public List<History> getHistory(HttpSession session){
        return historyService.gethistory((int)session.getAttribute("id"));
    }





    @RequestMapping("/getmanhuahistory")
    @ResponseBody
    public ManhuaCount getManhuahistory(History history,HttpSession session){
        int uid = (int)session.getAttribute("id");
        history.setUid(uid);
        Integer cid = historyService.selectHistoryByid(history);
        return manhuaCountService.selectByPrimaryKey(cid);
    }

}
