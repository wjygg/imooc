package com.youdu.view.fragment.home;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youdu.R;
import com.youdu.constant.Constant;
import com.youdu.module.mina.MinaModel;
import com.youdu.network.mina.ConnectionManager;
import com.youdu.network.mina.MinaReceiver;
import com.youdu.util.ResponseEntityToModule;
import com.youdu.view.fragment.BaseFragment;

/**
 * @author: vision
 * @function:
 * @date: 16/7/14
 */
public class MessageFragment extends BaseFragment {

    /**
     * UI
     */
    private View mContentView;
    private TextView mMessageView;
    private TextView mZanView;
    private TextView mImoocView;
    private TextView mTipView;

    /**
     * 负责处理接收到的mina消息
     */
    private MinaReceiver mReceiver;

    public MessageFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mReceiver = new MinaReceiver(new MinaReceiver.MinaListener() {
            @Override
            public void doHandleMessage(Intent intent) {
                handleMessage(intent);
            }
        });
        registerBroadcast();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_message_layout, null, false);
        initView();
        return mContentView;
    }

    private void initView() {
        mMessageView = (TextView) mContentView.findViewById(R.id.tip_message_view);
        mImoocView = (TextView) mContentView.findViewById(R.id.tip_imooc_view);
        mZanView = (TextView) mContentView.findViewById(R.id.zan_message_info_view);
        mTipView = (TextView) mContentView.findViewById(R.id.tip_view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterBroadcast();
    }

    private void registerBroadcast() {

        IntentFilter filter =
                new IntentFilter(ConnectionManager.BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(mContext)
                .registerReceiver(mReceiver, filter);
    }

    private void unregisterBroadcast() {
        LocalBroadcastManager.getInstance(mContext)
                .unregisterReceiver(mReceiver);
    }

    //真正的处理mina消息
    private void handleMessage(Intent intent) {

        String message = intent.getStringExtra(ConnectionManager.MESSAGE);
        Log.e("MessageFragment", message);
        MinaModel model = (MinaModel) ResponseEntityToModule.
                parseJsonToModule(message, MinaModel.class);
        if (model != null) {
            switch (model.data.key) {
                case Constant.IMOOC_MSG: // 表明收到的是imooc的消息
                    if (model.data.values != null && model.data.values.size() > 0) {
                        mTipView.setVisibility(View.VISIBLE);
                        mTipView.setText(String.valueOf(model.data.values.size()));
                    } else {
                        mTipView.setVisibility(View.GONE);
                    }
                    break;
                // 其它消息类似处理
            }
        }
    }
}
