<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<TITLE>添加联系人</TITLE>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
	<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
		  rel=stylesheet>
	<script type="text/javascript" src="../../js/jquery-1.4.4.min.js"></script>

	<%--<script type="text/javascript">--%>
	<%--$(function () {--%>
	<%--$.post("${pageContext.request.contextPath}/customer_findAll.action",{},function(data,status){--%>
	<%--$(data).each(function (index,obj) {--%>
	<%--alert(obj.cust_name);--%>
	<%--});--%>
	<%--},"json")--%>
	<%--});--%>
	<%--</script>--%>

	<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>

<s:form id="form1" name="form1" action="linkMans_update" method="POST" namespace="/" theme="simple">
	<%--留意这里value="%{lkm_id}" 也可以不写--%>
	<s:hidden name="lkm_id" value="%{lkm_id}"/>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
							  border=0></TD>
			<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
				height=20></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
			<TD vAlign=top width="100%" bgColor=#ffffff>
				<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
					<TR>
						<TD class=manageHead>当前位置：联系人管理 &gt; 添加联系人</TD>
					</TR>
					<TR>
						<TD height=2></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=5  border=0>
					<tr>
						<td>所属客户：</td>
						<td>
							<s:select list="list" headerValue="--请选择--" headerKey="" listKey="cust_id" listValue="cust_name" name="customer.cust_id"/>
						</td>
						<td>联系人职位 ：</td>
						<td>
							<s:textfield cssClass="textbox" cssStyle="WIDTH: 180px" id="sChannel2" maxLength="50" name="lkm_position"/>
						</td>
					</tr>
					<TR>
						<td>联系人名称：</td>
						<td>
							<s:textfield cssClass="textbox" cssStyle="WIDTH: 180px" id="sChannel2" maxLength="50" name="lkm_name"/>
						</td>
						<td>联系人性别：</td>
						<td>
							<s:radio list="#{'1':'男','2':'女'}" name="lkm_gender"/>
						</td>
					</TR>
					<TR>
						<td>联系人办公电话 ：</td>
						<td>
							<s:textfield cssClass="textbox" cssStyle="WIDTH: 180px" id="sChannel2" maxLength="50" name="lkm_phone"/>
						</td>
						<td>联系人手机 ：</td>
						<td>
							<s:textfield cssClass="textbox" cssStyle="WIDTH: 180px" id="sChannel2" maxLength="50" name="lkm_mobile"/>
						</td>
					</TR>
					<TR>
						<td>联系人邮箱 ：</td>
						<td>
							<s:textfield cssClass="textbox" cssStyle="WIDTH: 180px" id="sChannel2" maxLength="50" name="lkm_email"/>
						</td>
						<td>联系人QQ ：</td>
						<td>
							<s:textfield cssClass="textbox" cssStyle="WIDTH: 180px" id="sChannel2" maxLength="50" name="lkm_qq"/>
						</td>
					</TR>
					<td>联系人简介 ：</td>
					<td>
						<s:textarea  id="sChannel2" cssStyle="WIDTH: 180px"  rows="3" cols="20" name="lkm_memo"/>
					</td>
					<tr>
						<td rowspan=2>
							<INPUT class=button id=sButton2 type=submit
								   value="保存 " name=sButton2>
						</td>
					</tr>
				</TABLE>


			</TD>
			<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
				<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
							  border=0></TD>
			<TD align=middle width="100%"
				background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
</s:form>
</BODY>
</HTML>
