package com.example.doanweb.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.doanweb.entity.Services;
import com.example.doanweb.service.dto.ServiceDTO;

public class ServiceMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Services ToEntity(ServiceDTO serviceDTO) {
        Services services = new Services();
        modelMapper.map(serviceDTO, services);
        return services;
    }

    public ServiceDTO ToEntity(Services services) {
        ServiceDTO serviceDTO = new ServiceDTO();
        modelMapper.map(services, serviceDTO);
        return serviceDTO;
    }
}
