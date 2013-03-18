<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<netui:html>
    <head>
        <title>Web Application Page</title>
        <netui:base/>
    </head>
    <netui:body>
        <p>
            New Web Application Page
            Ror!!!
        </p>

        <p>
            <netui:anchor action="toPage2">Link to page2.jsp</netui:anchor>
        </p>

        <netui:anchor action="shared.showHelp" popup="true">Help
            <netui:configurePopup location="false" width="550" height="150">
            </netui:configurePopup>
        </netui:anchor>

    </netui:body>
</netui:html>