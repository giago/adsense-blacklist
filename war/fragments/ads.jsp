<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<% UserService userService = UserServiceFactory.getUserService(); %>
<% User user = userService.getCurrentUser(); %>

<div class="da-ads" style="margin-top:10px; margin-bottom:10px;">
<% if ((user != null && userService.isUserAdmin()) || request.getServerName().contains("localhost") || request.getServerName().contains(".adsense-blacklist.appspot.com")) { %>
	<div style="width: 728px; height: 90px; border: 1px green solid;">space for google ads</div>
<% } else { %>
	<script type="text/javascript"><!--
	google_ad_client = "pub-2374318088795044";
	/* 728x90, created 5/28/10 */
	google_ad_slot = "0331811464";
	google_ad_width = 728;
	google_ad_height = 90;
	//-->
	</script>
	<script type="text/javascript"
	src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
	</script>	
<% } %>
</div>