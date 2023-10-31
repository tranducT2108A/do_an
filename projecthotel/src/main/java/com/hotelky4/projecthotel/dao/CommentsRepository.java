package com.hotelky4.projecthotel.dao;

import com.hotelky4.projecthotel.entity.CommentsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsUser,Integer> {

}
