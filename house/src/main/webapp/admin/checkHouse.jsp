<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/13
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script src="js/checkHouse.js"></script>
    <script language="JavaScript">
         //加载显示区域
         $(function(){  //加载事件
              //显示数据
             $('#dg').datagrid({
                 fitColumns:"true" ,fit:"true" ,rownumbers:"true",
                 title:"未审核",
                 url:'queryHouseByIspass',
                 toolbar:"#tb",
                 pagination:true,
                 pageSize:5,
                 pageList:[5,10,15,20],
                 columns:[[
                     {field:'xk',checkbox:"true",width:100},
                     {field:'id',title:'编号',width:100},
                     {field:'title',title:'标题',width:100},
                     {field:'dname',title:'区域名称',width:100},
                     {field:'sname',title:'街道名称',width:100},
                     {field:'tname',title:'类型名称',width:100},
                     {field:'floorage',title:'面积',width:100},
                     {field:'price',title:'价格',width:100},
                     {field:'contact',title:'电话',width:100},
                     {field:'dd',title:'操作',width:100,
                         formatter: function(value,row,index){
                             return "<a href='javascript:singleCheck("+row.id+")'>审核</a>"
                             }

                         },

                 ]]
             });

         });

    </script>
</head>
<body>
<table id="dg"></table>
<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a> <a
        href="javascript:ModifyBySelect()" class="easyui-linkbutton"
        iconCls="icon-edit" plain="true">修改</a> <a
        href="javascript:DeleteDistricts()" class="easyui-linkbutton"
        iconCls="icon-remove" plain="true">删除</a>
</div>
<!--制作添加区域的对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true"
     data-options="modal:true">
    <form id="district" name="add" method="post">
        区域名称:<input type="text" name="name" id="name"><br/>
    </form>
</div>
<!--对话框的按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveAddDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('AddDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>





<!--制作修改区域的对话框-->
<div id="UpdateDialog" class="easyui-dialog" buttons="#UpdateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true"
     data-options="modal:true">
    <form  id="updateForm" name="add" method="post">
        区域名称:<input type="text" name="name" ><br/>
        <input type="hidden" name="id">
    </form>
</div>
<!--修改对话框的按钮-->
<div id="UpdateDialogButtons">
    <a href="javascript:UpdateDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('UpdateDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>


<script>

</script>

</html>
