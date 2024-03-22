package com.karthikRepository.BookAttributes.Repository;

import com.karthikRepository.BookAttributes.Entity.BookAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAttrRepo extends JpaRepository<BookAttributes,Long> {
}
