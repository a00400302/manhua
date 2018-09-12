package Services;

import ServicesInterface.ManhuaInfoService;
import dao.ManhuaInfoCustom;
import dao.ManhuaInfoMapper;
import model.ManhuaInfo;
import model.ManhuaInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManhuaInfoServiceImpl implements ManhuaInfoService {
    @Autowired
    private ManhuaInfoMapper manhuaInfoMapper;

    @Autowired
    private ManhuaInfoCustom manhuaInfoCustom;
    /*
        查询所有漫画类型
     */
    @Override
    public List<String> selectType() throws Exception {
        List<String> typelist=manhuaInfoMapper.selectType();
        return typelist;
    }
    /*
        根据漫画类型查询该类型的漫画
     */
    @Override
    public List<ManhuaInfo> selectManhuaInfosByType(String type,int page) {
        int pagelimit = page*20;
        Map<String,Object> map= new HashMap<>();
        map.put("start",pagelimit -20);
        map.put("end",pagelimit);
        map.put("type",type);
        return  manhuaInfoCustom.selectTypePage(map);
    }

    @Override
    public ManhuaInfo selectManhhuaInfoById(Integer id) {
        ManhuaInfo manhuaInfo=null;
        manhuaInfo=manhuaInfoMapper.selectByPrimaryKey(id);
        return manhuaInfo;
    }

    @Override
    public List<ManhuaInfo> selectManhuaInfoByName(String name,int page) {
        int pagelimit = page*20;
        Map<String,Object> map= new HashMap<>();
        map.put("start",pagelimit -20);
        map.put("end",pagelimit);
        map.put("name",name);
        return manhuaInfoCustom.selectNamePage(map);
    }



    @Override
    public List<ManhuaInfo> selectAll(int page) {
        int pagelimit = page*20;
        Map<String,Object> map= new HashMap<>();
        map.put("start",pagelimit -20);
        map.put("end",pagelimit);
        return  manhuaInfoCustom.selectAll(map);
    }
}
