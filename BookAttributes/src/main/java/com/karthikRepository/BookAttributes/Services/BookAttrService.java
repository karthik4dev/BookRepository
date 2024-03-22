package com.karthikRepository.BookAttributes.Services;

import com.karthikRepository.BookAttributes.DTOs.BookAttrDTO;
import com.karthikRepository.BookAttributes.Entity.BookAttributes;
import com.karthikRepository.BookAttributes.Exceptions.BookAttributesNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface BookAttrService {
    BookAttrDTO getBookAttributes(long id) throws BookAttributesNotFound;


    BookAttrDTO createBookAttributes(BookAttrDTO bookAttrDTO);

    BookAttrDTO updateBookAttributes(BookAttrDTO bookAttrDTO) throws BookAttributesNotFound;

    HttpStatus deleteBookAttributesByID(long id) throws BookAttributesNotFound;
}
