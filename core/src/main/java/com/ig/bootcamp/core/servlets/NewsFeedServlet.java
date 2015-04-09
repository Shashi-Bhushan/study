package com.ig.bootcamp.core.servlets;

import com.ig.bootcamp.core.NewsFeedInterface;
import org.apache.felix.scr.annotations.*;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

@Component(label = "News Feed Servlet", description = "this is news feed servlet", immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/newsfeed")
})
public class NewsFeedServlet extends SlingSafeMethodsServlet {
    public static final Logger log = LoggerFactory.getLogger(NewsFeedServlet.class);
    @Reference
    NewsFeedInterface newsFeedInterface;
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String path = request.getParameter("path");
        int count = Integer.parseInt(request.getParameter("count"));
        try {
            JSONObject jsonObject = newsFeedInterface.newsFeedFunction(path, count, request);
            response.getWriter().write(jsonObject.toString());
        } catch (Exception e) {
            log.info("exception=" + e);
        }
    }
}


