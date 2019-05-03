package com.socialo.services.implementations;

import com.socialo.dao.IPostRepository;
import com.socialo.dao.IUserRepository;
import com.socialo.dto.PostDTO;
import com.socialo.dto.UserDTO;
import com.socialo.models.Post;
import java.lang.reflect.Type;

import com.socialo.services.PostService;
import com.socialo.services.TagsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private IPostRepository repository;
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private TagsService tagService;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional()
    public PostDTO create(Post post){
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        postDTO.setUser(this.userRepository.findByNickname(post.getUser().getNickname()));
        LocalDateTime localTime = LocalDateTime.now();
        Timestamp timeStamp = Timestamp.valueOf(localTime);
        postDTO.setTimestamp(timeStamp);
        postDTO.setTags(new HashSet<>(tagService.getTags(post.getTagsString())));

        return this.repository.save(postDTO);
    }

    @Transactional(readOnly = true)
    public List<PostDTO> getAll(){
        return this.repository.findAll();
    }

    public List<PostDTO> getAllOrderedByDate() {
        return this.repository.findAllByOrderByTimestampDesc();
    }

    public List<PostDTO> getPostsByUser(Long id) {
        Optional<UserDTO> user = userRepository.findById(id);
        List<PostDTO> dto = this.repository.findByUserOrderByTimestampDesc(user);
        return dto;
    }

    public PostDTO getById(Long id){
        Optional<PostDTO> postDTO  = this.repository.findById(id);
        return postDTO.get();
    }

}
