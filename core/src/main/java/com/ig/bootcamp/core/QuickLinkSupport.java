package com.ig.bootcamp.core;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class QuickLinkSupport {
    Logger logger = LoggerFactory.getLogger(QuickLinkSupport.class);
    ResourceResolver resourceResolver;
    String path;

    public class QuickLink {
        String icon;
        String linkname;
        String link;

        QuickLink(String icon, String linkname, String link) {
            this.icon = icon;
            this.linkname = linkname;
            this.link = link;

        }

        public String getIcon() {
            return icon;
        }

        public String getLink() {
            return link;
        }

        public String getLinkname() {
            return linkname;
        }
    }

    List<QuickLink> quickLinkList = new ArrayList<QuickLink>();

    public QuickLinkSupport(ResourceResolver resourceResolver, String path) {

        this.resourceResolver = resourceResolver;
        this.path = path;
        populate(this.path, this.resourceResolver);

    }

    public void populate(String path, ResourceResolver resourceResolver) {
        Resource resource = resourceResolver.getResource(path);
        System.out.println("Hey this is my resource ---" + resource.toString());
        Resource child = resource.getChild("sublinks");

        for (Resource subchild : child.getChildren()) {
            ValueMap valueMap = subchild.adaptTo(ValueMap.class);

            String icon = valueMap.get("icon").toString();
            String linkname = valueMap.get("linkName").toString();
            String link = valueMap.get("link").toString();
            quickLinkList.add(new QuickLink(icon, linkname, link));
        }
    }

    public List<QuickLink> getQuickLinkList() {
        return quickLinkList;
    }
}
