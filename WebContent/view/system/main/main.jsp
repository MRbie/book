<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta charset="utf-8">
<title>工作台</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resource/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resource/js/bootstrap.min.js"></script>
<!--在线引用js文件，离线出现各种问题-->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>

</head>
<body>
<div style="padding:0px; margin:0px;">
 	<ul class="breadcrumb" style=" padding:0px; padding-left:20px;" >
  		<li ><a href="view/system/main/index.jsp">首页</a></li>
  		<li>工作台</li>
	</ul>
</div>

<!-- 
<div class="row">
	<div class="col-xs-6" >
    	 <div class="panel panel-default" >
          <div class="panel-heading"  >
            <span class="glyphicon glyphicon-refresh"></span>图形报表
          </div>
              <div class="panel-body">
              	<img src="resource/img/test.png" height="200" width="100%">
              </div>
        </div>
    </div>
    <div class="col-xs-6" >
 	 <div class="panel panel-default" >
          <div class="panel-heading"  >
            <span class="glyphicon glyphicon-refresh"></span>图形报表
          </div>
              <div class="panel-body">
              	<img src="resource/img/test.png" height="200" width="100%">
              </div>
        </div>
    </div>
</div>
-->

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1300px;height:400px;"></div>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main2" style="width: 1300px;height:400px;"></div>


<!-- ECharts单文件引入 -->
<script type="text/javascript">
	//获取到json的长度.
	function getJsonLength(json){
		var jsonLength = 0;
	    for (var i in json) {
	        jsonLength++;
	    }
	    return jsonLength;
	}
	
    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    
    // 使用
    require(
        [
            'echarts',
            'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/pie',
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main')); 
            //myChart.setOption({
               var option ={
            	color: ['purple'],	   
                title: {  
                       text: '别先生 ---图书管理系统报表展示======》图书及其数量展示'  
                },  
                tooltip: {
                     trigger: 'axis',
                     axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                         type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
                     }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    //bottom: '7%',//必须去除,不然影响其他页面的效果
                    containLabel: true
                },
                legend: {
                    data:['数量']
                },
                xAxis : {
                   // data: []
                },
                yAxis: [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    /* { //出现这种问题，是此处和下面的重新赋值冲突了，把这里注释了，下面重新赋值即可。  
                         //series[0] chart type has not been defined.  
                         name:"数量",
                         type:"bar",
                         data:[]
                    } */
                ]
            };
            // 为echarts对象加载数据 
            //myChart.setOption(option); 
            
            
            myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
            var names=[];    //类别数组（实际用来盛放X轴坐标值）
            var nums=[];    //销量数组（实际用来盛放Y坐标值）
            $.ajax({
                type : "post",
                //async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "${pageContext.request.contextPath}/system/userinfo/show",//请求发送到TestServlet处
                data : {},
                dataType : "json", //返回数据形式为json
                success : function(result) {
                	var resultLength = getJsonLength(result.list);
                	//alert(resultLength);
                	//请求成功时执行该函数内容，result即为服务器返回的json对象 keyword keywordCount
                    if (result != null && result !="") {
                       //挨个取出类别并填入类别数组 //x坐标的值
                       for(var i=0; i<resultLength; i++){
                    	   //alert(result.list[i].bookName);
                    	   //console.info(result[i]);
                    	   names.push(result.list[i].bookName);   
                        }
                       //alert(names);
                       //挨个取出销量并填入销量数组 //y坐标的值
                       for(var i=0; i<resultLength; i++){
                           nums.push(result.list[i].bookSum);    
                       }
                       //alert(nums);
                       //隐藏加载动画
                       myChart.hideLoading(); 
                       //加载数据图表
                       myChart.setOption({        
                           xAxis: { //x坐标的值
                               data: names,
                               axisLabel:{//解决。Echarts中axislabel文字过长导致显示不全或重叠  
                                   interval: 0,
                                   rotate:40,
                               }  
                           },
                           series: [{ //y坐标的值
                                // 根据名字对应到相应的系列
                                name:"数量",
                                type:'bar',
                                //barWidth:'60%',//柱的宽度,%不是使
                                barWidth : 40,//柱图宽度
                                data: nums
                           }],
                       });
                    }
               },
               error : function(errorMsg) {
                   //请求失败时执行该函数
                   alert("图表请求数据失败!");
                   myChart.hideLoading();
               }
               }) 
               myChart.setOption(option);
        }
    );
    
</script>

</body>
</html>
