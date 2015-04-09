package com.ig.bootcamp.core.impl.servlets;
import com.ig.bootcamp.core.impl.SearchInterface;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.Servlet;
import java.io.IOException;

@Component(name = "Search component Servlet", description = "this is a component to fetch searches", enabled = true, immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/service/search"),
        @Property(name = "sling.servlet.methods", value = "POST")
}
)
public class ReadSearchResultServlet extends SlingAllMethodsServlet {
    @Reference
    SearchInterface searchInterface;
    @Override
    protected void doPost(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String path = request.getParameter("path");
            String searchThis = request.getParameter("searchThis");
            response.getWriter().write(searchInterface.searchFunction(path, searchThis, request).toString());

        } catch (Exception e) {
            log("---Exception occured", e);
        }
    }
}
