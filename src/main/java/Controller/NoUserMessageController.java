package Controller;


import Services.MessageService;
import model.Message;
import model.SMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("nousermessage")
public class NoUserMessageController {

    @Autowired
    MessageService service;
    //下面两个不拦截
    @RequestMapping("/getMessageInfo")
    @ResponseBody
    public List<Message> getMessageInfo(Message message){
        return  service.getMessageByCount(message);
    }


    @RequestMapping("/getSessageInfo")
    @ResponseBody
    public List<SMessage> getSessageInfo(SMessage sMessage){
        return  service.getSMessageByMid(sMessage);
    }
}
