package com.lk.service;
/**
 * @author 徐东东
 *
 * 创建时间：2018年9月30日 上午10:57:52
 */

import java.util.List;

import com.lk.commons.utils.EasyUIDgResult;
import com.lk.commons.vo.MsgResult;
import com.lk.pojo.BcRegion;

public interface IQyservice {
//  查询
	public List<BcRegion> findAll();
//	保存
	public MsgResult save(BcRegion bcRegion);
//添加集合
	public MsgResult saveList(List<Object> list);
//	修改
	public int updateBcRegion(BcRegion bcRegion);
//	修改保存
	public MsgResult exitSave(BcRegion bcRegion);
//	分页查询
	public EasyUIDgResult findItemsByPage(int pageNum,int pageSize);
//删除
	public String delete(String id);
	
	
}
