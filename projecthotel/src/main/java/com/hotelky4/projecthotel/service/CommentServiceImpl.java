package com.hotelky4.projecthotel.service;

import com.hotelky4.projecthotel.dao.CommentsRepository;
import com.hotelky4.projecthotel.dtos.CommentsRequest;
import com.hotelky4.projecthotel.dtos.CommentsResponse;
import com.hotelky4.projecthotel.entity.CommentsUser;
import com.hotelky4.projecthotel.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentsRepository repository;

    @Override
    public void create(CommentsRequest request, User theUser) {
        CommentsUser commentsUser = new CommentsUser(request);
        repository.save(commentsUser);
    }

    @Override
    public List<CommentsResponse> findAll() {
        return repository.findAll().stream().map(CommentsResponse::new).collect(Collectors.toList());
    }
}
