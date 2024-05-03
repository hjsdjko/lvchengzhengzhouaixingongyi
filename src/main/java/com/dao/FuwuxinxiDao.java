package com.dao;

import com.entity.FuwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwuxinxiView;

/**
 * 服务信息 Dao 接口
 *
 * @author 
 */
public interface FuwuxinxiDao extends BaseMapper<FuwuxinxiEntity> {

   List<FuwuxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
