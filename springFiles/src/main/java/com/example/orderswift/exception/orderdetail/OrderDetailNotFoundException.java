<<<<<<<< HEAD:springFiles/src/main/java/com/example/orderswift/exception/orderDetail/OrderDetailNotFoundException.java
package com.example.orderswift.exception.orderDetail;
========
package com.example.orderswift.exception.orderdetail;
>>>>>>>> e8d4fe6 (Adding the services, controllers of category, product category y user transaction and fixing an error caused by a double instance of the class OrderNotFound that wasnt declared):springFiles/src/main/java/com/example/orderswift/exception/orderdetail/OrderDetailNotFoundException.java

public class OrderDetailNotFoundException extends RuntimeException{
    public OrderDetailNotFoundException(Integer id_orderDetail) {super("Could not found the order detail with the id " + id_orderDetail);}
}
