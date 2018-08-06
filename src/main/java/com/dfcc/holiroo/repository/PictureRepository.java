package com.dfcc.holiroo.repository;

import com.dfcc.holiroo.dataObject.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, String> {
}
