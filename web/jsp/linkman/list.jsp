<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		$(function () {
			$.post("${pageContext.request.contextPath }/customer_findAllByAjax.action",{},function(data,status){
				$(data).each(function (index,obj) {
					$("#linkMan_Customer").append("<option value='"+obj.cust_id+"'>"+obj.cust_name+"</option>");
				});
				$("#linkMan_Customer option[value='${customer.cust_id}']").attr("selected","selected");
			},"json");

		});
	</script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/linkMans_findAll.action"
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
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
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
													<TD>联系人名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="lkm_name">
													</TD>

													<TD>相关客户：</TD>
													<TD>
														<select id="linkMan_Customer" name="customer.cust_id">
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
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>qq</TD>
													<TD>地址</TD>
													<TD>简介</TD>
													<TD>相关客户</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="list" var="c">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="#c.lkm_name"/></TD>
                                                    <td>
                                                    <s:if test="#c.lkm_gender==1">男</s:if>
                                                    <s:if test="#c.lkm_gender==2">女</s:if>
                                                    </td>
													<TD><s:property value="#c.lkm_phone"/></TD>
													<TD><s:property value="#c.lkm_mobile"/></TD>
													<TD><s:property value="#c.lkm_email"/></TD>
													<TD><s:property value="#c.lkm_qq"/></TD>
													<TD><s:property value="#c.lkm_position"/></TD>
													<TD><s:property value="#c.lkm_memo"/></TD>
													<TD><s:property value="#c.customer.cust_name"/></TD>


													<TD>
													<a href="${pageContext.request.contextPath }/linkMans_edit.action?lkm_id=<s:property value="lkm_id"/> ">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/linkMans_delete.action?lkm_id=<s:property value="lkm_id"/> ">删除</a>
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
												
													<option value="3" <s:if test="showNum==3">selected</s:if> >3</option>
												<option value="5" <s:if test="showNum==5">selected</s:if>>5</option>
												<option value="10" <s:if test="showNum==10">selected</s:if>>10</option>
												</select>
												条
												[<A href="javascript:to_page(1)">首页</A>]
												[<A href="javascript:to_page(<s:property value="currPage-1"/>)">前一页</A>]
												&nbsp;&nbsp;
												<B>
													<s:iterator  var="i" begin="1" end="totalPage">
														<%--判断如果是在当前页，当前页直接显示，否则将其它的编程链接形式--%>
														<s:if test="#i==currPage">
															<s:property value="#i"/>&nbsp;
														</s:if>
														<s:else>
															<a href="javascript:to_page(<s:property value="#i"/>)">
                                                                <s:property value="#i"/>&nbsp;
                                                            </a>
														</s:else>
													</s:iterator>
												</B>
												&nbsp;&nbsp;
												<s:if test="currPage!=totalPage">
												[<A href="javascript:to_page(<s:property value="currPage+1"/> )">后一页</A>]
												[<A href="javascript:to_page(<s:property value="totalPage"/>)">尾页</A>]
												</s:if>
												<s:else>
													[<A href="javascript:to_page(<s:property value="totalPage"/> )">后一页</A>]
													[<A href="javascript:to_page(<s:property value="totalPage"/>)">尾页</A>]
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
