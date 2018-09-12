package dao;

import model.History;

public interface HistoryCustom {



    Integer selectCidHistoryByid(History history);
    History selectIdHistoryByid(History history);
}
