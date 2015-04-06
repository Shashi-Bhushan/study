package com.ig.bootcamp.core.servlets;
import com.day.cq.wcm.api.NameConstants;
import com.day.jcr.vault.util.JcrConstants;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component(name = "news feed component", description = "this is a component", immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/service/news")
})
public class NewsFeed extends SlingSafeMethodsServlet {
    public static final Logger log = LoggerFactory.getLogger(MapServlet.class);

    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
       String yearFormat = "YYYY";
        String monthFormat = "MM";
        Date date = new Date();
        SimpleDateFormat year = new SimpleDateFormat(yearFormat);
        SimpleDateFormat month = new SimpleDateFormat(monthFormat);
        int val = Integer.parseInt(request.getParameter("val"));
        String path=request.getParameter("path");
        String currentMonth = month.format(date).toString();
        String currentYear = year.format(date).toString();
       response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
       JSONObject obj;
        Resource resource = resourceResolver.getResource(path);
        try {
            for (Resource child : resource.getChildren()) {
                if (child.getName().equals(currentYear))
                    {
                    for (Resource subchild : child.getChildren()) {
                        if (subchild.getName().equals(currentMonth)) {
                            for (Resource newschild : subchild.getChildren()) {

                                ValueMap valueMap = newschild.adaptTo(ValueMap.class);
                                if (NameConstants.NT_PAGE.equals(valueMap.get(JcrConstants.JCR_PRIMARYTYPE))) {
                                    Resource content = newschild.getChild("jcr:content");
                                    ValueMap map = content.adaptTo(ValueMap.class);
                                     String str = map.get("jcr:title").toString();
                                    String id = map.get("id").toString();
                                    Date createdDate = map.get("jcr:created", Date.class);
                                    String date_create = createdDate.toString();
                                    obj = new JSONObject();
                                    obj.put("date", date_create);
                                    obj.put("name", str);
                                    obj.put("id", id);
                                 jsonArray.put(obj);
                                }
                            }
                        }
                    }
                }
            }
           jsonObject.put("children", jsonArray);
        } catch (JSONException e) {
            log.info("exception");
        }
        if ((val == 0) || (jsonArray.length() > val))
        {  response.getWriter().write(jsonObject.toString());
        }
        else {
            jsonObject = new JSONObject();
            response.getWriter().write(jsonObject.toString());
        }
    }
}
