package com.hotelky4.projecthotel.controller;

import com.hotelky4.projecthotel.dtos.CommentsRequest;
import com.hotelky4.projecthotel.dtos.CommentsResponse;
import com.hotelky4.projecthotel.entity.User;
import com.hotelky4.projecthotel.service.CommentService;
import com.hotelky4.projecthotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/comment")
public class CommentUserController {
    private UserService userService;
    private final CommentService commentService;

    @GetMapping
    public String showFormForAdd(Model model){
        List<CommentsResponse> commentsResponses = commentService.findAll();
        model.addAttribute("comments",commentsResponses);
        return "/admin/comment/rooms";
    }


    @PostMapping("/create")
    public String createComment( @ModelAttribute("requestComment") CommentsRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Lấy thông tin về người dùng
            String username = userDetails.getUsername();
            User theUser = userService.findByUsername(username);
            commentService.create(request, theUser);


            return "redirect:/admin/comment/rooms";
        } else {
            return "fancy-login.html";
        }
    }
}
