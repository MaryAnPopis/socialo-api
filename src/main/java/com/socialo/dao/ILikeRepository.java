package com.socialo.dao;

import com.socialo.dto.LikeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepository extends JpaRepository<LikeDTO, Long> {
}
