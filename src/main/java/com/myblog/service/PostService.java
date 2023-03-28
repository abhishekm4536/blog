package com.myblog.service;
import java.util.List;

import com.myblog.payload.PostDto;
import com.myblog.payload.PostResponse;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);


}
