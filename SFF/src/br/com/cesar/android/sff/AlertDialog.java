package br.com.cesar.android.sff;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class AlertDialog extends DialogFragment{
	
	private String title;
	private String message;
	private Context context;
	private OnClickListener onClickListener;
	
	
	public AlertDialog(String title, String message, Context context,OnClickListener onClickListener) {
		super();
		this.title = title;
		this.message = message;
		this.context = context;
		this.onClickListener = onClickListener;
	}
	


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(context).create();
		dialog.setTitle(this.title);
		dialog.setCanceledOnTouchOutside(false);
		dialog.setMessage(this.message);
		
		dialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK", this.onClickListener);
		
		return dialog;
	}
	
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
