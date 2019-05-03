package com.socialo.dao;

import com.socialo.dto.CommentsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentsRepository extends JpaRepository<CommentsDTO, Long> {
}
