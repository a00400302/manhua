package Services;

import ServicesInterface.ManhuaCountServiceInterface;
import dao.ManhuaCountMapper;
import model.ManhuaCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManhuaCountService implements ManhuaCountServiceInterface {





    @Autowired
    ManhuaCountMapper manhuaCountMapper;

    @Override
    public ManhuaCount selectByPrimaryKey(Integer id) {

        manhuaCountMapper.selectByPrimaryKey(id);

        return  manhuaCountMapper.selectByPrimaryKey(id);
    }



    @Override
    public List<ManhuaCount> selectManhuaHuaByIid(Integer id) {
        return manhuaCountMapper.selectManhuaHuaByIid(id);
    }

}
