package com.ig.bootcamp.core;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.NameConstants;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;


import java.text.SimpleDateFormat;
import java.util.Date;

 @Component(label ="news feed component",description = "this is news feed service",immediate = true,metatype = true)
 @Service(NewsFeedInterface.class)
public class NewsFeedService implements NewsFeedInterface {
    @Override
    public JSONObject newsFeedFunction(String path,int count,SlingHttpServletRequest request)throws JSONException
    {

        ResourceResolver resourceResolver = request.getResourceResolver();
        String yearFormat = "YYYY";
        String monthFormat = "MM";
        Date date = new Date();
        SimpleDateFormat year = new SimpleDateFormat(yearFormat);
        SimpleDateFormat month = new SimpleDateFormat(monthFormat);

        String currentMonth = month.format(date).toString();
        String currentYear = year.format(date).toString();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject obj;
        Resource resource = resourceResolver.getResource(path);

            for (Resource child : resource.getChildren()) {
                if (child.getName().equals(currentYear))
                {
                    for (Resource subchild : child.getChildren()) {
                        if (subchild.getName().equals(currentMonth)) {
                            for (Resource newschild : subchild.getChildren()) {

                                ValueMap valueMap = newschild.adaptTo(ValueMap.class);
                                if (NameConstants.NT_PAGE.equals(valueMap.get(JcrConstants.JCR_PRIMARYTYPE))) {
                                    Resource content = newschild.getChild("jcr:content");
                                    ValueMap map = content.adaptTo(ValueMap.class);
                                    String title = map.get("jcr:title").toString();
                                    String id = map.get("id").toString();
                                    Date createdDate = map.get("jcr:created", Date.class);
                                    String date_create = createdDate.toString();
                                    obj = new JSONObject();
                                    obj.put("date", date_create);
                                    obj.put("name", title);
                                    obj.put("id", id);
                                    jsonArray.put(obj);
                                }
                            }
                        }
                    }
                }
            }
            jsonObject.put("children", jsonArray);
        if ((count == 0) || (jsonArray.length() > count))
        {   return jsonObject;
        }
        else {
            jsonObject = new JSONObject();
            return jsonObject;
        }


        }


    }





