package com.socialo.services.implementations;

import com.socialo.dao.ICommentsRepository;
import com.socialo.dao.IPostRepository;
import com.socialo.dao.IUserRepository;
import com.socialo.dto.CommentsDTO;

import com.socialo.dto.PostDTO;
import com.socialo.models.Comments;
import com.socialo.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialo.services.CommentsService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    ICommentsRepository repository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPostRepository postService;

    private ModelMapper modelMapper = new ModelMapper();

    public CommentsDTO create(Comments comment) {
        CommentsDTO newComment = modelMapper.map(comment, CommentsDTO.class);
        LocalDateTime localTime = LocalDateTime.now();
        newComment.setCreatedDateTime(localTime);
        newComment.setUser(userRepository.findByNickname(comment.getUserNickname()));
        PostDTO post = modelMapper.map(this.postService.findById(comment.getPostId()).get(), PostDTO.class);
        newComment.setPost(post);
        return repository.save(newComment);
    }

    public CommentsDTO update(Comments comment) {
        Optional<CommentsDTO> commentOpt = repository.findById(comment.getId());

        if(!commentOpt.isPresent()) {
            return null;
        }
        CommentsDTO persistedComment = commentOpt.get();

        persistedComment.setComment(comment.getComment());
        return  repository.save(persistedComment);
    }

    public Optional<CommentsDTO> getById(Long id){
        return repository.findById(id);
    }

}
