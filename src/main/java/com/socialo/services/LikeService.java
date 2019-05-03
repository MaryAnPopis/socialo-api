package com.socialo.services;

import com.socialo.dto.LikeDTO;
import com.socialo.models.Like;

public interface LikeService {
    LikeDTO create(Like like);
    void delete (Long id);
}
