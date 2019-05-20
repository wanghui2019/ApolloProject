﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function () {
			$.post("${pageContext.request.contextPath}/baseDict_findByCode.action",{"dict_type_code":"006"},function(data,status){
				$(data).each(function (index,obj) {
					$("#cust_level").append("<option value='"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
				});
				$("#cust_level option[value='${baselevel.dict_id}']").attr("selected","selected");
			},"json");

			$.post("${pageContext.request.contextPath}/baseDict_findByCode.action",{"dict_type_code":"002"},function(data,status){
				$(data).each(function (index,obj) {
					$("#cust_source").append("<option value='"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
				});
				$("#cust_source option[value='${basesource.dict_id}']").attr("selected","selected");
			},"json");

			$.post("${pageContext.request.contextPath}/baseDict_findByCode.action",{"dict_type_code":"001"},function(data,status){
				$(data).each(function (index,obj) {
					$("#cust_industry").append("<option value='"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
				});
				$("#cust_industry option[value='${baseindustry.dict_id}']").attr("selected","selected");
			},"json");
		})
	</script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			//将表单中的值改写为page
			$("#page").val(page);
		}
		// 提交表单
		document.customerForm.submit();
		
	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/customer_findByPage.action"
		method=post>
		
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
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="cust_name" value="<s:property value="cust_name"/> "></TD>

													<TD>客户级别：</TD>
													<TD>
														<select id="cust_level" name="baselevel.dict_id">
															<option value="">--请选择--</option>
														</select>
													</TD>

													<TD>客户来源：</TD>
													<TD>
														<select id="cust_source" name="basesource.dict_id">
															<option value="">--请选择--</option>
														</select>
													</TD>

													<TD>客户所属行业：</TD>
													<TD>
														<select id="cust_industry" name="baseindustry.dict_id">
															<option value="">--请选择--</option>
														</select>
													</TD>
													
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>客户所属行业</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator var="c" value="list">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="#c.cust_name"/></TD>
													<TD><s:property value="#c.baselevel.dict_item_name"/></TD>
													<TD><s:property value="#c.basesource.dict_item_name"/></TD>
													<TD><s:property value="#c.baseindustry.dict_item_name"/></TD>
													<TD><s:property value="#c.cust_phone"/></TD>
													<TD><s:property value="#c.cust_mobile"/></TD>
													<TD>
													<a href="${pageContext.request.contextPath }/customer_edit.action?cust_id=<s:property value="cust_id"/> ">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/customer_deleteCustomer.action?cust_id=<s:property value="cust_id"/> ">删除</a>
													</TD>
												</TR>
												</s:iterator>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B><s:property value="totalNum"/> </B>]条记录,[<B><s:property value="totalPage"/> </B>]页
												,每页显示
												<select name="showNum" onchange="to_page()">
												
												<option value="3" <s:if test="showNum==3">selected</s:if>>3</option>
												<option value="5" <s:if test="showNum==5">selected</s:if>>5</option>
												<option value="10" <s:if test="showNum==10">selected</s:if>>10</option>
												</select>
												条
												<%--<s:property value="currPage-1"/>为传的参数page--%>

												[<A href="javascript:to_page(1)">首页</A>]
												[<A href="javascript:to_page(<s:property value="currPage-1"/> )">前一页</A>]
												&nbsp;&nbsp;
												<B>
													<s:iterator var="i" begin="1" end="totalPage">
                                                        <s:if test="#i==currPage">
                                                            <s:property value="#i"/>&nbsp;
                                                        </s:if>
                                                        <s:else>
                                                            <a href="javascript:to_page(<s:property value="#i"/>)">
                                                                <s:property value="#i"/>&nbsp;
                                                            </a>
                                                        </s:else>
													</s:iterator>
												</B>&nbsp;&nbsp;
												<s:if test="currPage!=totalPage">
												[<A href="javascript:to_page(<s:property value="currPage+1"/>)">后一页</A>]
												[<A href="javascript:to_page(<s:property value="totalPage"/> )">尾页</A>]
												</s:if>
                                                <s:else>
                                                    [<A href="javascript:to_page(<s:property value="totalPage"/>)">后一页</A>]
                                                    [<A href="javascript:to_page(<s:property value="totalPage"/> )">尾页</A>]
                                                </s:else>
												到
												<input type="text" size="3" id="page" name="currPage" />
												页
												
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
	</FORM>
</BODY>
</HTML>
