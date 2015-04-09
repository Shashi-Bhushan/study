package com.ig.bootcamp.core.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

public interface SearchInterface {
    public JSONObject searchFunction(String path, String searchThis, SlingHttpServletRequest request) throws JSONException;
}
