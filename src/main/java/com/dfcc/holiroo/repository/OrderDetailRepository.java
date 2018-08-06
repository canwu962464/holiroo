package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
