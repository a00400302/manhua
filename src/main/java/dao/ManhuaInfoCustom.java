package dao;

import model.ManhuaInfo;

import java.util.List;
import java.util.Map;

public interface ManhuaInfoCustom {
    public List<ManhuaInfo> selectAll(Map map);
    public List<ManhuaInfo> selectNamePage(Map map);
    public List<ManhuaInfo> selectTypePage(Map map);

}
