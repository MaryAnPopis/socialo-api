package com.socialo.services;

import com.socialo.dto.PostDTO;
import com.socialo.models.Post;

import java.util.List;

public interface PostService {
    PostDTO create(Post post);
    List<PostDTO> getAll();
    List<PostDTO> getAllOrderedByDate();
    List<PostDTO> getPostsByUser(Long id);
    PostDTO getById(Long id);
}
