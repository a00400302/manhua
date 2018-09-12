package Services;

import ServicesInterface.MessageServiceInterface;
import dao.MessageMapper;
import dao.SMessageMapper;
import model.Message;
import model.MessageExample;
import model.SMessage;
import model.SMessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService implements MessageServiceInterface {


    @Autowired
    MessageMapper messageMapper;

    @Autowired
    SMessageMapper sMessageMapper;





    @Override
    public List<Message> getMessage(int uid) {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andUidEqualTo(uid);
        List<Message> Messages = messageMapper.selectByExample(messageExample);
        return  Messages;
    }

    @Override
    public List<SMessage> getSMessage(int uid) {
        SMessageExample sMessageExample = new SMessageExample();
        sMessageExample.createCriteria().andUidEqualTo(uid);
        List<SMessage> sMessages = sMessageMapper.selectByExample(sMessageExample);
        return sMessages;
    }


    @Override
    public int setMessage(Message message) {
        return  messageMapper.insert(message);
    }


    @Override
    public int setSMessage(SMessage smessage) {
        return  sMessageMapper.insert(smessage);
    }

    @Override
    public List<Message> getMessageByCount(Message message) {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andUidEqualTo(message.getMid());
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return messages;
    }



    @Override
    public List<SMessage> getSMessageByMid(SMessage sMessage){
        SMessageExample sMessageExample = new SMessageExample();
        sMessageExample.createCriteria().andUidEqualTo(sMessage.getMid());
        List<SMessage> sMessages = sMessageMapper.selectByExample(sMessageExample);
        return sMessages;
    }


}
