package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist,String> {
}
