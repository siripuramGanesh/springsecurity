package com.ganeshsiripuram.springsecurity.springsecurity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {

   private Long id;
   private String email;
   private String name;


}
