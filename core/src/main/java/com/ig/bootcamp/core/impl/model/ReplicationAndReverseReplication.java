package com.ig.bootcamp.core.impl.model;

import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.Replicator;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.framework.Constants;

import javax.jcr.Node;
import java.util.Calendar;

@Component(label ="Replication And Reverse Replication", metatype = false, immediate=true )
@Service(WorkflowProcess.class)
@Properties({
        @Property(name= Constants.SERVICE_DESCRIPTION, value = "Replication And Reverse Replication DESCRIPTION"),
        @Property(name= Constants.SERVICE_VENDOR, value = "Replication And Reverse Replication VENDOR"),
        @Property(name= "process.label", value = "Replication And Reverse Replication")
})

public class ReplicationAndReverseReplication implements WorkflowProcess{

    @Reference
    Replicator replicator;

    @Reference
    SlingSettingsService slingSettingsService;

    @Override
    public void execute( WorkItem workItem,  WorkflowSession workflowSession,  MetaDataMap metaDataMap) throws WorkflowException
    {
        String path=workItem.getWorkflowData().getPayload().toString();

        try {

            if (slingSettingsService.getRunModes().contains("author")) {
                replicator.replicate(workflowSession.getSession(), ReplicationActionType.ACTIVATE, path);
            }
            else {
                Node pageNode = workflowSession.getSession().getNode(path);
                Node contentNode = pageNode.getNode("jcr:content");
                contentNode.setProperty("hideInNav",true);
                contentNode.setProperty("cq:lastModified",Calendar.getInstance());
                contentNode.setProperty("cq:lastModifiedBy", workflowSession.getSession().getUserID());
                contentNode.setProperty("cq:distribute",true);
                workflowSession.getSession().save();
            }
        }
        catch (Exception e) {
            System.out.print("Generic Exception");
            e.printStackTrace(System.out);
        }
    }
}
