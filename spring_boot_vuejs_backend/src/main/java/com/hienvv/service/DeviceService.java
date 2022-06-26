package com.hienvv.service;

import com.hienvv.entity.Device;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceService {
    List<Device> findAllDevices();
    Device addDevice(Device device);
    void deleteDevice(Long id);
}
