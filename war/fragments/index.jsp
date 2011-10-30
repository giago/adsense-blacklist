<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
	<div class="content">
	  <div class="title"><h2>Google AdSense Open Black List</h2></div>    
	  <jsp:include page="/fragments/ads.jsp"/> 
	  <div class="sentence">
	  	Google AdSense Black List is a public list of host that google show on your site and usually they pay very little, even less than 0.01 USD.
	  </div> 
	  <div class="sentence">
	  	This service is open to everyone and you can use our google chrome extension to post the urls.
	  </div>
	  <div class="sentence">
	  	<div class="gridTitle">
	  		<h3>Black List 100</h3>
	  	</div>
	  	<div class="gridListLeft">
		  	<c:if test="${not empty requestScope.blackList}" >
				<div id="blackList" class="blackList">
				<c:forEach items="${requestScope.blackList}" var="url">
					<c:out value="${url.domain}" /><br>
				</c:forEach>
				</div>
			</c:if>
			<c:if test="${empty requestScope.blackList}" >
				<div class="result"><div class="resultUrl">The black list seams empty, strange try later.</div></div>
			</c:if>
	  	</div>	  
	  	<div class="gridListRight">
		  	Is easy to remove low paying websites from the list of adverts that Google AdSense is sending you. 
		</div>	
	  	<div class="gridListRight">  	
		  	Copy the list on the left and paste it on the page "Competitive Ad Filter" on your google adsense account page.
	  	</div>	
	  	<div class="gridListRight">
		  	In this way you will get more adverts that are paying more, and you will be able to get a lot more money per click.
	  	</div>
	  	<div class="gridListRight">
		  	If you want to share your list use our <a href="/submit.jsp">"submit"</a> page<!--   or our <a href="/extension.jsp">"extension"</a> -->.
	  	</div>	
	  </div>
	</div>
	  <jsp:include page="/fragments/ads.jsp"/> 	
</center>