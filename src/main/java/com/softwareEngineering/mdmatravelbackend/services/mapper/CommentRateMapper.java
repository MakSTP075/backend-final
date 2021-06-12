package com.softwareEngineering.mdmatravelbackend.services.mapper;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateDto;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateSaveDto;
import org.mapstruct.Mapper;

@Mapper


public interface CommentRateMapper {
    default CommentRate toEntity(RegisterCommentRateSaveDto commentRateRegisterSaveDto) {
        CommentRate commentRate = new CommentRate();
        commentRate.setUser(commentRateRegisterSaveDto.getUserID());
        commentRate.setRestaurant(commentRateRegisterSaveDto.getRestaurantID());
        commentRate.setHistoric(commentRateRegisterSaveDto.getHistoricID());
        commentRate.setSiteview(commentRateRegisterSaveDto.getSiteviewID());
        commentRate.setComment(commentRateRegisterSaveDto.getComment());
        commentRate.setRate(commentRateRegisterSaveDto.getRate());


        return commentRate;
    }
}
