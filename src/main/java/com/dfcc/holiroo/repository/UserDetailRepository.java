package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, String> {

    Optional<UserDetail> findByUserEmail(String userEmail);
}
