package Services;


import ServicesInterface.HistoryServiceInterface;
import dao.HistoryCustom;
import dao.HistoryMapper;
import model.History;
import model.HistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bee
 */
@Service
public class HistoryService implements HistoryServiceInterface {


    @Autowired
    HistoryCustom historyCustom;




    private final
    HistoryMapper historyMapper;

    @Autowired
    public HistoryService(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }


    @Override
    public int setHistory(History history) {
        return historyMapper.insert(history);
    }

    @Override
    public List<History> gethistory(int uid) {
        HistoryExample historyExample = new HistoryExample();
        historyExample.createCriteria().andUidEqualTo(uid);
        return historyMapper.selectByExample(historyExample);
    }

    @Override
    public Integer selectHistoryByid(History history) {
        return historyCustom.selectCidHistoryByid(history);
    }



    @Override
    public History selectHistory(History history) {
        return historyCustom.selectIdHistoryByid(history);
    }

    public  Integer updateHistory(History history){
        HistoryExample historyExample = new HistoryExample();
        historyExample.createCriteria().andUidEqualTo(history.getUid()).andMidEqualTo(history.getMid());
//        history.setMid(null);
        return historyMapper.updateByExample(history, historyExample);
    }

}



