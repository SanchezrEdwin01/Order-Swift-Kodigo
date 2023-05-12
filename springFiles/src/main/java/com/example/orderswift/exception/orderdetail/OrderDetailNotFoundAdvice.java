<<<<<<<< HEAD:springFiles/src/main/java/com/example/orderswift/exception/orderDetail/OrderDetailNotFoundAdvice.java
package com.example.orderswift.exception.orderDetail;
========
package com.example.orderswift.exception.orderdetail;
>>>>>>>> e8d4fe6 (Adding the services, controllers of category, product category y user transaction and fixing an error caused by a double instance of the class OrderNotFound that wasnt declared):springFiles/src/main/java/com/example/orderswift/exception/orderdetail/OrderDetailNotFoundAdvice.java

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class OrderDetailNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(OrderDetailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
<<<<<<<< HEAD:springFiles/src/main/java/com/example/orderswift/exception/orderDetail/OrderDetailNotFoundAdvice.java
    public Map<String, String> excetionHandler(OrderDetailNotFoundException exception){
========
    public Map<String, String> excetionHandler(RuntimeException exception){
>>>>>>>> e8d4fe6 (Adding the services, controllers of category, product category y user transaction and fixing an error caused by a double instance of the class OrderNotFound that wasnt declared):springFiles/src/main/java/com/example/orderswift/exception/orderdetail/OrderDetailNotFoundAdvice.java
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error message", exception.getMessage());
        return errorMap;
    }
}
