package com.ig.bootcamp.core.servlets;

import com.ig.bootcamp.core.SignUpInterface;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

@Component(immediate = true)
@Service(SignUpServlet.class)
@SlingServlet(paths = {"/bin/service/signup"}, methods = {"POST"},extensions = {"html"})

public class SignUpServlet extends SlingAllMethodsServlet {
    @Reference
    SignUpInterface signUpInterface;

    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
              signUpInterface.signUpCreation(request);
    }
}


