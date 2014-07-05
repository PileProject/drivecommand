package com.pile_drive.drivecommand.model.com.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import com.pile_drive.drivecommand.model.com.ICommunicator;

public class BluetoothCommunicator implements ICommunicator {
	
	private final static String TAG = "BluetoothCommunicator";
	private static final UUID SPP_UUID = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");
	
	private BluetoothDevice mDevice;
	private BluetoothSocket mSocket;
	private OutputStream mOutputStream;
	private InputStream mInputStream;
	
	public BluetoothCommunicator(BluetoothDevice device) {
		mDevice = device;
	}
	
	@Override
	public void open() throws IOException {
		if (mDevice == null) throw new IOException();
		
		// Orthodox method
		// This call may fail. It depends on the device.
		// Therefore, we do redundancy check with the below reflection method.
		mSocket = mDevice.createRfcommSocketToServiceRecord(SPP_UUID);
		
		try {
			mSocket.connect();
		}
		catch (IOException firstIOException) {
			Log.d(TAG, "Failed to connect by orthodox method");
			try {
				// Redundancy check
				Method method = mDevice.getClass().getMethod("createRfcommSocket", new Class[] {
						int.class
				});
				mSocket = (BluetoothSocket) method.invoke(mDevice, Integer.valueOf(1));
				mSocket.connect();
			}
			catch (IOException secondIOException) {
				// Unable to connect; close the socket and get out
				try {
					mSocket.close();
				}
				catch (IOException closeException) {
					closeException.printStackTrace();
					Log.d(TAG, "it seems unable to recover");
				}
				throw secondIOException;
			}
			catch (Exception exception) {
				exception.printStackTrace();
				Log.d(TAG, "this exception should not be occured in release version");
			}
		}
		
		mOutputStream = mSocket.getOutputStream();
		mInputStream = mSocket.getInputStream();
	}
	
	@Override
	public void close() {
		if (mSocket != null) {
			try {
				mSocket.close();
			}
			catch (IOException e) {
				Log.e(TAG, "Failed to close connection.", e);
			}
		}
		mSocket = null;
	}
	
	@Override
	public void write(byte[] request, int timeout) throws RuntimeException {
		// TODO:use timeout
		try {
			mOutputStream.write(request);
		}
		catch (IOException e) {
			Log.e(TAG, "Write failed.", e);
			throw new RuntimeException(e);
		}

		Log.d(TAG, "Write");
		for (int i = 0; i < request.length; i++) {
			Log.d(TAG, "[" + i + "]" + request[i]);
		}
	}
	
	@Override
	public byte[] read(int length, int timeout) throws RuntimeException {
		// TODO:use timeout
		byte[] buffer = new byte[length];
		int numBytes;
		try {
			numBytes = mInputStream.read(buffer);
		}
		catch (IOException e) {
			Log.e(TAG, "Read failed.", e);
			throw new RuntimeException(e);
		}
		byte[] result = new byte[numBytes];
		System.arraycopy(buffer, 0, result, 0, numBytes);
		
		Log.d(TAG, "Read ");
		for (int i = 0; i < result.length; i++) {
			Log.d(TAG, "[" + i + "]" + result[i]);
		}
		return result;
	}
}