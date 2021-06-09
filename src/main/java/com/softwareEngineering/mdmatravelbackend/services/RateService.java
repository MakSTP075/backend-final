package com.softwareEngineering.mdmatravelbackend.services;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterRateDto;
import com.softwareEngineering.mdmatravelbackend.data.models.Rate;
import com.softwareEngineering.mdmatravelbackend.repositories.RateRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.RateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class RateService {
    private final RateRepository rateRepository;
    private final RateMapper rateMapper;

    @Transactional()
    public Rate registerRate(RegisterRateDto rateRegister) {
        log.debug("Request to REGISTER rate : {}", rateRegister);
        Rate rate = rateMapper.toEntity(rateRegister);
        rateRepository.save(rate);

        return rate;
    }

    public List<Rate> getAllRate() { //mada ti ne treba jer ces output srednju vrijendost ukupnih ocjena
        return rateRepository.findAll();
    }

    public double avarageRestaurantRate(long id){
        return rateRepository.findAvarageRateRestaurantByID(id);
    }

    public double avarageHistoricRate(long id){
        return rateRepository.findAvarageRateHistoricByID(id);
    }

    public double avarageSiteviewRate(long id){
        return rateRepository.findAvarageRateSiteviewByID(id);
    }

    /* enum


    public double avarageRate() { // da izbaci srednju vrijednost npr 4.6 / 5
        List<Rate> rates = getAllRate();
        double total = 0;
        double averageRate = 0;
        for(int i = 0; i < rates.size(); i++){
            total = total + rates.indexOf(i);
        }
        averageRate= total /rates.size();
        return averageRate;
    }
     */
}
