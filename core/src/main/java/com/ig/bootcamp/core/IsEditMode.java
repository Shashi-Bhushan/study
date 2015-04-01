package com.ig.bootcamp.core;

import com.day.cq.wcm.api.WCMMode;
import org.apache.sling.api.SlingHttpServletRequest;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static org.apache.sling.scripting.jsp.util.TagUtil.getRequest;

public class IsEditMode extends BodyTagSupport{

    public int doStartTag() {
        SlingHttpServletRequest request = getRequest(pageContext);
        WCMMode wcmMode=WCMMode.fromRequest(request);
        if (wcmMode==WCMMode.EDIT)
        {
            return(EVAL_BODY_INCLUDE);
        } else {
            return(SKIP_BODY);
        }
    }
}


