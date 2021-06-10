package com.softwareEngineering.mdmatravelbackend.services;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateDto;
import com.softwareEngineering.mdmatravelbackend.repositories.CommentRateRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.CommentRateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentRateService {

    private final CommentRateRepository commentRateRepository;
    private final CommentRateMapper commentRateMapper;


    public CommentRate registerCommentRate(RegisterCommentRateDto commentRateRegister) {
        log.debug("Request to REGISTER comment and rate : {}", commentRateRegister);
        CommentRate commentRate = commentRateMapper.toEntity(commentRateRegister);
        commentRate = commentRateRepository.save(commentRate);

        return commentRate;
    }

    public List<CommentRate> getAllCommentAndRateByRestaurantId(long id){
        return commentRateRepository.getAllRestaurantCR(id);
    }

    public List<CommentRate> getAllCommentAndRateByHistoricId(long id){
        return commentRateRepository.getAllHistoricCR(id);
    }

    public List<CommentRate> getAllCommentAndRateBySiteviewId(long id){
        return commentRateRepository.getAllSiteviewCR(id);
    }
}

