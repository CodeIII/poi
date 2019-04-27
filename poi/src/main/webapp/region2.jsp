<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>区域设置</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.table2excel.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.table2excel.min.js"></script>

<script>
		$(function() {

		$("#search").click(function (){
			
			console.log
				$.ajax({
					url: '${pageContext.request.contextPath }/query',
					type: 'POST',
					dataType: 'json',
					success: function(data){
						var str = "";
						for (var k in data)
							{
							str += "<tr><td>"+data[k].rId+"</td><td>"+data[k].province+"</td><td>"+data[k].city+"</td><td>"+data[k].district+"</td><td>"+data[k].postcode+"</td><td>"+data[k].shortcode+"</td><td>"+data[k].citycode+"</td></tr>";
							}
						$("#body").html(str);
					}
					
				});
			
		}); 
		
		//页面加载完成后，调用OCUpload插件的方法
		 $("#button-import").upload({
			action : '${pageContext.request.contextPath }/regionAction_importXls',
			name : 'regionFile'
			}); 
		
		 $("#generate-excel").click(function(){
		        $("#grid").table2excel({
		           // exclude: ".noExl",
		            name: "Excel Document Name",
		            filename: "myFileName",
		            fileext: ".xls",
		            exclude_img: true,
		            exclude_links: true,
		            exclude_inputs: true
		        });
		    });
	
    });
		
		

</script>



<style>
td{border:1px solid red;text-align:center;color:black;border-radius:5px};
input{display:inline-block };
</style>
</head>
<body>
	<div id="box" region="center" border="false" style="position:relative;">
		<input id="search" type="button" value="查询" />
		
		<div style="display:inline-block;position:absolute;top:0;left:97px" >
		<input id="button-import" type="button" value="上传" />
		</div>
		
		 <input id="generate-excel" type="button" value="下载" />
		
		<table id="grid" style="border-radius:5px" >
		 <tr>
		 <td>序号</td>
		 <td>省</td>
		 <td>市</td>
		 <td>区</td>
		 <td>邮编</td>
		 <td>简码</td>
		 <td>城市编码</td>
		 <tr>
		 
		 <tbody id="body">
		 </tbody>
		</table>
	</div>
</body>
</html>