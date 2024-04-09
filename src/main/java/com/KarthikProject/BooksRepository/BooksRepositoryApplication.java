package com.KarthikProject.BooksRepository;
//
//import com.karthikRepository.BookAttributes.DTOs.BookAttrDTO;
//import com.karthikRepository.BookAttributes.Exceptions.BookAttributesNotFound;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(info = @Info(title = "Book Application",
					version = "1.0"
,description = "This application is used as Book Repository",
contact = @Contact(name = "Karthik P N",email = "karthikpnrao.97@gmail.com")))
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableCaching
public class BooksRepositoryApplication {
//	@FeignClient(path = "${BookAttributes.url}",value="BOOK-ATTRIBUTES")
//	public interface IBookAttr{
//		@GetMapping("/getBookAttr/{id}")
//		public ResponseEntity<BookAttrDTO> getBookAttributes(@PathVariable int id ) throws BookAttributesNotFound;
//
//		@PostMapping("/createBookAttr")
//		public ResponseEntity<BookAttrDTO> createBookAttributes(@RequestBody BookAttrDTO bookAttrDTO);
//
//		@PatchMapping("/updatePatching")
//		public ResponseEntity<BookAttrDTO> updateBookAtrributes(@RequestBody BookAttrDTO bookAttrDTO) throws BookAttributesNotFound ;
//
//		@DeleteMapping("/deleteBookAttr/{id}")
//		public HttpStatus deleteBookAttr(@PathVariable int id ) throws BookAttributesNotFound;
//
//		}
	public static void main(String[] args) {
		SpringApplication.run(BooksRepositoryApplication.class, args);
	}





}
