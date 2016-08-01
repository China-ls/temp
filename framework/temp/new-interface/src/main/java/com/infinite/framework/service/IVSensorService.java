package com.infinite.framework.service;

import com.infinite.framework.entity.VirtualSensor;

/**
 * @author by hx on 16-7-25.
 * @since 1.0
 */
public interface IVSensorService {

    public VirtualSensor createVSensor(String appkey, VirtualSensor sensor);

    public VirtualSensor updateVSensor(VirtualSensor sensor);

    public VirtualSensor remveVSensor(String sensorId);

}
