package com.hotelky4.projecthotel.entity;

import com.hotelky4.projecthotel.dtos.CommentsRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
@Getter
@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
public class CommentsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name ="comment")
    private String comment;

    @Column(name = "evaluationScore")
    private int evaluationScore;

    public CommentsUser(CommentsRequest request) {
        BeanUtils.copyProperties(request, this);
    }
}
