package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) throws IOException{
		
		//서버소켓 생성
		ServerSocket serverSocket= new ServerSocket();
		
		//바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.79",10001));
		
		SocketAddress aaa = new InetSocketAddress("192.168.0.79",10001);
		
		
		//서버시작
		System.out.println("<서버 시작>");
		System.out.println("===============================================");
		
		while(true) {
			
			System.out.println("[연결을 기다리고 있습니다.]");
			
			//클라이언트가 접속을 하면 accept()가 실행됨
			Socket socket = serverSocket.accept();
			
			//출장 thread.start();
			
			Thread thread = new ServerThread(socket);
			thread.start();
			
		}
		
		/*
		//닫기
		sc.close();
		bw.close();
		br.close();
		socket.close();
		serverSocket.close();
		*/
	}

}
