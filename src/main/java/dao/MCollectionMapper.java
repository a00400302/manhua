package dao;

import java.util.List;
import model.MCollection;
import model.MCollectionExample;
import org.apache.ibatis.annotations.Param;

public interface MCollectionMapper {
    long countByExample(MCollectionExample example);

    int deleteByExample(MCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MCollection record);

    int insertSelective(MCollection record);

    List<MCollection> selectByExample(MCollectionExample example);

    MCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MCollection record, @Param("example") MCollectionExample example);

    int updateByExample(@Param("record") MCollection record, @Param("example") MCollectionExample example);

    int updateByPrimaryKeySelective(MCollection record);

    int updateByPrimaryKey(MCollection record);
}