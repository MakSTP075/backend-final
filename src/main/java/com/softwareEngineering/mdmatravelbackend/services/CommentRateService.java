package com.softwareEngineering.mdmatravelbackend.services;

import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateDto;
import com.softwareEngineering.mdmatravelbackend.repositories.CommentRateRepository;
import com.softwareEngineering.mdmatravelbackend.repositories.HistoricRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.CommentRateMapper;
import com.softwareEngineering.mdmatravelbackend.services.mapper.HistoricMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class CommentRateService {

    private final CommentRateRepository commentRateRepository;
    private final CommentRateMapper commentRateMapper;

    public CommentRate registerHistoric(RegisterCommentRateDto commentRateRegister) {
        log.debug("Request to REGISTER historic : {}", commentRateRegister);
        CommentRate commentRate = commentRateMapper.toEntity(commentRateRegister);
        commentRateRepository.save(commentRate);

        return commentRate;
    }
}
