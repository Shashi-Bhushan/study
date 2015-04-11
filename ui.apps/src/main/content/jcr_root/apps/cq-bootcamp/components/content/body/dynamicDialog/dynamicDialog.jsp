<%@include file="/libs/foundation/global.jsp" %>
<%@page session="false" %>
<script>
	var Toggle = {};

	Toggle.manageFields = function (field) {
		// get the panel of tab our drop down menu is on
		var panel = field.findParentByType('panel');

		// get reference of fieldset from the panel
		var fieldSets = panel.findByType('dialogfieldset');
		var fieldSetsLength = fieldSets.length;

		for (var i = 0; i < fieldSetsLength; i++) {
			var fieldSet = fieldSets[i];

			if (fieldSet.getItemId() === field.getValue()) {
				fieldSet.show();
			} else {
				fieldSet.hide();
			}
		}
	}

	Toggle.manageTabs = function (field,noSwitch) {
		//get parent Tab Group
		var panel = field.findParentByType('tabpanel');
//		var panelSet = panel.findByType('panel');

		var tabs = ["props","textTab","imageTab"];
		var index = tabs.indexOf(noSwitch);

        panel.getComponent(noSwitch).disable(this);
		for (var i = 0; i < tabs.length; i++) {
			if (index == i) {
                //panel.unhideTabStripItem(i);
			} else {
                //panel.hiq	deTabStripItem(i);
			}
//			var text = field.findParentByType('dialog');//
			// .getField('./text');
			//panel.findByName("./textTab").hide();

		}
	}
	//	function t(tab, noSwitch) {
	//		var tabs = ['props', 'children', 'descendants', 'static', 'search', 'querybuilder', 'tags'];
	//		var index = tabs.indexOf(tab);
	//		if (index == -1) return;
	//		for (var i = 1; i < tabs.length; i++) {
	//			if (index == i) {
	//				this.unhideTabStripItem(i);
	//			} else {
	//				this.hideTabStripItem(i);
	//			}
	//		}
	//		this.doLayout();
	//		if (!noSwitch)this.activate(index);
	//	}
</script>
This is the dynamic dialog component for the project of aem-internal.
<div style="clear: both"></div>

