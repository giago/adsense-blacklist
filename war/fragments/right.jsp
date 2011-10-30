<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<% UserService userService = UserServiceFactory.getUserService();%>
<% User user = userService.getCurrentUser(); %>
<div class="right">
<% if ((user != null && userService.isUserAdmin()) || request.getServerName().contains("localhost") || request.getServerName().contains(".adsense-blacklist.appspot.com")) { %>
	<div style="width: 160px; height: 600px; border: 1px green solid;">space for google ads</div>
<% } else {%>
	<script type="text/javascript"><!--
	google_ad_client = "pub-2374318088795044";
	/* 160x600, created 4/4/10 */
	google_ad_slot = "1700018000";
	google_ad_width = 160;
	google_ad_height = 600;
	//-->
	</script>
	<script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"></script>
<% } %>
</div>