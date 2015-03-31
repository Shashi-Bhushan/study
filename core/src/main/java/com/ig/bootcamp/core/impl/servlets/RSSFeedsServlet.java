package com.ig.bootcamp.core.impl.servlets;

/**
 * Created with IntelliJ IDEA.
 * User: shashi
 * Date: 3/15/15
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */

import com.day.cq.wcm.api.NameConstants;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: intelligrape
 * Date: 3/3/15
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */


@Component(name = "RSS Component", description = "This is a component, which returns newsfeed in RSS Format", immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/service/rss"),
}
)
public class RSSFeedsServlet extends SlingSafeMethodsServlet {


    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONArray jsonArray = new JSONArray();

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource("/content/cq-boootcamp/newsFeed/2015");

        int val = Integer.parseInt(request.getParameter("length"));

        try {
            for (Resource child : resource.getChildren()) {

                for (Resource date : child.getChildren()) {

                    ValueMap valueMap = date.adaptTo(ValueMap.class);
                    if (NameConstants.NT_PAGE.equals(valueMap.get(JcrConstants.JCR_PRIMARYTYPE))) {
                        Resource content = date.getChild(JcrConstants.JCR_CONTENT);
                        ValueMap map = content.adaptTo(ValueMap.class);

                        String str = map.get("jcr:title").toString();
                        String id = map.get("id").toString();
                        JSONObject jsonObject = new JSONObject();

                        jsonObject.put("name", str);
                        jsonObject.put("id", id);

                        jsonArray.put(jsonObject);
                    }
                }
            }

        } catch (JSONException e) {
            LoggerFactory.getLogger(RSSFeedsServlet.class).error("JSON Exception Occurred");
        }

        if ((val == 0) || (jsonArray.length() > val))
            response.getWriter().write(jsonArray.toString());
        else {
            response.getWriter().write(new JSONObject().toString());

        }
    }
}