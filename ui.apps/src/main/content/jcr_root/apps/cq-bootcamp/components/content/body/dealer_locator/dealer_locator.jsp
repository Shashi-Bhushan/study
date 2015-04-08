<%@include file="/apps/cq-bootcamp/components/global.jsp"%>
<%@page session="false" %>
<body>
<div class="formElementsWrapper">
    <div class="fieldWrap"><select name="" class="select" id="state">
        <option value="cities">Select State</option>
    </select></div>
    <div class="fieldWrap"><select name="" class="select" id="cities">
        <option value="cities">Select City</option>
    </select></div>
    <div class="fieldWrap"><input name="" type="button" class="submit" value="Submit"></div>
    <div id="message"> </div>
</div><br/>
<div class="tableWrapper">
    <div class="tableHolder">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody id="table"><tr>
                <th>S.No.</th>
                <th>Store Name</th>
                <th>Address</th>
                <th>Contact no.</th>
                <th>Email</th>
            </tr>
            </tbody></table>
    </div>
    <input type="hidden" value=${properties.rootpath} id="path"/>
    <input type="hidden" value=${properties.error} id="Error"/>

</div>
</body>


