package com.karthikRepository.BookAttributes.Services;

import com.karthikRepository.BookAttributes.DTOs.BookAttrDTO;
import com.karthikRepository.BookAttributes.Entity.BookAttributes;
import com.karthikRepository.BookAttributes.Entity.Enums.Bind;
import com.karthikRepository.BookAttributes.Entity.Enums.BookType;
import com.karthikRepository.BookAttributes.Exceptions.BookAttributesNotFound;
import com.karthikRepository.BookAttributes.Repository.BookAttrRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class BookAttrServiceImpl implements BookAttrService{
    @Autowired
    BookAttrRepo bookAttrRepo;
    @Override
    public BookAttrDTO getBookAttributes(long id) throws BookAttributesNotFound {
        if(!bookAttrRepo.existsById(id)){
            throw new BookAttributesNotFound("Attribute for this book not found.");
        }
        BookAttributes getBookAttr=bookAttrRepo.findById(id).get();

        return BookAttrDTO.builder()
                .bookID(getBookAttr.getBookID())
                .bookPages(getBookAttr.getBookPages())
                .price(getBookAttr.getPrice())
                .bookBind(getBookAttr.getBookBind().getVALUE())
                .bookType(getBookAttr.getBookType().getValue())
                .build();
    }

    @Override
    public BookAttrDTO createBookAttributes(BookAttrDTO bookAttrDTO) {
        BookAttributes SavedBookAttributes= BookAttributes.builder()
                .bookID(bookAttrDTO.getBookID())
                .price(bookAttrDTO.getPrice())
                .bookPages(bookAttrDTO.getBookPages())
                .bookBind((bookAttrDTO.getBookBind()==1)?Bind.SOFTBIND:Bind.HARDBIND)
                .bookType((bookAttrDTO.getBookType()==1)? BookType.PHYSICAL:BookType.SOFTCOPY)
                .build();

        bookAttrRepo.saveAndFlush(SavedBookAttributes);
        return bookAttrDTO;
    }

    @Override
    public BookAttrDTO updateBookAttributes(BookAttrDTO bookAttrDTO) throws BookAttributesNotFound {
        if(!bookAttrRepo.existsById(bookAttrDTO.getBookID())){
            throw new BookAttributesNotFound("Attribute for this book not found.");
        }
        BookAttributes updateBookAttr=bookAttrRepo.findById(bookAttrDTO.getBookID()).get();
        updateBookAttr.setPrice(bookAttrDTO.getPrice());
        updateBookAttr.setBookPages(bookAttrDTO.getBookPages());
        updateBookAttr.setBookType((bookAttrDTO.getBookType()==1)?BookType.PHYSICAL:BookType.SOFTCOPY);
        updateBookAttr.setBookBind((bookAttrDTO.getBookBind()==1)?Bind.SOFTBIND:Bind.HARDBIND);

        bookAttrRepo.save(updateBookAttr);

        return bookAttrDTO;
    }

    @Override
    public HttpStatus deleteBookAttributesByID(long id) throws BookAttributesNotFound {
        if(!bookAttrRepo.existsById(id)){
            throw new BookAttributesNotFound("Attribute for this book not found.");
        }

        bookAttrRepo.deleteById(id);
        return HttpStatus.GONE;
    }
}
