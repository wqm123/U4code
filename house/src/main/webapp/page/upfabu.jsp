<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<script src="../scripts/jquery-1.8.3.js"></script>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息更新</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post action="updateHouse" enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：<input type="hidden" value="${house.id}" name=id></TD>
    <TD><INPUT id=add_action_title class=text value="${house.title}" type=text name=title> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId id="typeId"><OPTION selected
        value=>-请选择-</OPTION></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>
    <TD><INPUT class=text type=date name=pubdate value=<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>></TD></TR>
  <TR>

    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=districtId id="districtId" onchange="ch()"><OPTION selected
        value=>-请选择-</OPTION></SELECT> 街：<SELECT class=text
        name=streetId id="streetId"><OPTION selected  value= >-请选择-</OPTION></SELECT> </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD></TR>
  <TR>
    <TD class=field>上传图片：</TD>
    <TD><input type="hidden" name="oldFile" value="${house.path}">
        <img src="http://localhost:8088/${house.path}" width="80px" height="100px"  alt="">
      <INPUT id=pfile  type=file name=pfile> </TD></TR>
  </TBODY></TABLE>
<DIV class=buttons><INPUT  value=立即发布 type=submit>
 <%-- onclick='document.location="list.jsp"'--%>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
<script>

  $.post("getAllType",null,function (data) {

      for (var i = 0; i <data.length ; i++) {
          //创建dom节点
          var option="<option value="+data[i].id+">"+data[i].name+"</option>";
          //添加节点
          $("#typeId").append(option);
      }
      $("#typeId").val(${house.typeId})
  },"json")

//区域
  $.post("getAllDistrict",null,function (data) {

      for (var i = 0; i <data.length ; i++) {
          //创建dom节点
          var option="<option value="+data[i].id+">"+data[i].name+"</option>";
          //添加节点
          $("#districtId").append(option);
      }
      $("#districtId").val(${house.districtId})
      loadStreet();
  },"json")

 //街道
  function ch() {
      loadStreet();
  }

  function loadStreet() {
      $.post("queryStreetById",{"districtId":$("#districtId").val()},function (data) {
          $("#streetId>option:gt(0)").remove();

          for (var i = 0; i <data.length ; i++) {
              //创建dom节点
              var option="<option value="+data[i].id+">"+data[i].name+"</option>";
              //添加节点
              $("#streetId").append(option);
          }
          $("#streetId").val(${house.streetId})
      },"json")
  }
</script>