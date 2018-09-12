package dao;

import java.util.List;
import model.ManhuaInfo;
import model.ManhuaInfoExample;
import org.apache.ibatis.annotations.Param;

public interface ManhuaInfoMapper {
    long countByExample(ManhuaInfoExample example);

    int deleteByExample(ManhuaInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManhuaInfo record);

    int insertSelective(ManhuaInfo record);

    List<ManhuaInfo> selectByExampleWithBLOBs(ManhuaInfoExample example);

    List<ManhuaInfo> selectByExample(ManhuaInfoExample example);

    ManhuaInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManhuaInfo record, @Param("example") ManhuaInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ManhuaInfo record, @Param("example") ManhuaInfoExample example);

    int updateByExample(@Param("record") ManhuaInfo record, @Param("example") ManhuaInfoExample example);

    int updateByPrimaryKeySelective(ManhuaInfo record);

    int updateByPrimaryKeyWithBLOBs(ManhuaInfo record);

    int updateByPrimaryKey(ManhuaInfo record);

    /*
    自定义
 */
    List<String> selectType() throws Exception;
}