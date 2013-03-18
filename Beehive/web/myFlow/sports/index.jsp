<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<netui:html>
    <head>
        <title>Select Sport</title>
        <netui:base/>
    </head>
    <netui:body>
        <p>
            Select Sport Activity
        </p>
        <p>
        <netui:form action="selectSport">
            <table>
                <tr>
                    <td>Sports:</td>
                    <td>
                        <netui:radioButtonGroup dataSource="actionForm.sport"
                                                optionsDataSource="${pageFlow.sports}"/>
                    </td>
                </tr>
            </table>
            <netui:button type="submit">Submit</netui:button>
        </netui:form>
        </p>
    </netui:body>
</netui:html>