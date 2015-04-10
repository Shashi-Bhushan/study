<%@include file="/libs/foundation/global.jsp"%>
<%@page session="false" %>
<script>
	var Toggle = {};

	Toggle.manageFields = function(field){ console.log("dunction called");
		// get the panel of tab our drop down menu is on
		var panel = field.findParentByType('panel');

		console.log("Panel is : " , panel);
	}
</script>

This is the dynamic dialog component for the project of aem-internal.
<div style="clear: both"></div>


