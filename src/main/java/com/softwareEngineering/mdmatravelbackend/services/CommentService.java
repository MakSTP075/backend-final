package com.softwareEngineering.mdmatravelbackend.services;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterCommentDto;
import com.softwareEngineering.mdmatravelbackend.data.models.Comment;
import com.softwareEngineering.mdmatravelbackend.repositories.CommentRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Transactional()
    public Comment registerComment(RegisterCommentDto commentRegister) {
        log.debug("Request to REGISTER comment : {}", commentRegister);
        Comment comment = commentMapper.toEntity(commentRegister);
        comment = commentRepository.save(comment);

        return comment;
    }

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
