package com.ig.bootcamp.core;

import com.day.cq.security.AccountManager;
import com.day.cq.security.AccountManagerFactory;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component(name = "User component", description = "this is a component", immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.paths", value = "/bin/service/user")
})
public class userCreate extends SlingAllMethodsServlet {
    public static final Logger log = LoggerFactory.getLogger(userCreate.class);

    @Reference
    AccountManagerFactory accountManagerFactory;

    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            ResourceResolver resolver = request.getResourceResolver();
            Session session = request.getResourceResolver().adaptTo(Session.class);
            AccountManager accountManager = accountManagerFactory.createAccountManager(session);
            Map map = new HashMap();
            map.put("email", request.getRequestParameters("email"));
            map.put("name", request.getRequestParameters("name"));
            map.put("surname", request.getRequestParameters("surname"));
            map.put("mobile", request.getRequestParameters("mobile"));
            map.put("dob", request.getRequestParameters("dob"));
            map.put("billingAddress", request.getRequestParameters("billingAddress"));
            map.put("shippingAddress", request.getRequestParameters("shippingAddress"));
            pw.println(accountManager);
            accountManager.getOrCreateAccount(userName, password, "admin", map);
            log.info("------------------------------- User Created");
        } catch (RepositoryException e) {
            e.printStackTrace();
            pw.print(e);
        }
    }
}