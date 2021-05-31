package com.softwareEngineering.mdmatravelbackend.services;
import com.softwareEngineering.mdmatravelbackend.data.models.Siteview;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterSiteviewDto;
import com.softwareEngineering.mdmatravelbackend.repositories.SiteviewRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.SiteviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j


public class SiteviewService {
    private final SiteviewRepository siteviewRepository;
    private final SiteviewMapper siteviewMapper;

    @Transactional()
    public Siteview registerSiteview(RegisterSiteviewDto siteviewRegister) {
        log.debug("Request to REGISTER siteview : {}", siteviewRegister);
        Siteview siteview = siteviewMapper.toEntity(siteviewRegister);
        siteview = siteviewRepository.save(siteview);

        return siteview;
    }

    public void deleteSiteviewById(long id){
        siteviewRepository.deleteById(id);
    }


    public Siteview putSiteviewById(Siteview siteview){ //image
        return  siteviewRepository.updateSiteview(siteview.getSiteviewName(),siteview.getDetails());
    }

    public List<Siteview> getAllSiteview(){
        return siteviewRepository.findAll();
    }

    public Siteview getSiteviewById(long id){
        return siteviewRepository.findById(id);
    } //.orElseThrow()
}
