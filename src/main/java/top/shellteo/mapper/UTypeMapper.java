package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.pojo.UType;
import top.shellteo.pojo.UTypeExample;

public interface UTypeMapper {
    int countByExample(UTypeExample example);

    int deleteByExample(UTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UType record);

    int insertSelective(UType record);

    List<UType> selectByExample(UTypeExample example);

    UType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UType record, @Param("example") UTypeExample example);

    int updateByExample(@Param("record") UType record, @Param("example") UTypeExample example);

    int updateByPrimaryKeySelective(UType record);

    int updateByPrimaryKey(UType record);
}