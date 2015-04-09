package com.ig.bootcamp.core;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
public interface NewsFeedInterface {
    public JSONObject newsFeedFunction(String path,int val,SlingHttpServletRequest request)throws JSONException;
}
