package com.ig.bootcamp.core;

import com.day.cq.security.AccountManager;
import com.day.cq.security.AccountManagerFactory;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.HashMap;
import java.util.Map;

import static org.apache.sling.api.resource.ResourceResolverFactory.SUBSERVICE;

@Service(SignUpInterface.class)
@Component(name = "User SignUp component", description = "this is a sign up component", immediate = true, metatype = true)

public class SignUpImpl implements SignUpInterface {
    public static final Logger log = LoggerFactory.getLogger(SignUpImpl.class);

    @Reference
    AccountManagerFactory accountManagerFactory;
    @Reference
    private ResourceResolverFactory resolverFactory;
    @Override
    public void signUpCreation(SlingHttpServletRequest request)
    {
        Map<String, Object> serviceParams = new HashMap<String, Object>();
        serviceParams.put(SUBSERVICE, "signUpService");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        ResourceResolver resolver=null;
        try {
            resolver=resolverFactory.getServiceResourceResolver(serviceParams);
            Session session = resolver.adaptTo(Session.class);
            log.info(resolver.getUserID());
            AccountManager accountManager = accountManagerFactory.createAccountManager(session);
            Map<String,RequestParameter[]> profilemap = new HashMap<String,RequestParameter[]>();
            profilemap.put("email", request.getRequestParameters("email"));
            profilemap.put("name", request.getRequestParameters("name"));
            profilemap.put("surname", request.getRequestParameters("surname"));
            profilemap.put("mobile", request.getRequestParameters("mobile"));
            profilemap.put("dob", request.getRequestParameters("dob"));
            profilemap.put("billingAddress", request.getRequestParameters("billingAddress"));
            profilemap.put("shippingAddress", request.getRequestParameters("shippingAddress"));
            accountManager.getOrCreateAccount(userName, password, "admin", profilemap);
            log.info("-- User Created --");
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (RepositoryException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if(resolver != null){
                resolver.close();
            }
        }

    }
}


