package dao;

import java.util.List;
import model.ManhuaCount;
import model.ManhuaCountExample;
import org.apache.ibatis.annotations.Param;

public interface ManhuaCountMapper {
    long countByExample(ManhuaCountExample example);

    int deleteByExample(ManhuaCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManhuaCount record);

    int insertSelective(ManhuaCount record);

    List<ManhuaCount> selectByExample(ManhuaCountExample example);

    ManhuaCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManhuaCount record, @Param("example") ManhuaCountExample example);

    int updateByExample(@Param("record") ManhuaCount record, @Param("example") ManhuaCountExample example);

    int updateByPrimaryKeySelective(ManhuaCount record);

    int updateByPrimaryKey(ManhuaCount record);

    //  2018/9/12
    List<ManhuaCount> selectManhuaHuaByIid(Integer id);
}