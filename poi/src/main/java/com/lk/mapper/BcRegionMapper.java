package com.lk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lk.pojo.BcRegion;
import com.lk.pojo.BcRegionExample;

public interface BcRegionMapper {
    int countByExample(BcRegionExample example);

    int deleteByExample(BcRegionExample example);

    int deleteByPrimaryKey(String rId);

    int insert(BcRegion record);

    int insertSelective(BcRegion record);
    int insertList(List<Object> list);

    List<BcRegion> selectByExample(BcRegionExample example);

    BcRegion selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByExample(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByPrimaryKeySelective(BcRegion record);

    int updateByPrimaryKey(BcRegion record);
}