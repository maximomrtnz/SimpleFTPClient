package com.example.simpleftp.ftpcommands;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

import org.apache.commons.net.ftp.FTPClient;

public abstract class FTPCommand extends Observable{
	
	protected FTPClient ftpClient;
	
	public void connectToFTP() throws SocketException, UnknownHostException, IOException{
		this.ftpClient =  new FTPClient(); 
		this.ftpClient.connect(InetAddress.getByName("192.168.1.37"));
		this.ftpClient.login("ftpuser", "QWERTYUIOP");	
	}
	
	public void disconnectToFTP() throws IOException{
		this.ftpClient.logout();
		this.ftpClient.disconnect();
	}
	
	public abstract void executeCommand() throws SocketException, UnknownHostException, IOException;
	
}
