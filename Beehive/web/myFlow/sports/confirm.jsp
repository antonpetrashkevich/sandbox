<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<netui:html>
    <head>
        <title>Confirm Sport Activity</title>
        <netui:base/>
    </head>
    <netui:body>
        <p>
            Confirm Sport Activity
        </p>
        <p>
            Sport: ${pageFlow.selectedSport}
        </p>
        <netui:form action="confirm">
            <netui:button type="submit" value="Confirm"/>
        </netui:form>
    </netui:body>
</netui:html>