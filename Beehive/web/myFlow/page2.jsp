<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<netui:html>
    <head>
        <title>page2.jsp</title>
        <netui:base/>
    </head>
    <netui:body>
        <p>
            Welcome to page2.jsp!       Ror7!
        </p>
        <p>
            <netui:form action="processData">
                Name: <netui:textBox dataSource="actionForm.name"/>
                <netui:error key="name"/>
                <br/>
                Age: <netui:textBox dataSource="actionForm.age"/>
                <netui:error key="age"/>
                <br/>
                Sport: <netui:textBox dataSource="actionForm.sport"/>
                <br/>
                <netui:button type="submit" action="getSport" value="Select Sport"/>
                <netui:button type="submit" value="Submit"/>
            </netui:form>
        </p>
    </netui:body>
</netui:html>