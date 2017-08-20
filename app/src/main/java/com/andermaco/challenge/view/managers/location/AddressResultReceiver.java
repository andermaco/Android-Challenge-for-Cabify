package com.andermaco.challenge.view.managers.location;


import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;


/**
 * Created by andermaco@gmail.com on 1/08/17.
 */

public class AddressResultReceiver extends ResultReceiver {

    private Receiver mReceiver;

    public AddressResultReceiver(Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver != null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        }
    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }

    public interface Receiver {
        void onReceiveResult(int resultCode, Bundle resultData);
    }

}
