<%@ page language="java" pageEncoding="UTF-8" session="false" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String contentPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contentPath;
    String websiteVersion = "1.000";
    String websiteName = "Looty-Factory";
    int port = request.getServerPort();
    String resourcesRootPath = "/resources";
    String resourceUrl = basePath + contentPath + resourcesRootPath;
%>

<c:set var="version" value="<%=Math.random()%>"/>

<!--http://localhost:8085 -->
<c:set var="basePath" value="<%=basePath%>"/>

<c:set var="port" value="<%=port%>"/>

<c:set var="websiteVersion" value="<%=websiteVersion%>"/>

<c:set var="websiteName" value="<%=websiteName%>"/>

<c:set var="resourceUrl" value="<%=resourceUrl%>"/>