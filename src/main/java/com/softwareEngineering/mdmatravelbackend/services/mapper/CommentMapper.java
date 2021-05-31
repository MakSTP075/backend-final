package com.softwareEngineering.mdmatravelbackend.services.mapper;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentDto;
import com.softwareEngineering.mdmatravelbackend.data.models.Comment;
import org.mapstruct.Mapper;

@Mapper

public interface CommentMapper {
    default Comment toEntity(RegisterCommentDto commentRegisterDto) {
        Comment comment = new Comment();
        comment.setComment(commentRegisterDto.getComment());

        return comment;
    }
}
