package com.zlt.mapper;

import com.zlt.entity.Weibo;
import com.zlt.entity.WeiboExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeiboMapper {
    long countByExample(WeiboExample example);

    int deleteByExample(WeiboExample example);

    int deleteByPrimaryKey(Long wid);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    List<Weibo> selectByExample(WeiboExample example);

    Weibo selectByPrimaryKey(Long wid);

    int updateByExampleSelective(@Param("record") Weibo record, @Param("example") WeiboExample example);

    int updateByExample(@Param("record") Weibo record, @Param("example") WeiboExample example);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKey(Weibo record);
}