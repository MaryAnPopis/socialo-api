package com.socialo.services;

import com.socialo.dto.CommentsDTO;
import com.socialo.models.Comments;

import java.util.Optional;

public interface CommentsService {
    CommentsDTO create(Comments comment);
    CommentsDTO update(Comments comment);
    Optional<CommentsDTO> getById(Long id);
}
