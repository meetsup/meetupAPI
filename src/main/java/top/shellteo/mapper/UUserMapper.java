package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.pojo.UUser;
import top.shellteo.pojo.UUserExample;

public interface UUserMapper {
    int countByExample(UUserExample example);

    int deleteByExample(UUserExample example);

    int deleteByPrimaryKey(String openid);

    int insert(UUser record);

    int insertSelective(UUser record);

    List<UUser> selectByExample(UUserExample example);

    UUser selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") UUser record, @Param("example") UUserExample example);

    int updateByExample(@Param("record") UUser record, @Param("example") UUserExample example);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);
}