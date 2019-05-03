package com.socialo.services;

import com.socialo.dto.TagDTO;
import com.socialo.models.Tag;

import java.util.List;

public interface TagsService {
    Tag create(Tag post);
    boolean isPresent(Tag tag);
    List<TagDTO> getTags(String tags);
    List<Tag> getAll();
}
