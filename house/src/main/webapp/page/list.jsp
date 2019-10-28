<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/scripts/jquery-1.8.3.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id="sform" method=post action="searchHouse">
    <input type="hidden" value="1"  id="setPage" name="page">
    标题:<input type="text" value="${condition.title}" name="title">
    区域:<select name="did" id="districtId" onchange="ch()">
    <option value="">请选择</option>
  </select>
    街道:<select name="sid" id="streetId">
    <option value="">请选择</option>
  </select>
    类型:<select name="tid" id="typeId">
    <option value="">请选择</option>
  </select>
    价格:<input type="text" name="startPrice" value="${condition.startPrice}">-<input type="text" value="${condition.endPrice}" name="endPrice">
    <input type="submit" name="seach" value="搜 索">
  </FORM>
</DL></DIV>

<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${pageInfo.list}" var="houses">
  <TR>
    <TD class=house-thumb><span><A href="details.htm" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.htm" target="_blank">${houses.title}</A></DT>
        <DD>${houses.dname}区${houses.sname}大街,${houses.floorage}平米<BR>联系方式：${houses.contact} </DD></DL></TD>
    <TD class=house-type>${houses.tname}</TD>
    <TD class=house-price><SPAN>${houses.price}</SPAN>元/月</TD></TR>
  <TR class=odd>
    </c:forEach>
    </TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:topage(1)">首页</A></LI>
  <LI><A href="javascript:topage(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</A></LI>
  <LI><A href="javascript:topage(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</A></LI>
  <LI><A href="javascript:topage(${pageInfo.pages})">末页</A></LI></UL><SPAN
class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV></DIV>
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
        $("#typeId").val(${condition.tid})
    },"json")
    //区域
    $.post("getAllDistrict",null,function (data) {

        for (var i = 0; i <data.length ; i++) {
            //创建dom节点
            var option="<option value="+data[i].id+">"+data[i].name+"</option>";
            //添加节点
            $("#districtId").append(option);
        }
        $("#districtId").val(${condition.did})
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
            $("#streetId").val(${condition.sid})
        },"json")
    }

    //传递页码
    function topage(num){  //num页码
        $("#setPage").val(num);  //设置跳转的页面
        $("#sform").submit();  //表单提交wr
    }

</script>