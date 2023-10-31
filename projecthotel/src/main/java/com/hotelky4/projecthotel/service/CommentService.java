package com.hotelky4.projecthotel.service;

import com.hotelky4.projecthotel.dtos.CommentsRequest;
import com.hotelky4.projecthotel.dtos.CommentsResponse;
import com.hotelky4.projecthotel.entity.User;

import java.util.List;

public interface CommentService {
    void create(CommentsRequest request, User theUser);

    List<CommentsResponse> findAll();
}
