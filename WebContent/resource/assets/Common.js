/**
* 功能：给string扩展trim方法
**/
String.prototype.trim = function() 
{ 
	return this.replace(/(^s*)|(s*$)/g, ""); 
} 

/**
* 功能：给string扩展ltrim方法，去掉左边的空格
**/
String.prototype.ltrim = function() 
{ 
	return this.replace(/(^s*)/g, ""); 
} 

/**
* 功能：给string扩展rtrim方法，去掉右边的空格
**/
String.prototype.rtrim = function() 
{ 
	return this.replace(/(s*$)/g, ""); 
} 

/**
* 功能：js中类似于java中endWith的字符串函数
**/
String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
  		return false;
  
 	if(this.substring(this.length-str.length)==str)
  		return true;
 	else
  		return false;
  
 	return true;
}

/**
* 功能：js中类似于java中startWith的字符串函数
**/
String.prototype.startWith=function(str){
 	if(str==null||str==""||this.length==0||str.length>this.length)
		return false;
  
 	if(this.substr(0,str.length)==str)
		return true;
 	else
		return false;
	
 	return true;
}

/**
 * 功能：根据表格的jquery选择器修饰一个table,该功能必须要jquery支持才行 
 * 参数：preSelector 表格的jquery选择器
 *      hover 是否对鼠标移过数据行的时候高亮显示,true高亮,false不高亮
 */
decorateTable = function(preSelector, hover) {
	if(hover) {
		jQuery(preSelector + " tr").mouseover(
				// 如果鼠标移到表格的tr上时，执行函数
				function() {
					jQuery(this).addClass("hover");
				}).mouseout(
					// 给这行添加class值为hover，并且当鼠标移出该行时执行函数，将对应的样式表给删除掉
					function() {
						jQuery(this).removeClass("hover");
					});
	}

	//给奇数行和偶数行分别添加样式
	jQuery(preSelector + " tr:even").addClass("even");
	jQuery(preSelector + " tr:odd").addClass("odd");
}

/**
* 功能：将页面中指定名字的checkbox全部设置成未选中
* * 参数：itemName 需要选中或取消的复选框的名字
**/
function unSelectAll(itemName) {
	//将所有的Item都取消选中
	jQuery(':checkbox[name=' + itemName + ']').each(function(i){
			this.checked = false;
		}); 
}

/**
* 功能：用于表格中的全选复选框。
* 	   如果全选按钮选中，则将所有项都选中；如果全选按钮没有选中，则将所有项都取消选中
* 参数：checkAllObj 全选复选框对象
*	   itemName 需要选中或取消的复选框的名字
**/
function selectAll(checkAllObj, itemName) {
	//如果全选的复选框是选中的，则将所有复选框选中
	jQuery(':checkbox[name=' + itemName + ']').each(function(i){
			this.checked = checkAllObj.checked;
		}); 
}

/**
* 功能：表格中如果列表项选中或者取消，判断所有的项是否选中，如果选中则将全选复选框勾选上，够则不进行勾选
* 参数：checkItemObj 选择项对象
*	   checkAllId 全选的复选框Id名字
**/
function selectItem(checkItemObj, checkAllId) {
	//默认将全选选中，只要有一个选项没有选中，则取消勾选
	var checkAll = true;
	var itemName = checkItemObj.name;
	
	//如果全选的复选框是选中的，则将所有复选框选中
	jQuery(':checkbox[name=' + itemName + ']').each(function(i){
			if(!this.checked) {
				checkAll = false;
				
				return;
			}
		}); 
	
	//设置全选的勾选情况
	$(checkAllId).checked = checkAll;
}

/**
* 功能：从列表中读取所有项，构造形如user1,user2..的字符串
* 参数：	listId 列表的Id名字，字符串
*		flag 是否给列表各项的特征值加上单引号，加上单引号构造的字串为：'user1','user2'..
*           true 加上引号,false不加引号
**/
getListStr = function(listId, flag) {
	var listStr = "";
	
	var objs = $(listId).options;
	for(var i=0; i<objs.length; i++) {
		if(flag)
			listStr += "'" + objs[i].value + "',";
		else
			listStr += objs[i].value + ",";
	}
	
	//去掉后面的逗号
	if(listStr.endWith(',')) {
		listStr = listStr.substr(0, listStr.length - 1);
	}

	return listStr;
}

  /**
 * description 取得页面所有元素中最大的z-index的值
 * @author 谢亮
 */

getMaxZIndexNo = function(){
	
	//保存当前页面最大的z-index
	//初始值为0
	var zIndex = 0;
	
	//取得页面所有的元素
	var DOMElements = document.getElementsByTagName('*');
	
	for(var i = 0;i < DOMElements.length ;i++){
		if(DOMElements[i].style.zIndex > zIndex){
			zIndex = DOMElements[i].style.zIndex;
		}
	}
	
	//返回最大的zIndex
	return zIndex;
}

/**
* 功能：让某个select对象默认选中某个值
* 参数：obj select对象
*      theValue 需要选中项的值
**/
function setObjSelect(obj, theValue)
{
	for(var i=0;i<obj.length;i++)
	{
		if(obj.options[i].value==theValue)
		{
			obj[i].selected = true ;
			return;
		}
	}
}


/**
* 功能：判断一个指定的日期字符串是否合法
* 参数：dValue 日期字符串
* 返回：数组，[0]true 合法，false不合法
*			[1] 不合法的原因
**/
function verifyDate(dValue)
{
	var tempArr = new Array(false,"");

	if((/^([0-9]){4,4}-([0-9]){2,2}-([0-9]){2,2}$/.test(dValue)))
	{
		tempArr[0] = true;
	}
	else {
		tempArr[0] = false;
		tempArr[1] = "不是合法的日期，请按\"YYYY-MM-DD\"的格式输入 ";
	}
	
	if(tempArr[0]) {
		var arr = dValue.match(/\d+/g);
		year = Number(arr[0]);
		month = Number(arr[1]);
		day = Number(arr[2]);
		var monthDay = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
		if(year%400==0||(year%4==0&&year%100!=0))	monthDay[1] = 29;
		if(year<0 || month<0 || month>12 || day>31 ||day>monthDay[month-1])
		{
			tempArr[0] = false;
			tempArr[1] = "您输入了一个不存在的日期，请重新输入 ";
		}
	}
	
	return tempArr;
}

//扩展Date类，实现日期格式化
Date.prototype.format = function(format) 
{ 
  var o = { 
    "M+" : this.getMonth()+1, //month 
    "d+" : this.getDate(),    //day 
    "h+" : this.getHours(),   //hour 
    "m+" : this.getMinutes(), //minute 
    "s+" : this.getSeconds(), //second 
    "q+" : Math.floor((this.getMonth()+3)/3),  //quarter 
    "S" : this.getMilliseconds() //millisecond 
  } 
  if(/(y+)/.test(format)) format=format.replace(RegExp.$1, 
    (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  for(var k in o)if(new RegExp("("+ k +")").test(format)) 
    format = format.replace(RegExp.$1, 
      RegExp.$1.length==1 ? o[k] : 
        ("00"+ o[k]).substr((""+ o[k]).length)); 
  return format; 
} 

