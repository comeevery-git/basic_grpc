package com.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
	public static void main(String[] args) {
		// channel: connection, connection pool, loadBalancing 등을 추상화
		String target = "localhost:8081";
		ManagedChannel channel = ManagedChannelBuilder
				.forTarget(target)
				// .forAddress("localhost", 8081)
				.usePlaintext()
				.build();


		// 원격지 프로시저 hello() 를 호출하기 위한 stub 생성
		// stub = gRPC client 와 서버가 소통하는 방법
		// * blockingStub
		BasicServiceGrpc.BasicServiceBlockingStub stub =
				BasicServiceGrpc.newBlockingStub(channel);

		BasicRequest request = BasicRequest.newBuilder()
				.setFirstName("옹뇽뇽")
				.setSecondName("깅댱댱")
				.build();
		BasicResponse response = stub.hello(request);

		System.out.println(response.getGreeting());

		channel.shutdown();
	}
}
