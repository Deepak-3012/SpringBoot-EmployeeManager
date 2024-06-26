package com.SpringBoot_Projects.Employee.Directory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
