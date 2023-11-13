package com.example.springbackend;

import com.example.springbackend.model.Admin;
import com.example.springbackend.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBackendApplication  {

    public static void main(String[] args) {

        SpringApplication.run(SpringBackendApplication.class, args);


    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
