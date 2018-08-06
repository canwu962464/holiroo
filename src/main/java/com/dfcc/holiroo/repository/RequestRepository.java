package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,String> {
}
