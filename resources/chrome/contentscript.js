/**
 * Content script
 * 
 * @author luigi.agosti
 * 
 */
//====================================================================
//			INITIALIZATION
//====================================================================

var isCtrl = false;
var isActive = false;

var primaryColour = "#2E2E2E";
var secondayColour = "grey";
var opacity = "0.7";
var firstKey = 17;
var secondKey = 65;
var hrefVisibility = false;

document.onkeydown=function(e){
	if(!isActive) {
		if(e.which == firstKey) isCtrl = true;
		if(e.which == secondKey && isCtrl == true) {
			isCtrl = false;
			isActive = true;
			openDialog();
		}
	} else {
		if(e.which == 27) {
			//closeSearch();
		}
	}
}

function openDialog() {
	var links = getLinksAsString();
	log("open dialog receiving : " + links);
}

/*
function closeSearch() {
	log("exit");
	isActive = false;
	closeDialog();
}
*/
//====================================================================
//				UI
//====================================================================
/*
var slContainer;
var slDialog;
var slSuggestion1;
var slSuggestion2;

function openDialog() {
	log("opening dialog");
	slContainer = createContainerAndAddToBody();

	slDialog = createDialog();
	
	//var input = "<input id=\"gcels\" type=\"text\" style=\"position:relative; text-align:left; text-decoration:none; top:10px; left:15px; width:256px; height:24px; " +
	//	"font-family: 'Trebuchet MS', Arial, sans-serif, Tahoma; font-size: 13px; color:black;  z-index:2147483648;\" />";

	addSuggestions();
}

function createDialog() {
	var margin = "50";
	if(hrefVisibility === true) {
		margin = "70";
	}
	return createDivWithStyle("position:relative; top:4px; background-color:" + primaryColour + 
			"; text-align:left; text-decoration:none; height:" + margin + "px; -webkit-border-radius:7px; -moz-border-radius-topright:7px; opacity:1; " + 
			"filter:alpha(opacity=100);font-family: 'Trebuchet MS', Arial, sans-serif, Tahoma; font-size: 13px; color:black; z-index:2147483648;");
}

function createContainerAndAddToBody() {
	var element = createDivWithStyle("position:absolute; top:45%; left:42%; width:290px; text-align:left; text-decoration:none; border:0px; margin:0px; padding:0px;");
	getBody().appendChild(element);
	return element;
}

function createDivWithStyle(style) {
	return createDiv(style);
}

function createDiv(style, content) {
	var element = document.createElement("div");
	element.setAttribute("style", style);
	if(content != null) {
		element.innerHTML = content;
	}
	return element;
}

function closeDialog() {
	getBody().removeChild(slContainer);
	currentLinkIndex = 0;
	startWith = "";
}

function getBody() {
	return document.getElementsByTagName("body")[0];
}

*/
//====================================================================
//	check google links and return them as a \n separated string 
//====================================================================

var START_WITH = "http://googleads.g.doubleclick.net";

function getLinksAsString() {
	log("links as string");
	var googleAdsenseLinks;
	var counter = 0;
	
	var frame = document.getElementById("google_ads_frame1").contentDocument;
	var linkElements = frame.getElementsByTagName("a");
	for (var i = 0; i < linkElements.length; i++){
		var href = linkElements[i].href;
		if(href !== "" && href.indexOf(START_WITH) > -1) {
			log(href);
			googleAdsenseLinks = href + "\n";
		}
	}
	
	return googleAdsenseLinks;
}

function getLinkUsefulInformation(link) {
	var innerText = link.innerText;
	if(!innerText || innerText === null) {
		return "";
	}
	return innerText;
}

//======================================================================
// log abstraction
//======================================================================

function log(msg) {
	console.info(msg);
}

function logError(msg) {
	console.error(msg);
}