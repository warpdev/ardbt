package com.warpdev.ardbt;

import android.app.*;
import android.bluetooth.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.inputmethod.*;
import java.io.*;
import java.util.*;
import android.widget.*;
import com.warpdev.ardbt.*;

public class MainActivity extends Activity
{

	private static final int REQUEST_CONNECT_DEVICE = 1;
	private BluetoothAdapter mBluetoothAdapter=null;
	public static String LOG_TAG="ArduinoBT";
	private static final boolean DEBUG = true;
	private static InputMethodManager mInputManager;
	

	public static final int MESSAGE_DEVICE_NAME = 0;

	public static String DEVICE_NAME;

	public static final int MESSAGE_STATE_CHANGE = 0;

	public static final int MESSAGE_TOAST = 0;

	public static String TOAST;

	public static final int MESSAGE_WRITE = 0;

	public static final boolean LOG_CHARACTERS_FLAG = false;

	public static final boolean LOG_UNKNOWN_ESCAPE_SEQUENCES = false;

	public static final int WHITE = 0;

	public static final int BLACK = 0;

	private static final int REQUEST_ENABLE_BT = 2;

	//public static String LOG_TAG;

	public void toggleKeyboard()
	{
		// TODO: Implement this method
		mInputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
	} 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
		if(mBluetoothAdapter==null)
		{
			Toast.makeText(this,"BlueTooth not Available",Toast.LENGTH_SHORT).show();
			finish();
			
		}
		if(!mBluetoothAdapter.isEnabled())
		{
			Intent enableIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
		}
		else
		{
		}
    }
	
	public void ckct(View v)
	{
		Intent serverIntent=new Intent(this,DeviceListActivity.class);
		
		startActivityForResult(serverIntent,REQUEST_CONNECT_DEVICE);
	}
}

