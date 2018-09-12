package Services;

import ServicesInterface.ManhuaImgService;
import dao.ManhuaImgMapper;
import model.ManhuaImg;
import model.ManhuaImgExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManhuaImgServiceImpl  implements ManhuaImgService {
    @Autowired
    private ManhuaImgMapper manhuaImgMapper;

    @Override
    public List<ManhuaImg> getManhuaImgByCid(Integer cid) {
        ManhuaImgExample manhuaImgExample=new ManhuaImgExample();
        ManhuaImgExample.Criteria criteria = manhuaImgExample.createCriteria();
        criteria.andCidEqualTo(cid);
        manhuaImgExample.setOrderByClause("id");
        return manhuaImgMapper.selectByExample(manhuaImgExample);
    }
}
