package com.ganeshsiripuram.springsecurity.springsecurity;

import com.ganeshsiripuram.springsecurity.springsecurity.entities.User;
import com.ganeshsiripuram.springsecurity.springsecurity.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringsecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		User user= new User(3L,"ganesh@gmail.com","5698","ganesh");

		String token= jwtService.generateToken(user);

		System.out.print(token);

		Long id=jwtService.getUserIdFromToken(token);

		System.out.println(id);

	}

}
