package com.softwareEngineering.mdmatravelbackend.services;
import com.softwareEngineering.mdmatravelbackend.data.models.*;
import com.softwareEngineering.mdmatravelbackend.repositories.*;
import com.softwareEngineering.mdmatravelbackend.services.mapper.CommentRateMapper;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentRateService {

    private final CommentRateRepository commentRateRepository;
    private final CommentRateMapper commentRateMapper;
    private final RestaurantRepository restaurantRepository;
    private final HistoricRepository historicRepository;
    private final SiteviewRepository siteviewRepository;
    private final UserRepository userRepository;



    public CommentRate registerCommentRate(RegisterCommentRateDto commentRateRegister) { //ovdje
        log.debug("Request to REGISTER comment and rate : {}", commentRateRegister);

        User user = new User();
        if(userRepository.findById(commentRateRegister.getUserID()).isPresent()){
            user = userRepository.findById(commentRateRegister.getUserID()).get();
        }

        Restaurant restaurant = new Restaurant();
        if(restaurantRepository.findById(commentRateRegister.getRestaurantID()).isPresent()){
            restaurant = restaurantRepository.findById(commentRateRegister.getRestaurantID()).get();
        }

        Historic historic = new Historic();
        if(historicRepository.findById(commentRateRegister.getHistoricID()).isPresent()){
            historic = historicRepository.findById(commentRateRegister.getHistoricID()).get();
        }

        Siteview siteview = new Siteview();
        if(siteviewRepository.findById(commentRateRegister.getSiteviewID()).isPresent()){
            siteview =siteviewRepository.findById(commentRateRegister.getSiteviewID()).get();
        }


        RegisterCommentRateSaveDto newComment = new RegisterCommentRateSaveDto(user, restaurant, historic, siteview, commentRateRegister.getComment(), commentRateRegister.getRate());
        CommentRate commentRate = commentRateMapper.toEntity(newComment);
        commentRate = commentRateRepository.save(commentRate);

        return commentRate;
    }

    public List<CommentRate> getAllCommentAndRateByRestaurantId(long id){
        Restaurant r = restaurantRepository.findById(id).orElseThrow();
        List<CommentRate> commentsRates = r.getCommentAndRates();
        return commentsRates;
    }

    public List<CommentRate> getAllCommentAndRateByHistoricId(long id){
        Historic h = historicRepository.findById(id).orElseThrow();
        List<CommentRate> commentsRates = h.getCommentAndRates();
        return commentsRates;
    }

    public List<CommentRate> getAllCommentAndRateBySiteviewId(long id){
        Siteview s = siteviewRepository.findById(id).orElseThrow();
        List<CommentRate> commentsRates = s.getCommentAndRates();
        return commentsRates;
    }
}
