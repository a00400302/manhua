package ServicesInterface;

import model.Message;
import model.SMessage;

import java.util.List;

public interface MessageServiceInterface {


    List<Message> getMessage(int uid);

    List<SMessage> getSMessage(int uid);


    int setMessage(Message message);


    int setSMessage(SMessage smessage);

    List<Message>  getMessageByCount(Message message);

    List<SMessage> getSMessageByMid(SMessage sMessage);


}
