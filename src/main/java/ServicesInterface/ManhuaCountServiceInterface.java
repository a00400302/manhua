package ServicesInterface;

import model.ManhuaCount;

import java.util.List;

public interface ManhuaCountServiceInterface {

    ManhuaCount selectByPrimaryKey(Integer id);

    public List<ManhuaCount> selectManhuaHuaByIid(Integer iid);
}
