package com.example.database_changes.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class Internet {

	public static boolean checkConnection(Context c) {
		ConnectivityManager mConnectivityManager = (ConnectivityManager) c
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		TelephonyManager telephonyManager = (TelephonyManager) c
				.getSystemService(Context.TELEPHONY_SERVICE);

		if (mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.isConnected()
				|| telephonyManager.getDataState() == TelephonyManager.DATA_CONNECTED)
			return true;
		else
			return false;

	}

	public static void createToast(String text, Context ctx) {
		Context context = ctx;

		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	public static void pulldb() {
		try {
			copy(new File(
					"/data/data/com.example.database_changes/databases/database_changes.db"),
					new File(Environment.getExternalStorageDirectory()
							.toString()
							+ File.separator
							+ "Akash"
							+ File.separator + "database_changes.db"));
		} catch (IOException es) {
			es.printStackTrace();
		}
	}

	static void copy(File src, File dst) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);

		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	public static void CreateDirectory(String directoryPath) {
		File directory = new File(directoryPath);
		if (!(directory.exists())) {
			directory.mkdirs();
		}
	}
}