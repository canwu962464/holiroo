package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, String> {

    //List<User> findByUserAdmin(int userAdmin);
}
