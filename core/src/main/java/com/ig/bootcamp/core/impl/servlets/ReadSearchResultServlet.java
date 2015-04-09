package com.ig.bootcamp.core.impl.servlets;

import com.ig.bootcamp.core.impl.SearchInterface;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(name = "Search component", description = "this is a component to fetch searches", enabled = true, immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/service/search"),
}
)
public class ReadSearchResultServlet extends SlingSafeMethodsServlet {
    @Reference
    SearchInterface searchInterface;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadSearchResultServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String path = request.getParameter("path");
            String searchThis = request.getParameter("searchThis");
            LOGGER.info("path---" + path);
            LOGGER.info("search----" + searchThis);
            response.getWriter().write(searchInterface.searchFunction(path, searchThis, request).toString());

        } catch (Exception e) {
            log("---Exception occured", e);
        }
    }
}
