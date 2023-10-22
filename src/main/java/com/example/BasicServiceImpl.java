package com.example;

import io.grpc.stub.StreamObserver;

public class BasicServiceImpl extends BasicServiceGrpc.BasicServiceImplBase {
	@Override
	public void hello(BasicRequest basicRequest,
					  StreamObserver<BasicResponse> responseObserver) {

		String greeting = new StringBuilder()
				.append("안녕하세요. ")
				.append("저는 ")
				.append(basicRequest.getSecondName())
				.append(" ")
				.append(basicRequest.getFirstName())
				.append("입니다.")
				.toString();

		BasicResponse response = BasicResponse.newBuilder()
			.setGreeting(greeting) // obj builder
			.build();

		responseObserver.onNext(response); // obj to client
		responseObserver.onCompleted(); // close stream

  }

}
