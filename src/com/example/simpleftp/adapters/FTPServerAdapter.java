package com.example.simpleftp.adapters;

import java.util.ArrayList;

import com.example.simpleftp.R;
import com.example.simpleftp.entities.FTPServer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FTPServerAdapter extends BaseAdapter{
	
	private ArrayList<FTPServer> ftpServers;
	private Context context;
	
	public FTPServerAdapter(ArrayList<FTPServer> ftpServers, Context context){
		this.ftpServers = ftpServers;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.ftpServers.size();
	}

	@Override
	public Object getItem(int index) {
		// TODO Auto-generated method stub
		return this.ftpServers.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	static class ViewHolder{
		ImageView imageViewListItemFTPServers;
		TextView textViewListItemFTPServers;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ViewHolder holder;
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		if(convertView == null){
			
			convertView = layoutInflater.inflate(R.layout.list_item_ftpservers, null);
			
			holder = new ViewHolder(); 
			holder.imageViewListItemFTPServers = (ImageView)convertView.findViewById(R.id.imageViewListItemFTPServers);
			holder.textViewListItemFTPServers = (TextView)convertView.findViewById(R.id.textViewListItemFTPServers);
 
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		FTPServer ftpServer = (FTPServer) getItem(position);
		holder.imageViewListItemFTPServers.setImageResource(R.drawable.ic_ftpserver);
		holder.textViewListItemFTPServers.setText(ftpServer.getHost());
		 
		return convertView;
		
	}
	
	
}
