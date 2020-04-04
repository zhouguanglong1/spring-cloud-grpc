package com.zhougl.cloud.service;

import com.zhougl.cloud.grpc.helloworld.HelloReply;
import com.zhougl.cloud.grpc.helloworld.HelloRequest;
import com.zhougl.cloud.grpc.helloworld.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author zhougl
 * @version v1.0.0
 * @since 2020/4/4 18:09
 */
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase{
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply helloReply = HelloReply.newBuilder().setMessage("hello  -> " + request.getName()).build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }
}
