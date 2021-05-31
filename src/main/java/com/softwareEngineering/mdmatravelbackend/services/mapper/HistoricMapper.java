package com.softwareEngineering.mdmatravelbackend.services.mapper;

import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterHistoricDto;

import org.mapstruct.Mapper;

@Mapper

public interface HistoricMapper {
    default Historic toEntity(RegisterHistoricDto historicRegisterDto) {
        Historic historic = new Historic();
        historic.setHistoricName(historicRegisterDto.getHistoricName());
        historic.setDetails(historicRegisterDto.getDetails());
        // image

        return historic;
    }
}
