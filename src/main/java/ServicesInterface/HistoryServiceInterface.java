package ServicesInterface;

import model.History;

import java.util.List;

public interface HistoryServiceInterface {


    public int setHistory(History history);
    public List<History> gethistory(int uid);

    public Integer selectHistoryByid(History history);

    public History selectHistory(History history);
}
