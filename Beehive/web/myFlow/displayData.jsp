<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<netui:html>
    <head>
        <title>displayData.jsp</title>
        <netui:base/>
    </head>
    <netui:body>
        <p>
            You submitted the following information:
        </p>
        <p>
            Name: ${pageInput.name}
            <br/>
            Age: ${pageInput.age}
            <br/>
            Message: ${pageInput.message}
        </p>
    </netui:body>
</netui:html>