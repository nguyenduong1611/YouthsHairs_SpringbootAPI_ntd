package com.example.doanweb.service.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.doanweb.entity.Services;
import com.example.doanweb.service.dto.ServiceDTO;

@Mapper(componentModel = "spring",uses = {})
public interface ServiceMapper2 extends EntityMapper<ServiceDTO, Services>{}
