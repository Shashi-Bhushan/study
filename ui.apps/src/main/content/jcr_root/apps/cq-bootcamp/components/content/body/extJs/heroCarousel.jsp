<%@include file="/apps/cq-bootcamp/global.jsp" %>
<%@page session="false" %>

<script>
	Ext.application({
		name: 'HelloExt',
		launch: function() {
//			Ext.create('Ext.container.Viewport', {
//				layout: 'fit',
//				items: [
//					{
//						title: 'Hello Ext',
//						html : 'Hello! Welcome to Ext JS.'
//					}
//				]
//			});
			console.log("Ext loading")
		}
	});
</script>
<div style="clear:both;"></div>

This is the Ext Component
