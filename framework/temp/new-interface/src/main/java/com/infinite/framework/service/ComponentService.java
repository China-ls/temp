package com.infinite.framework.service;

import com.infinite.framework.entity.Action;
import com.infinite.framework.entity.Component;

/**
 * @author by hx on 16-7-25.
 * @since 1.0
 */
public interface ComponentService {

    public Component createComponent(String sensorId, Component component);

    public Component updateComponent(Component sensor);

    public Component remveComponent(String componentId);

    public Component addComponentAction(String componentId, Action action);

}
