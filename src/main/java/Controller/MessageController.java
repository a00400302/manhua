package Controller;


import Services.MessageService;
import model.Message;
import model.SMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("message")
public class MessageController {


    @Autowired
    MessageService service;


    @RequestMapping("/setmessage")
    @ResponseBody
    public String setMessage(Message message, HttpSession session){
        int uid = (int)session.getAttribute("id");
        message.setUid(uid);
        service.setMessage(message);
        return "ok" ;
    }



    @RequestMapping("/getmessage")
    @ResponseBody
    public List<Message> getMessage(HttpSession session){
        return service.getMessage((Integer) session.getAttribute("id"));
    }



    @RequestMapping("/setsmessage")
    @ResponseBody
    public String setSmessage(SMessage sMessage, HttpSession session){
        int uid = (int)session.getAttribute("id");
        sMessage.setUid(uid);
        service.setSMessage(sMessage);
        return "ok" ;
    }



    @RequestMapping("/getsmessage")
    @ResponseBody
    public List<SMessage> getSmessage(HttpSession session){
        return service.getSMessage((Integer) session.getAttribute("id"));
    }


    //被评论
    @RequestMapping("/Becommented")
    @ResponseBody
    List<SMessage> getMessage(SMessage sMessage,HttpSession session){
        List<SMessage> sMessages = new ArrayList<>();
        for (Message message : service.getMessage((int)session.getAttribute("id"))) {
            SMessage sMessage1 = new SMessage();
            sMessage1.setMid(message.getMid());
            sMessages.addAll(service.getSMessageByMid(sMessage1)) ;
        }
        return  sMessages;
    }









}
