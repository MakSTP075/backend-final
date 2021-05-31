package com.softwareEngineering.mdmatravelbackend.services.mapper;
import com.softwareEngineering.mdmatravelbackend.data.models.Rate;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterRateDto;
import org.mapstruct.Mapper;

@Mapper

public interface RateMapper {
    default Rate toEntity(RegisterRateDto rateRegisterDto) {
        Rate rate = new Rate();
        rate.setRate(rateRegisterDto.getRate());

        return rate;
    }
}
