package com.socialo.dao;

import com.socialo.dto.PostDTO;
import com.socialo.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPostRepository extends JpaRepository<PostDTO, Long> {
    List<PostDTO> findAllByOrderByTimestampDesc();
    List<PostDTO> findByUserOrderByTimestampDesc(Optional<UserDTO> user);
}
