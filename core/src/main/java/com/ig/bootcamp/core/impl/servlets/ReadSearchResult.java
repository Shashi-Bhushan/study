package com.ig.bootcamp.core.impl.servlets;

import com.ig.bootcamp.core.impl.SearchInterface;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONObject;

import javax.servlet.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

@Component(name = "Search component", description = "this is a component to fetch searches", enabled = true, immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/service/search"),
}
)
public class ReadSearchResult extends SlingSafeMethodsServlet {
    @Reference
    SearchInterface searchInterface;

    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsonObject;
        String path = request.getParameter("path");
        String search = request.getParameter("search");
        String searchQuery = "SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE([" + path + "]) and CONTAINS(s.*, '" + search + "')";
        try {
            jsonObject = searchInterface.searchFunction(path, searchQuery, request);
            response.getWriter().write(jsonObject.toString());

        } catch (Exception e) {
            log(e.toString());
        }

    }
}