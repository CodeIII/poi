package com.lk.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lk.commons.utils.EasyUIDgResult;
import com.lk.commons.utils.ImportExcelUtil;
import com.lk.commons.vo.MsgResult;
import com.lk.pojo.BcRegion;
import com.lk.service.IQyservice;

@Controller
@Scope("prototype")
public class RegionController {

	/*private File regionFile;

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}*/

	@Autowired
	private IQyservice qyService;

	/**
	 * 区域设置相关内容
	 * 
	 * @return
	 */
	@RequestMapping("/page_base_region.action")
	
	public String tiaozhuan() {

		return "region2";
	}
	
	// 查询所有
		@RequestMapping(value = "/query", method = RequestMethod.POST)
		@ResponseBody
		public List<BcRegion> query(BcRegion bcRegion) {
			 List<BcRegion> list = qyService.findAll();
			return list;
		}
	
	
	
	// 批量导入
	@RequestMapping(value="/regionAction_importXls")
	@ResponseBody
	public String importExcel(@RequestParam("regionFile") MultipartFile regionFile) throws Exception{
		System.out.println(regionFile);
	//	MultipartFile regionFile
		if (!regionFile.isEmpty()) {		
			try {			
			// 这里将上传得到的文件保存指定目录下			
			FileUtils.copyInputStreamToFile(regionFile.getInputStream(),					
					new File("d:\\upload\\file\\", System.currentTimeMillis() + regionFile.getOriginalFilename()));	
			} 
		catch (IOException e) {		
			e.printStackTrace();	
				}	
			}	
		InputStream in = null;		
		List<List<Object>> listob = null;	
		in = regionFile.getInputStream();	
		listob = new ImportExcelUtil().getBankListByExcel(in, regionFile.getOriginalFilename());		
		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出	
		
		/*for (int i = 0; i < listob.size(); i++) {			
			List<Object> lo = listob.get(i);
			InfoVo vo = new InfoVo();
			vo.setRegionid(String.valueOf(lo.get(0)));	
			vo.setProvince(String.valueOf(lo.get(1)));
			vo.setCity(String.valueOf(lo.get(2)));	
			vo.setDistrict(String.valueOf(lo.get(3)));
			vo.setPostcode(String.valueOf(lo.get(4)));
			vo.setShortcode(String.valueOf(lo.get(5)));
			vo.setCitycode(String.valueOf(lo.get(6)));
			System.out.println("打印信息-->编号:" + vo.getRegionid() + " 省份:" + vo.getProvince() + "  城市：" + vo.getCity() + "   区域：" + vo.getDistrict() + "   邮编："+ vo.getPostcode()+ "   简码："+ vo.getShortcode()+ "   城市编码："+ vo.getCitycode());	
			} 	*/
		List<Object> list=new ArrayList<>();
		for (int i = 0; i < listob.size(); i++) {			
			List<Object> list1 = listob.get(i);
		//	System.out.println(list);
			String rId = String.valueOf(list1.get(0));	
			String province = (String.valueOf(list1.get(1)));
			String city = (String.valueOf(list1.get(2)));	
			String district = (String.valueOf(list1.get(3)));
			String postcode = (String.valueOf(list1.get(4)));
			String shortcode = (String.valueOf(list1.get(5)));
			String citycode = (String.valueOf(list1.get(6)));
			BcRegion bc = new BcRegion(rId, province, city, district, postcode, shortcode, citycode);
			
			/*bc.setrId(String.valueOf(list.get(0)));	
			bc.setProvince(String.valueOf(list.get(1)));
			bc.setCity(String.valueOf(list.get(2)));	
			bc.setDistrict(String.valueOf(list.get(3)));
			bc.setPostcode(String.valueOf(list.get(4)));
			bc.setShortcode(String.valueOf(list.get(5)));
			bc.setCitycode(String.valueOf(list.get(6)));*/
			//System.out.println("打印信息-->编号:" + bc.getrId() + " 省份:" + bc.getProvince() + "  城市：" + bc.getCity() + "   区域：" + bc.getDistrict() + "   邮编："+ bc.getPostcode()+ "   简码："+ bc.getShortcode()+ "   城市编码："+ bc.getCitycode());	
			//qyService.save(bc);
			list.add(bc);
		//	System.out.println(bc);
		} 	
		System.out.println(list);
		qyService.saveList(list);
		
			return "success"; // 上传成功则跳转至此success的信息	}
		}
	

	
	/////////////////////////////////
	
	// 删除区域
		/*@RequestMapping(value = "/regionAction_deleteBatch.action")
		@ResponseBody
		public void delete(@RequestParam("ids") String ids,BcStaff bcStaff) {
			if(StringUtils.isNotBlank(ids)){
				String [] iStrings =ids.split(",");
				for(String id : iStrings){	
					qyService.delete(id);
				}
			}
		}*/
	
	//分页
	@RequestMapping(value = "/regionAction_pageQuery.action", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIDgResult queryAllItemByPage(@RequestParam(value = "page", defaultValue = "1") int pageNum,
			@RequestParam(name = "rows", defaultValue = "20") int pageSize) {
		EasyUIDgResult result = qyService.findItemsByPage(pageNum, pageSize);
		return result;

	}

	// 保存
	@RequestMapping(value = "/regionAction_save.action", method = RequestMethod.POST)
	@ResponseBody
	public MsgResult saveBcRegion(BcRegion bcRegion) {
		MsgResult result = qyService.save(bcRegion);
		return result;
	}

	// 修改
	// 通过主键获取对象
	@RequestMapping(value="/regionAction_exit.action",method=RequestMethod.POST)
	@ResponseBody
	public int updateBcRegion(BcRegion bcRegion){
		int region = qyService.updateBcRegion(bcRegion);
		return region;
		
	}
}
