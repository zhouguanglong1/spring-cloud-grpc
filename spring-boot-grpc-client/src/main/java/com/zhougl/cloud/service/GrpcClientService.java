package com.zhougl.cloud.service;

import com.zhougl.cloud.grpc.helloworld.HelloReply;
import com.zhougl.cloud.grpc.helloworld.HelloRequest;
import com.zhougl.cloud.grpc.helloworld.SimpleGrpc;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author zhougl
 * @version v1.0.0
 * @since 2020/4/4 18:15
 */
@Service
public class GrpcClientService {

    @GrpcClient("spring-boot-grpc-server")
    private Channel serverChannel;
    // 后面这种方式会报错
//    private SimpleGrpc.SimpleBlockingStub simpleBlockingStub;

    public String sendMessage(String name) {
//        try {
//            HelloReply reply = simpleBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
//            return reply.getMessage();
//        } catch (final StatusRuntimeException e) {
//            return "FAILED with " + e.getStatus().getCode();
//        }
        SimpleGrpc.SimpleBlockingStub simpleBlockingStub = SimpleGrpc.newBlockingStub(serverChannel);
        HelloReply helloReply = simpleBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return helloReply.getMessage();

    }
}
