package com.example.gRPCClient;

import com.example.gRPCServer.HelloRequest;
import com.example.gRPCServer.HelloResponse;
import com.example.gRPCServer.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GreeterClient extends HelloServiceGrpc.HelloServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(GreeterClient.class);

    @GrpcClient("grpc-server")
    private HelloServiceGrpc.HelloServiceBlockingStub helloWorldServiceStub;

    public void sayHello() {


        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setTitle("Baeldung")
                .setDescription("gRPC")
                .setUrl("www")
                .build());

        channel.shutdown();


//        HelloRequest helloWorldRequest = HelloRequest.newBuilder().setTitle("sender")
//                .setDescription("Description").setUrl("www.google.es").build();
//        HelloResponse helloWorldResponse = helloWorldServiceStub.hello(helloWorldRequest);
//        logger.info(String.format("Server sent a response: %1s", helloWorldResponse.getGreeting()));
    }

//    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
//            .usePlaintext()
//            .build();
//
//    HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
//
//    HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
//            .setTitle("Testing")
//            .setDescription("This is a test")
//            .setUrl("www.test.com")
//            .build());
//
//    System.out.println("La respuesta es: "+ helloResponse);
//
//    channel.shutdown();

}
