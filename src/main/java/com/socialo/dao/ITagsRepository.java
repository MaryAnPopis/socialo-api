package com.socialo.dao;

import com.socialo.dto.TagDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITagsRepository extends JpaRepository<TagDTO, Long> {
    TagDTO findByName(String name);
    Optional<TagDTO> findOneByNameIgnoreCase(String name);
}
