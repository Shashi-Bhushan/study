package com.ig.bootcamp.core;
import com.day.jcr.vault.util.JcrConstants;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
@Component(label = "dealer component", description = "Service for Dealer Loactions", immediate = true, metatype = true)
@Service(DealerInterface.class)
public class DealerService implements DealerInterface {
    @Override
    public JSONObject dealerFunction(String state,String city,String path,SlingHttpServletRequest request) throws JSONException
    {
            JSONArray jsonArray=new JSONArray();
        JSONObject container=new JSONObject();
                        if (state != null) {
                path = path.concat("/" + state);
            }
            if (state != null && city != null) {
                path = path.concat("/" + city);
            }
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource(path);
            for (Resource child : resource.getChildren()) {
                ValueMap valueMap = child.adaptTo(ValueMap.class);
                if ("nt:unstructured".equals(valueMap.get(JcrConstants.JCR_PRIMARYTYPE))) {
                   JSONObject jsonObject = new JSONObject();
                    String name = valueMap.get("niceName").toString();
                    String id = child.getName();
                    if (city != null) {
                        jsonObject.put("email", valueMap.get("email").toString());
                        jsonObject.put("address", valueMap.get("address").toString());
                        jsonObject.put("contact", valueMap.get("mobile").toString());
                        jsonObject.put("dealerName", valueMap.get("dealerName").toString());
                    } else {
                        jsonObject.put("name", name);
                        jsonObject.put("id", id);
                    }
                    jsonArray.put(jsonObject);
                }
               container.put("States", jsonArray);
            }
        return container;
    }
}

