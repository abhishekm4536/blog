package com.myblog.service;

import com.myblog.payload.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

   public CommentDto createComment(long postId, CommentDto commentDTO);
   List<CommentDto> getCommentsByPostId(long postId);


   CommentDto getCommentById(Long postId, Long commentId);

   CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);

   void deleteComment(Long postId, Long commentId);
}
