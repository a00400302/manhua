package dao;

import java.util.List;
import model.ManhuaImg;
import model.ManhuaImgExample;
import org.apache.ibatis.annotations.Param;

public interface ManhuaImgMapper {
    long countByExample(ManhuaImgExample example);

    int deleteByExample(ManhuaImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManhuaImg record);

    int insertSelective(ManhuaImg record);

    List<ManhuaImg> selectByExample(ManhuaImgExample example);

    ManhuaImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManhuaImg record, @Param("example") ManhuaImgExample example);

    int updateByExample(@Param("record") ManhuaImg record, @Param("example") ManhuaImgExample example);

    int updateByPrimaryKeySelective(ManhuaImg record);

    int updateByPrimaryKey(ManhuaImg record);
}