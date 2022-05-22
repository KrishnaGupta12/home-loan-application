package com.lti.homeloanapplication.customexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -2581975292273282583L;
    String errorMessage;
    String errorCode;
}
