package ServicesInterface;

import model.ManhuaInfo;

import java.util.List;

public interface ManhuaInfoService {
    public List<String>  selectType() throws  Exception;
    public List<ManhuaInfo> selectManhuaInfosByType(String type,int page);
    public ManhuaInfo selectManhhuaInfoById(Integer id);
    public List<ManhuaInfo> selectManhuaInfoByName(String name,int page);

    List<ManhuaInfo> selectAll(int page);
}
