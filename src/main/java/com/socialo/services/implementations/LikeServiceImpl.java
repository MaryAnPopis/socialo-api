package com.socialo.services.implementations;

import com.socialo.dao.ILikeRepository;
import com.socialo.dao.IPostRepository;
import com.socialo.dao.IUserRepository;
import com.socialo.dto.LikeDTO;
import com.socialo.dto.PostDTO;
import com.socialo.models.Like;
import com.socialo.services.LikeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private ILikeRepository repository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private  ILikeRepository likeRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public LikeDTO create(Like like) {
        LikeDTO likeDTO = modelMapper.map(like, LikeDTO.class);
        likeDTO.setUser(this.userRepository.findByNickname(like.getUserNickname()));
        Optional<PostDTO> post =  this.postRepository.findById(like.getPostId());
        likeDTO.setPost(post.get());
        likeDTO.setStatus(true);
        return this.repository.save(likeDTO);
    }

    public void delete (Long id) {

        Optional<LikeDTO> persistedLike = likeRepository.findById(id);

        if(!persistedLike.isPresent()) {
            return;
        }

        likeRepository.delete(persistedLike.get());
    }
}
