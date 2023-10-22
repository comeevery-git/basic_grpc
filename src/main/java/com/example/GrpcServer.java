package com.example;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
				.forPort(8081) // server port
				.addService(new BasicServiceImpl()) // add service
				.build();

		System.out.println("Starting server, Listening on port 8081");

		server.start();
		server.awaitTermination();
	}
}
