package com.ganeshsiripuram.springsecurity.springsecurity.services;


import com.ganeshsiripuram.springsecurity.springsecurity.dto.PostDTO;
import com.ganeshsiripuram.springsecurity.springsecurity.entities.PostEntity;
import com.ganeshsiripuram.springsecurity.springsecurity.entities.User;
import com.ganeshsiripuram.springsecurity.springsecurity.exceptions.ResourceNotFoundException;
import com.ganeshsiripuram.springsecurity.springsecurity.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;




    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("user {user}",user);
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }
}
