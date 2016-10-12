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
		dialog.setTitle("ע�⣡");
		dialog.setMessage("���ѱ�ǿ�����ߣ��볢�����µ�¼��");
		dialog.setCancelable(false);//setcancelableΪ���öԻ��򲻿�ȡ��
		dialog.setPositiveButton("ok", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				ActivityCollector.finishall();
				Intent intent = new Intent(activity,LoginActivity.class); 
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);//�ӹ㲥���������������������intent�м���FLAG_ACTIVITY_CLEAR_TASK�ı�־
				activity.startActivity(intent);
			}
		});
		AlertDialog alertDialog=  dialog.create();//��������
		//�������type��window��ʼ����ʾ������Ӧ�ó����window֮�ϣ�Ҳ����˵���windowʼ�մ������ϲ㣬���û�ʼ�տɼ����Ի��������TYPE_SYSTEM_ALERT�������޷��ӹ㲥�������е���
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}
	
}
