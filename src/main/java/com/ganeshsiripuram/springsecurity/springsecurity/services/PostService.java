package com.ganeshsiripuram.springsecurity.springsecurity.services;


import com.ganeshsiripuram.springsecurity.springsecurity.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);
}
