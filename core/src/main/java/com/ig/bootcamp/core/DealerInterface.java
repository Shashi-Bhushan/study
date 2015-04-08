package com.ig.bootcamp.core;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
public interface DealerInterface {
public JSONObject dealerFunction(String state,String city,String path,SlingHttpServletRequest request)throws JSONException;
}

