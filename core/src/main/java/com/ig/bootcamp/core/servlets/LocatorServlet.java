package com.ig.bootcamp.core.servlets;
import com.ig.bootcamp.core.DealerInterface;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
@Component(name = "Dealer Locator", description = "this is Servlet for finding dealer locations", immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/dealer")
})
public class LocatorServlet extends SlingSafeMethodsServlet {
    public  static final Logger log=LoggerFactory.getLogger(LocatorServlet.class);
    @Reference
    DealerInterface dealerInterface;
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
       response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String path =request.getParameter("path") ;
        try
        {
        JSONObject jsonObject = dealerInterface.dealerFunction(state, city, path, request);
        response.getWriter().write(jsonObject.toString());
          }
        catch (Exception e) {
        log.info("exception="+e);

    }
   }}

