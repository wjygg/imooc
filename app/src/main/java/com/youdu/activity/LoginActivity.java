package com.youdu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.youdu.R;
import com.youdu.activity.base.BaseActivity;
import com.youdu.jpush.PushMessageActivity;
import com.youdu.manager.DialogManager;
import com.youdu.manager.UserManager;
import com.youdu.module.PushMessage;
import com.youdu.module.user.User;
import com.youdu.network.http.RequestCenter;
import com.youdu.network.mina.MinaService;
import com.youdu.okhttp.listener.DisposeDataListener;
import com.youdu.view.associatemail.MailBoxAssociateTokenizer;
import com.youdu.view.associatemail.MailBoxAssociateView;


public class LoginActivity extends BaseActivity implements View.OnClickListener {

    //自定义登陆广播Action
    public static final String LOGIN_ACTION = "com.imooc.LOGIN_ACTION";
    /**
     * UI
     */
    private MailBoxAssociateView mUserNameAssociateView;
    private EditText mPasswordView;
    private TextView mLoginView;

    /**
     * data
     */
    private PushMessage mPushMessage; // 推送过来的消息
    private boolean fromPush; // 是否从推送到此页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        initData();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.hasExtra("pushMessage")) {
            mPushMessage = (PushMessage) intent.getSerializableExtra("pushMessage");
        }
        fromPush = intent.getBooleanExtra("fromPush", false);
    }

    private void initView() {

        mUserNameAssociateView = (MailBoxAssociateView) findViewById(R.id.associate_email_input);
        mPasswordView = (EditText) findViewById(R.id.login_input_password);
        mLoginView = (TextView) findViewById(R.id.login_button);
        mLoginView.setOnClickListener(this);

        mUserNameAssociateView = (MailBoxAssociateView) findViewById(R.id.associate_email_input);
        String[] recommendMailBox = getResources().getStringArray(R.array.recommend_mailbox);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_associate_mail_list,
            R.id.tv_recommend_mail, recommendMailBox);
        mUserNameAssociateView.setAdapter(adapter);
        mUserNameAssociateView.setTokenizer(new MailBoxAssociateTokenizer());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login_button:
                login();
                break;
        }
    }

    //发送登陆请求
    private void login() {

        String userName = mUserNameAssociateView.getText().toString().trim();
        String password = mPasswordView.getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            return;
        }

        if (TextUtils.isEmpty(password)) {
            return;
        }

        DialogManager.getInstnce().showProgressDialog(this);
        RequestCenter.login(userName, password, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                DialogManager.getInstnce().dismissProgressDialog();
                User user = (User) responseObj;
                UserManager.getInstance().setUser(user);//保存当前用户单例对象
                connectToSever();
                sendLoginBroadcast();

                if (fromPush) {
                    Intent intent = new Intent(LoginActivity.this, PushMessageActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("pushMessage", mPushMessage);
                    startActivity(intent);
                }
                finish();//销毁当前登陆页面
            }

            @Override
            public void onFailure(Object reasonObj) {
                DialogManager.getInstnce().dismissProgressDialog();
            }
        });
    }

    //启动长连接
    private void connectToSever() {
        startService(new Intent(LoginActivity.this, MinaService.class));
    }

    //向整个应用发送登陆广播事件
    private void sendLoginBroadcast() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(LOGIN_ACTION));
    }
}
