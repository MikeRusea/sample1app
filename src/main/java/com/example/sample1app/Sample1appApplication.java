package com.example.sample1app;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// import java.io.DataOutput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import java.util.Arrays;
// import org.springframework.boot.ApplicationArguments;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.ApplicationRunner;
// import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Sample1appApplication{

	// DataObject[] data = {
	// 	new DataObject("noname", "no email address", 0),
	// 	new DataObject("taro", "taro@yamada", 39),
	// 	new DataObject("hanako", "hanako@flower", 28),
	// 	new DataObject("sachiko", "sachico@happy", 17),
	// 	new DataObject("jiro", "jiro@change", 6)
	// };
	public static void main(String[] args) {
		// SpringApplication app = new SpringApplication(Sample1appApplication.class);
		// app.setBannerMode(Mode.OFF);
		// app.run(args);
		SpringApplication.run(Sample1appApplication.class, args);
	}

	// @Override
	// public void run(ApplicationArguments args){
	// 	System.out.println("---------");
	// 	System.out.println("|  this is command |");
	// 	System.out.println("---------");
	// 	// System.out.println("[" + String.join(", ",args) + "]");
	// 	System.out.println(args.getOptionNames());
	// 	System.out.println(args.getNonOptionArgs());
	// 	System.out.println(args.getSourceArgs());
	// }

	// @RequestMapping("/{num}")
	// public DataObject index(@PathVariable int num) {
	// 	int n = (num < 0 || num >= data.length) ? 0 : num;
	// 	return data[n];
	// }
	// public String index(
	// 		HttpServletRequest request,
	// 		HttpServletResponse response){
	// 	response.setContentType(MediaType.TEXT_HTML_VALUE);
	// 	String content = """
	// 		<html>
	// 			<head>
	// 			<title>Sample App<</title>
	// 			</head>
	// 			<body>
	// 			<h1>Sample App</h1>
	// 			<p>This is sample app page!</p>
	// 		</html>
	// 			""";
	// 	return content;
	// }
}

// class DataObject{
// 	private String name;
// 	private String mail;
// 	private int age;

// 	public DataObject(String name, String mail, int age){
// 		super();
// 		this.name = name;
// 		this.mail = mail;
// 		this.age = age;
// 	}

// 	public String getName(){ return name; }

// 	public void setName(String name){
// 		this.name = name;
// 	}

// 	public String getMail(){ return mail; }

// 	public void setMail(String mail){
// 		this.mail = mail;
// 	}

// 	public int getAge(){ return age; }

// 	public void setAge(int age){
// 		this.age = age;
// 	}
// }


