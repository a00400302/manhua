package dao;

import java.util.List;
import model.SMessage;
import model.SMessageExample;
import org.apache.ibatis.annotations.Param;

public interface SMessageMapper {
    long countByExample(SMessageExample example);

    int deleteByExample(SMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SMessage record);

    int insertSelective(SMessage record);

    List<SMessage> selectByExampleWithBLOBs(SMessageExample example);

    List<SMessage> selectByExample(SMessageExample example);

    SMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SMessage record, @Param("example") SMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") SMessage record, @Param("example") SMessageExample example);

    int updateByExample(@Param("record") SMessage record, @Param("example") SMessageExample example);

    int updateByPrimaryKeySelective(SMessage record);

    int updateByPrimaryKeyWithBLOBs(SMessage record);

    int updateByPrimaryKey(SMessage record);
}