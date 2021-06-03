package com.softwareEngineering.mdmatravelbackend.services;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterHistoricDto;
import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import com.softwareEngineering.mdmatravelbackend.repositories.HistoricRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.HistoricMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HistoricService {
    private final HistoricRepository historicRepository;
    private final HistoricMapper historicMapper;

    @Transactional()
    public Historic registerHistoric(RegisterHistoricDto historicRegister) {
        log.debug("Request to REGISTER historic : {}", historicRegister);
        Historic historic = historicMapper.toEntity(historicRegister);
        historicRepository.save(historic);


        return historic;
    }

    public void deleteHistoricById(long id){
        historicRepository.deleteById(id);
    }


    public Historic putHistoricById(Historic historic){
        Historic oldHistoric = historicRepository.findById(historic.getId()).orElseThrow();
        oldHistoric.setHistoricName(historic.getHistoricName());
        oldHistoric.setDetails(historic.getDetails());
        historicRepository.save(oldHistoric);
        return  oldHistoric;
    }

    public List<Historic> getAllHistoric(){
        return historicRepository.findAll();
    }

    public Historic getHistoricById(long id){
        return historicRepository.findById(id);
    }
}
