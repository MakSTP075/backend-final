package com.softwareEngineering.mdmatravelbackend.services.mapper;
import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentRateDto;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import org.mapstruct.Mapper;

@Mapper

public interface CommentRateMapper {
    CommentRate commentRate = new CommentRate();

        commentRate.setComment(commentRateRegisterDto.getComment());


        historic.setHistoricName(historicRegisterDto.getHistoricName());
        historic.setDetails(historicRegisterDto.getDetails());
    }
}
