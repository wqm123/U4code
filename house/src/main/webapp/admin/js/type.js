//点击添加按钮调用的函数
function add(){
    //alert("打开添加窗口");
    $("#AddDialog").dialog("setTitle","添加类型");
    $("#AddDialog").dialog("open"); //打开  close 关闭
}
//点击修改按钮调用的函数---回显修改数据
function ModifyBySelect(){
    //alert("打开添加窗口");
    var SelectRows = $("#dg").datagrid('getSelections');
    if (SelectRows.length==1){
        //可直接讲selectRows数据加载到form中
        /*  $('#updateForm').form('load',SelectRows[0]);*/
        //2通过传入id获取数据
        $.post("findTypeById",{"id":SelectRows[0].id},function (data) {
            $('#updateForm').form('load',data)
        },"json")
        $("#UpdateDialog").dialog("setTitle","修改类型");
        $("#UpdateDialog").dialog("open"); //打开  close 关闭
    } else{
        $.messager.alert('提示信息','您只能选中一行数据修改','warning');


    }

}


//关闭窗口
function CloseDialog(id){
    $("#"+id).dialog("close"); //打开  close 关闭
}

/*保存添加执行添加方法*/
function SaveAddDialog() {
    /*方法一：通过ajax异步请求传参，缺点，参数多的时候，要写多个参数属性*/
    /*$.post("addType",{"name":$("#name").val()},function (data) {
        if (data.result==1){
            $("#dg").datagrid("reload")
            CloseDialog("AddDialog")
        } else{
            alert("添加失败")
        }
        },"json");*/

    /*方法2：通过easyUi传递参数，通过提交地址传递所有参数*/
    $("#Type").form('submit', {
        url:"addType",
        success:function(data){//此处得到的data是String字符串
            data=$.parseJSON(data);
            if (data.result==1){
                $("#dg").datagrid("reload")
                CloseDialog("AddDialog")
            } else{
                alert("添加失败")
            }
        }
    });

}


//单项删除
function singleDel(id) {
    $.messager.confirm('确认提示','真的要删除吗?',function(r){
        if (r){
            $.post("delType",{"id":id},function (data) {
                if (data.result==1){
                    $("#dg").datagrid("reload")
                    //CloseDialog("AddDialog")
                } else{
                    $.messager.alert('提示信息','删除失败','error');
                }
            },"json");
        }
    });

}
/*多项删除方法*/
//1.post多次请求删除
/*function DeleteTypes() {
    var s = $('#dg').datagrid('getSelections');
    if (s.length<1){
        $.messager.alert('提示信息','请选择要删除的数据','info');
    }else {
        $.messager.confirm('确认提示','真的要删除这'+s.length+'条数据吗?',function(r){
            if (r) {
                var flag=0;
                for (var i = 0; i < s.length; i++) {
                    $.post("delType",{"id":s[i].id},function (data) {
                        var d = data.result;
                        if (data.result==1){
                            flag++;
                           while (flag==s.length){
                                $("#dg").datagrid("reload")
                                //CloseDialog("AddDialog")
                                return;
                            }
                        }
                        //var data=JSON.parse(data);

                        /!*flag = data.result+1;*!/
                        /!*if (data.result==1){
                            $("#dg").datagrid("reload")
                            //CloseDialog("AddDialog")
                        } else{
                            $.messager.alert('提示信息','删除失败','error');
                        }*!/
                    },"json");
                }
            }
        })
    }

}*/

//2.多行删除，通过数组传递id到后台接收
function DeleteTypes() {
    var s = $('#dg').datagrid('getSelections');
    if (s.length==0){
        $.messager.alert('提示信息','请选择要删除的数据','info');
    }else {
        $.messager.confirm('确认提示','真的要删除这'+s.length+'条数据吗?',function(r){
            if (r) {
                var ids=[];
                for (var i = 0; i < s.length; i++) {
                    //获取自定义table 的中的checkbox值
                    var im = s[i].id;
                    ids.push(im); //然后把单个id循环放到ids的数组中
                }
                /*加个$.ajaxSettings.traditional=true;才可以传数组
                * 如果你想要用传统的方式来序列化数据，那么就设置为 true。*/
                /*$.ajaxSettings.traditional=true;*/
                $.post("delMoreTypes" ,{"ids": ids}, function (data) {
                    if (data.result == s.length) {
                        $.messager.alert('提示信息','删除成功','info');
                        $("#dg").datagrid("reload")
                        //CloseDialog("AddDialog")
                    } else {
                        $.messager.alert('提示信息','删除失败','error');
                    }
                }, "json");

            }
        })
    }
}



//修改方法----
function UpdateDialog() {
    $("#updateForm").form('submit', {
        url:"updateType",
        success:function(data){//此处得到的data是String字符串
            data=$.parseJSON(data);
            if (data.result==1){
                $("#dg").datagrid("reload")
                CloseDialog("UpdateDialog")
            } else{
                $.messager.alert('提示信息','更新失败','error');
            }
        }
    });
}