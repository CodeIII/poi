package com.lk.service.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.commons.utils.EasyUIDgResult;
import com.lk.commons.vo.MsgResult;
import com.lk.mapper.BcRegionMapper;
import com.lk.pojo.BcRegion;
import com.lk.pojo.BcRegionExample;
import com.lk.service.IQyservice;

/**
 * @author 徐东东
 *
 *         创建时间：2018年9月30日 上午11:02:29
 */
@Service
public class QyserviceImp implements IQyservice {

	@Autowired
	private BcRegionMapper bcMapper;

	@Override
	public List<BcRegion> findAll() {
		BcRegionExample example = new BcRegionExample();
		List<BcRegion> list = bcMapper.selectByExample(example);
		return list;
	}

	// 保存
	@Override
	public MsgResult save(BcRegion bcRegion) {
		// 补齐缺失属性值
		String rId = UUID.randomUUID().toString().replaceAll("-", "");
		bcRegion.setrId(rId);
		MsgResult result = new MsgResult();
		int i = bcMapper.insert(bcRegion);

		if (i >= 1) {
			result.setStatus(200);
			result.setMessage("成功！");
		} else {
			result.setStatus(-1);
			result.setMessage("失败！");
		}
		return result;

	}
	// 修改

	@Override
	public int updateBcRegion(BcRegion bcRegion) {

		return bcMapper.updateByPrimaryKey(bcRegion);
	}

	// 分页查询
	@Override
	public EasyUIDgResult findItemsByPage(int pageNum, int pageSize) {
		BcRegionExample example = new BcRegionExample();
		PageHelper.startPage(pageNum, pageSize);// 添加分页逻辑
		List<BcRegion> list = bcMapper.selectByExample(example);
		EasyUIDgResult result = new EasyUIDgResult();
		PageInfo info = new PageInfo(list);// 提取分页信息
		long total = info.getTotal();// 获取总记录数
		result.setRows(list);
		result.setTotal(total);
		return result;
	}

	@Override
	public MsgResult exitSave(BcRegion bcRegion) {
		
		MsgResult result = new MsgResult();
		int i = bcMapper.updateByPrimaryKey(bcRegion);

			if (i >= 0) {
				result.setStatus(200);
				result.setMessage("成功！");
			} else {
				result.setStatus(-1);
				result.setMessage("失败！");
			}
			return result;
		}

	@Override
	public String delete(String id) {
		int i = bcMapper.deleteByPrimaryKey(id);
		return i>0?"删除成功":"删除失败";
	}

	@Override
	public MsgResult saveList(List<Object> list) {
		
		// 补齐缺失属性值
//				String rId = UUID.randomUUID().toString().replaceAll("-", "");
//				bcRegion.setrId(rId);
				MsgResult result = new MsgResult();
				int i = bcMapper.insertList(list);

				if (i >= 1) {
					result.setStatus(200);
					result.setMessage("成功！");
				} else {
					result.setStatus(-1);
					result.setMessage("失败！");
				}
				return result;
	}

}
