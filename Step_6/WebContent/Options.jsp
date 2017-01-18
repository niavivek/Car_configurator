<%--Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 6
Due Date : 06/20/2016
Date Submitted :06/20/2016 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selected Options</title>
</head>
<body>
<h3>Here is what you selected:</h3>
<table border="1" style="width:100%">
<tr>
<%--Get the parameters from the request variable, 
store the price in a local variable and use it for further calculations--%>
<% String basePrice =  request.getParameter("price"); %>
<td><%= request.getParameter("make") %></td>
<td>Base price</td>
<td><%= basePrice %></td>
</tr>
<%-- Initialize variables to store the index, total price, option price and name--%>
<%--Also String of array to store the unsplit optionname and optionprice --%>
<%int i = 0;
float total = Float.parseFloat(basePrice);
float price = 0;
String value;
String[] val;
String val1;
String val2;%>
<%-- Write the option set name to the web page while the value from the request is not null --%>
<% while(request.getParameter("optionset"+i) != null) {%>
<tr>
<td><%= request.getParameter("optionset"+i) %></td>
<%--get the unsplit optionname and optionprice and split it with the regex "," --%>
<%-- first value is option name and second is option price --%>
<% value =  request.getParameter("optionname"+i); %>
<% val =  value.split(","); %>
<% val1 =  val[0]; %>
<% val2 =  val[1]; %>
<td><%= val1%></td>
<td><%= val2%> </td>
</tr>
<% total = total+Float.parseFloat(val2); %>
<%--add the option price to the total and increment the index to get the next option set name --%>
<%i++;} %>
<tr>

<td><b>Total Cost</b></td>
<td></td>
<%--write the total variable to the page --%>
<td><b><%=total %></b></td>
</tr>
</table>
</body>
</html>