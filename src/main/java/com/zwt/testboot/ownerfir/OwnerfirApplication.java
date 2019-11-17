package com.zwt.testboot.ownerfir;

import com.zwt.testboot.ownerfir.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OwnerfirApplication {

	@Autowired
	private Book book;

    @Value(value = "${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;
    @Value("${book.pinyin}")
    private String bookPinYin;


	public static void main(String[] args) {
//		SpringApplication.run(OwnerfirApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(OwnerfirApplication.class);       //修改Banner的模式为OFF
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}


	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
	String index(){
		return "Hello Spring Boot! The BookName is "+bookName+";and Book Author is "+bookAuthor+";and Book PinYin is "+bookPinYin;
	}

    @RequestMapping("/book")
	public String book() {
	    return "Hello Spring Boot! The BookName is "+book.getName()+";and Book Author is "+book.getAuthor()+";and Book price is "+book.getPrice();
	}

}
