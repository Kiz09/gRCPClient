package com.example.gRPCClient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GreeterClient.class)
public class GRpcClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(GRpcClientApplication.class, args);
		ApplicationContext applicationContext = SpringApplication.run(GRpcClientApplication.class, args);

		GreeterClient greeterClientService = applicationContext.getBean(GreeterClient.class);
		greeterClientService.sayHello();
		greeterClientService.sayHello();


	}

}
