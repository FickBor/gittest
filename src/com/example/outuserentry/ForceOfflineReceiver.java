package com.example.outuserentry;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive( Context context, Intent intent) {
		// TODO Auto-generated method stub
		final  Activity activity =ActivityCollector.getActivityy();
		AlertDialog.Builder dialog= new AlertDialog.Builder(context);
		dialog.setTitle("注意！");
		dialog.setMessage("你已被强制下线，请尝试重新登录！");
		dialog.setCancelable(false);//setcancelable为设置对话框不可取消
		dialog.setPositiveButton("ok", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				ActivityCollector.finishall();
				Intent intent = new Intent(activity,LoginActivity.class); 
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);//从广播接收器中启动活动，必须在intent中加入FLAG_ACTIVITY_CLEAR_TASK的标志
				activity.startActivity(intent);
			}
		});
		AlertDialog alertDialog=  dialog.create();//设置类型
		//加了这个type的window将始终显示在其他应用程序的window之上，也就是说这个window始终处于最上层，对用户始终可见，对话框的类型TYPE_SYSTEM_ALERT，否则无法从广播接收器中弹出
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}
	
}
