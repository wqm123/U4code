<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<script src="../scripts/jquery-1.8.3.js"></script>
<script>
  if (${userInfo==null}){
      window.location="login.jsp"
  }
</script>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>

<DIV class=search>
  <LABEL class="ui-green searchs" > <a href="searchHouse" title="" >浏览房屋信息</a></LABEL>
  <span style="font-size: 20px">欢迎<span style="color: red">${userInfo.name}</span>登录</span><LABEL class="ui-green searchs"> <a href="fabu.jsp" title="">发布房屋信息</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="exist"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${list}" var="house">
  <TR>
    <TD class=house-thumb><SPAN><A href="details.htm" target="_blank"><img src="http://localhost:8088/${house.path}" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="details.htm" target="_blank">${house.title}</A></DT>
        <DD>${house.dname}区 ${house.sname},${house.floorage}平米 类型：${house.tname}<BR>联系方式：${house.contact} </DD>
      </DL>
    </TD>
    <td>  <div style="color: red"><c:if test="${house.ispass==1}">已审核</c:if>
      <c:if test="${house.ispass==0}">审核中...</c:if></div></td>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick="location.href='queryHouseById?id=${house.id}'" value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button onclick="del(this,${house.id})" id="delete"></LABEL></TD></TR>
  </c:forEach>

  </TBODY></TABLE></DIV>
<DIV class=pager>
<UL>
  <LI class=current><A id=widget_338868862 
  href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=1" 
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">1</A>
   </LI>
  <LI class=current><A id=widget_1160989910 
  href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=2" 
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">2</A>
   </LI></UL><SPAN class=total>1/2页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
<script>
function del(obj,id) {
    $.post("delHouse",{"id":id},function (data) {
        if (data.result>0){
            $(obj).parent().parent().parent().remove()
        } else{
            window.location.href=("showHouseInfoByUsers");
        }
    },"json")
}
</script>