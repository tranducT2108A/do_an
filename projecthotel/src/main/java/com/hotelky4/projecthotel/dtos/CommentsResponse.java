package com.hotelky4.projecthotel.dtos;

import com.hotelky4.projecthotel.entity.CommentsUser;
import com.hotelky4.projecthotel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentsResponse {
    private User user;
    private String comment;
    private int evaluationScore;

    public CommentsResponse(CommentsUser commentsUser) {
        BeanUtils.copyProperties(commentsUser, this);
    }
}
