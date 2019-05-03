package com.socialo.dao;

import com.socialo.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<UserDTO, Long> {
    UserDTO findByNickname(String nickname);
}
