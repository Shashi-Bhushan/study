<%@include file="/libs/foundation/global.jsp" %>

<%@page session="false" %>
<%@page import="java.util.*" %>
<%@taglib prefix="havells" uri="http://www.bootcamp.com/taglibs"%>

<%@ page contentType="text/html; charset=utf-8" %>

<havells:concatenation sentence1="${properties.sentence1}" sentence2="${properties.sentence2}" />

<havells:isEdit>
    <cq:include path="customImage" resourceType="/apps/cq-bootcamp/components/contents/Image"/>
</havells:isEdit>
