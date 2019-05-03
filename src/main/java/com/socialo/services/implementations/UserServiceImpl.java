package com.socialo.services.implementations;

import com.socialo.dao.IUserRepository;
import com.socialo.dto.UserDTO;
import com.socialo.exception.ErrorResponse;
import com.socialo.models.User;
import com.socialo.services.TagsService;
import com.socialo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private TagsService tagService;

    private ModelMapper modelMapper = new ModelMapper();

    public boolean isPresent(User user){
        if(repository.findByNickname(user.getNickname()) != null) {
            return true;
        }else{
            return false;
        }
    }

    @Transactional()
    public Object create(User user){
        if(isPresent(user)){
            return new ErrorResponse("User already exist!", false);
        }else{
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            userDTO.setStatus(true);
            userDTO.setTags(new HashSet<>(tagService.getTags(user.getTags())));
            UserDTO userCreated = repository.save(userDTO);
            return new User(userCreated.getId(), userCreated.getNickname(),userCreated.isStatus());
        }
    }

    public Object login(User user){
        UserDTO logUser = repository.findByNickname(user.getNickname());
        if(logUser != null){
            return new User(logUser.getId(), logUser.getNickname(),logUser.isStatus());
        }else{
            return new ErrorResponse("The user doesn't exist!", false);
        }
    }

    public Optional<UserDTO> getById(Long id){
        return this.repository.findById(id);
    }
}
