package com.anfly.randomname;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private ConstraintLayout cl;
    private int isStart;
    private Handler mHandler;
    private Timer mTimer = new Timer();
    private String[] xiaoshixun1908a = {
            "01-许翔-一组一号",
            "02-田宇-一组二号",
            "03-任永庆-一组三号",
            "04-李泽璇-一组四号",
            "05-赵仟-一组五号",
            "06-孙慧雯-一组六号",
            "07-李岩岩-二组一号",
            "08-吴洪潇-二组二号",
            "09-相春梅-二组三号",
            "00-袁包根-二组四号",
            "11-那日苏-二组五号",
            "12-高晓倩-三组一号",
            "13-陈鸿志-三组二号",
            "14-祖瑞衡-三组三号",
            "15-康正瑜-三组四号",
            "06-杨钰-三组五号",
            "07-徐雨欣-四组一号",
            "08-韩孝-四组二号",
            "09-朝乐门-四组三号",
            "20-孙佳乐-四组四号",
            "21-杜龙飞-四组五号",
            "22-王兴达-五组一号",
            "23-王东升-五组二号",
            "24-闫古月-五组三号",
            "25-郜明杰-五组四号",
            "26-赵立新-五组五号",
            "27-张天一-六组一号",
            "28-高宇亨-六组二号",
            "29-王天祥-六组三号",
            "30-杨明亮-六组四号",
            "31-张旭-六组五号",
            "32-刘海全-六组六号"
    };
    private String[] arr = {
            "01-许翔-一组一号",
            "02-王辉-一组二号",
            "03-任永庆-一组三号",
            "04-刘科欣-一组四号",
            "05-王梓煜-一组五号",
            "06-马晓华-一组六号",
            "07-尚霜霜-二组一号",
            "08-田宇-二组二号",
            "09-范亚军-二组三号",
            "10-李泽璇-二组四号",
            "11-赵仟-二组五号",
            "12-孙慧雯-二组六号",
            "13-李岩岩-三组一号",
            "14-王维-三组二号",
            "15-刘占月-三组三号",
            "16-周磊楠-三组四号",
            "17-车力木格-三组五号",
            "18-袁慧-三组六号",
            "19-康嘉胜-三组七号",
            "20-徐雨欣-四组一号",
            "21-陈鸿志-四组二号",
            "22-牛欣月-四组三号",
            "23-刁心俊-四组四号",
            "24-韩孝-四组五号",
            "25-朝乐门-四组六号",
            "26-王兴达-五组一号",
            "27-刘江峰-五组二号",
            "28-王志斌-五组三号",
            "29-邓德建-五组四号",
            "30-贺进进-五组五号",
            "31-吴洪潇-五组六号",
            "32-赵振-五组七号",
            "33-高晓倩-六组一号",
            "34-翟晨晓-六组二号",
            "35-文勇奇-六组三号",
            "36-黄晨袁-六组四号",
            "37-刘健-六组五号",
            "38-祖瑞衡-六组六号",
            "39-黄雯泽-六组七号"};
    private String[] arr1 = {"A1姜威(无麦)",
            "A2刘占月",
            "A3陈宏志",
            "A4牛欣月",
            "A5徐雨欣",
            "A6王振敏",
            "A7王兴达",
            "A8刘增乙(无麦)",
            "A9刘江峰(无麦)",
            "A10袁文兵",
            "A11黎东东",
            "A12王志斌",
            "A13任永庆",
            "A14王辉",
            "A15许翔",
            "A16马帅毅(无麦)",
            "A17张建龙",
            "A18李泽璇(无麦)",
            "A19赵仟",
            "A20孙慧文",
            "A21李旭",
            "A22刘健(无麦)",
            "A23尚霜霜",
            "A24田宇",
            "A25范亚军",
            "A26郝旭东(无麦)",
            "A27朱茂源",
            "A28杨仕龙",
            "A29高晓倩",
            "A30曾祥瑞",
            "A31戚志强",
            "A32张蒙",
            "A33文勇齐",
            "A34卢治东",
            "A35翟晨晓(无麦)",
            "A36宋亚辉",
            "A37李岩岩",
            "A38刘子瑞",
            "A39张文涛(无麦)",
            "A40邱成彬",
            "B1张旭(无麦)",
            "B2李宇航(无麦)",
            "B3曹军英",
            "B4郑雄",
            "B5段宇昕",
            "B6崔华",
            "B7丁向东(无麦)",
            "B8王炳惠",
            "B9姚咪咪",
            "B10王小龙",
            "B11李晨晨",
            "B12李欣",
            "B13张丰成",
            "B14薛婷婷",
            "B15陈志林(无麦)",
            "B16彭张斌",
            "B17纪佳慧",
            "B18李冬瑞",
            "B19李大山(无麦)",
            "B20何曦哲",
            "B21李靖保",
            "B22刘恩侠",
            "B23郝嘉誉",
            "B24侯春雨",
            "B25刘鑫",
            "B26张建新",
            "B27尹俊毅(无麦)",
            "B28吕思迁",
            "B29李富凯",
            "B30王岳",
            "B31徐延笛",
            "B32王一帆(无麦)",
            "B33尚晋栋",
            "B34李航洲",
            "B35李震",
            "B36赵福全",
            "B37孙宏炜",
            "B38牟洪磊(无麦)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        cl = (ConstraintLayout) findViewById(R.id.cl);
        mHandler = new Handler(new InnerCallback());
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart == 0) {
                    start();
                } else {
                    stop();
                }
            }
        });
    }

    private void start() {
        isStart = 1;
        mTimer.schedule(new TimerTask() {
            int max = xiaoshixun1908a.length;
            int min = 0;

            @Override
            public void run() {
                if (isStart == 1) {
                    int num = (int) Math.round(Math.random() * (max - min) + min);
                    if (num >= max) {
                        num--;
                    }
                    //通过Message.obtain构造一个message，并通过Handler发送
                    mHandler.sendMessage(Message.obtain(mHandler, num));
                }
            }
        }, 0, 50);
    }

    private void stop() {
        isStart = 0;
    }

    private class InnerCallback implements Handler.Callback {
        @Override
        public boolean handleMessage(Message msg) {
            //这里接收到sendMessage发送过来的消息，当前线程为UI线程
            int index = msg.what;
            tv_name.setText(xiaoshixun1908a[index]);
            return true;
        }
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        mTimer.cancel();
        super.onDestroy();
    }
}
