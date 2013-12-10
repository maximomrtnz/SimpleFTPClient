package com.example.simpleftp.ftpcommands;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.net.ftp.FTPFile;

import android.util.Log;

public class List extends FTPCommand{

	@Override
	public void executeCommand() throws SocketException, UnknownHostException, IOException {
		// TODO Auto-generated method stub
		super.connectToFTP();
		FTPFile[] files = ftpClient.listFiles();
		super.disconnectToFTP();
		
	}

}
