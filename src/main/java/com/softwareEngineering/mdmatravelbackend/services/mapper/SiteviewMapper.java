package com.softwareEngineering.mdmatravelbackend.services.mapper;

import com.softwareEngineering.mdmatravelbackend.data.models.Siteview;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterSiteviewDto;

import org.mapstruct.Mapper;

@Mapper

public interface SiteviewMapper {
    default Siteview toEntity(RegisterSiteviewDto siteviewRegisterDto) {
        Siteview siteview = new Siteview();
        siteview.setSiteviewName(siteviewRegisterDto.getSiteviewName());
        siteview.setDetails(siteviewRegisterDto.getDetails());
        //image
        return siteview;
    }
}
