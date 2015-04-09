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
    public JSONObject searchFunction(String path, String searchThis, SlingHttpServletRequest request) throws JSONException {
        String searchQuery = "SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE([" + path + "]) and CONTAINS(s.*, '" + searchThis + "')";
        ResourceResolver resourceResolver = request.getResourceResolver();
        Iterator<Resource> result = resourceResolver.findResources(searchQuery, Query.JCR_SQL2);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject json;
        while (result.hasNext()) {
            Resource resultResource = result.next();
            Page page = resultResource.adaptTo(Page.class);
            json = new JSONObject();
            json.put("path", page.getPath());
            json.put("title", page.getTitle());
            jsonArray.put(json);
        }
        jsonObject.put("data", jsonArray);
        return jsonObject;
    }
}
