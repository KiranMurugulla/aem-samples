
<%--
  AEM Samples Test Page component.
  Page component to test AEM Samples functionality
--%>
<%@page import="com.aem.samples.readrepository.SlingResourceReader"%>
<%@include file="/libs/foundation/global.jsp"%>
<%@page session="false" %>
<%@page import="com.aem.samples.readrepository.JCRResourceReader" %>
<%@page import="javax.jcr.Session" %>
<h2 align="center"> AEM Sample Test Page</h2>
<%
	JCRResourceReader jcrReader = sling.getService(JCRResourceReader.class);
	Session session = slingRequest.getResourceResolver().adaptTo(Session.class);
%>
<h3>Reading a property with JCR API</h3>
<%=jcrReader.getProperty("jcr:title","/content/geometrixx/en/products/triangle/jcr:content",session) %>