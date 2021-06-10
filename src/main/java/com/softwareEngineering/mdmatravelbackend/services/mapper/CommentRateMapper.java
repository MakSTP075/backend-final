package com.softwareEngineering.mdmatravelbackend.services.mapper;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateDto;
import org.mapstruct.Mapper;

@Mapper

public interface CommentRateMapper {
    default CommentRate toEntity(RegisterCommentRateDto commentRateRegisterDto) {
        CommentRate commentRate = new CommentRate();
        commentRate.setComment(commentRateRegisterDto.getComment());
        commentRate.setRate(commentRateRegisterDto.getRate());


        return commentRate;
    }
}
