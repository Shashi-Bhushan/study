package com.ig.bootcamp.core;

import com.day.cq.wcm.api.Page;
import com.ig.bootcamp.core.impl.SearchInterface;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import javax.jcr.query.Query;
import java.util.Iterator;

@Component(label = "search component", description = "this is for site search", immediate = true, metatype = true)
@Service(SearchInterface.class)
public class SearchService implements SearchInterface {
    @Override
    public JSONObject searchFunction(String path, String searchQuery, SlingHttpServletRequest request) throws JSONException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Iterator<Resource> result = resourceResolver.findResources(searchQuery, Query.JCR_SQL2);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1;
        while (result.hasNext()) {
            Resource res = result.next();
            Page page = res.adaptTo(Page.class);
            jsonObject1 = new JSONObject();
            jsonObject1.put("path", page.getPath());
            jsonObject1.put("title", page.getTitle());
            jsonArray.put(jsonObject1);
        }
        jsonObject.put("data", jsonArray);
        return jsonObject;
    }
}
