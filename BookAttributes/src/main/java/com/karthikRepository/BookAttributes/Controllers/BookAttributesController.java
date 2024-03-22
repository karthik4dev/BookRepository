package com.karthikRepository.BookAttributes.Controllers;


import com.karthikRepository.BookAttributes.DTOs.BookAttrDTO;
import com.karthikRepository.BookAttributes.Exceptions.BookAttributesNotFound;
import com.karthikRepository.BookAttributes.Services.BookAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookattr")
public class BookAttributesController {

    @Autowired
    BookAttrService bookAttrService;
    @GetMapping("/getBookAttr/{id}")
    public ResponseEntity<BookAttrDTO> getBookAttributes(@PathVariable int id ) throws BookAttributesNotFound {
        BookAttrDTO getBook=bookAttrService.getBookAttributes(id);
        return ResponseEntity.ok(getBook);
    }

    @PostMapping("/createBookAttr")
    public ResponseEntity<BookAttrDTO> createBookAttributes(@RequestBody BookAttrDTO bookAttrDTO){
        if(bookAttrDTO==null){
            throw new NullPointerException("Book Attributes are empty");
        }
        bookAttrService.createBookAttributes(bookAttrDTO);
        return (ResponseEntity<BookAttrDTO>) ResponseEntity.status(201);
    }

    @PatchMapping("/updatePatching")
    public ResponseEntity<BookAttrDTO> updateBookAtrributes(@RequestBody BookAttrDTO bookAttrDTO) throws BookAttributesNotFound {

        if(bookAttrDTO==null){
            throw new NullPointerException("Book Attributes are empty");
        }
        bookAttrService.updateBookAttributes(bookAttrDTO);
        return ResponseEntity.ok(bookAttrDTO);
    }

    @DeleteMapping("/deleteBookAttr/{id}")
    public HttpStatus deleteBookAttr(@PathVariable int id ) throws BookAttributesNotFound {
        return bookAttrService.deleteBookAttributesByID(id);
    }
}
