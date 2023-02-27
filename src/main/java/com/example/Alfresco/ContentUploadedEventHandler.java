package com.example.Alfresco;
import org.alfresco.event.sdk.handling.handler.OnNodeCreatedEventHandler;
import org.alfresco.event.sdk.model.v1.model.DataAttributes;
import org.alfresco.event.sdk.model.v1.model.NodeResource;
import org.alfresco.event.sdk.model.v1.model.RepoEvent;
import org.alfresco.event.sdk.model.v1.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Sample event handler to demonstrate reacting to a document/file being uploaded to the repository.
 */
@Component
public class ContentUploadedEventHandler implements OnNodeCreatedEventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentUploadedEventHandler.class);

    public void handleEvent(final RepoEvent<DataAttributes<Resource>> repoEvent) {
        NodeResource nodeResource = (NodeResource) repoEvent.getData().getResource();
        LOGGER.info("A file was uploaded to the repository: {}, {}, {}", nodeResource.getId(), nodeResource.getNodeType(),
                nodeResource.getName());
    }
}
