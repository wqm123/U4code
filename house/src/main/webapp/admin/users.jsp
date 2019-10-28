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
    <script src="js/users.js"></script>
    <script language="JavaScript">
         //加载显示类型
         $(function(){  //加载事件
              //显示数据
             $('#dg').datagrid({
                 fitColumns:"true" ,fit:"true" ,rownumbers:"true",
                 title:"用户管理",
                 url:'getUsersByPage',
                 toolbar:"#tb",
                 pagination:true,
                 pageSize:5,
                 pageList:[5,10,15,20],
                 columns:[[
                     {field:'opt',checkbox:"true",title:'编号',width:100},
                     {field:'id',title:'编号',width:100},
                     {field:'name',title:'用户名',width:100},
                     {field:'telephone',title:'电话',width:100},
                     {field:'age',title:'年龄',width:100},
                     {field:'dd',title:'操作',width:100,
                         formatter: function(value,row,index){
                             //同步
                             return "<a href='javascript:delUsers("+row.id+");'>删除</a> | <a href=''>修改</a>";
                         }

                     },

                 ]]
             });

         });

         function search(){
             //$("#dg").datagrid("load",查询条件格式:{"名称":值,"名称":值..});
             var name=$("#sname").val();
             var telephone=$("#stelephone").val();
             $("#dg").datagrid("load",{"name":name,"telephone":telephone});
         }

    </script>
</head>
<body>
<table id="dg"></table>
<div id="tb">
    用户名：<input type="text" name="name" id="sname" >&nbsp;
    电话：<input type="text" name="telephone" id="stelephone">
    <a href="javascript:search()" class="easyui-linkbutton"
       iconCls="icon-search" plain="true">搜索</a>
</div>
<!--制作添加类型的对话框-->

<!--对话框的按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveAddDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('AddDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>





<!--制作修改类型的对话框-->

<!--修改对话框的按钮-->

</body>


<script>

</script>

</html>
