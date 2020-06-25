package com.test.firstapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import java.io.IOException;

/**
 * 音乐服务
 * extends Service  继承系统的服务
 * 四大组件都需要注册到AndroidManifest
 */
public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    //跨进程通讯
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Service被创建后被调用
     */
    @Override
    public void onCreate() {//a/1.mp3  2.mp3......
        //数据源 --- 1.播放网络音乐 2.播放app内部的音乐  3.播放手机文件目录中的音乐(音乐播放器)
//        播放本地资源的音乐
//        mediaPlayer = MediaPlayer.create(this, R.raw.snh);
//        播放文件系统的音乐
//        File file = new File(Environment.getExternalStorageDirectory(), "zshyn.mp3");
//        mediaPlayer = new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource(file.getAbsolutePath());//通过获取绝对路径来设置播放源头
//        } catch (IOException e) {
//            e.printStackTrace();

//        播放网络中的音乐
        //1) google自带播放器MediaPlayer
        mediaPlayer = new MediaPlayer();
        Uri uri = Uri.parse("http://wp.zp68.com/sub/filestores/2020/02/09/79d439cdbef440bddcc53558535c46e0.mp3");
        //uri  路径映射的地址
        try {
            //2）setDataSource 设置数据源  context上下文(操作环境)  Service   Activity   Application(应用)
            mediaPlayer.setDataSource(this, uri);//或者直接mediaPlayer.setDataSource("http://www.nxl123.cn/snh.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Service被开始后调用
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //3）准备播放器
        mediaPlayer.prepareAsync();//准备资源，可能阻塞主线程，所以要在子线程调用。在这里使用prepareAsync函数就可以了
        //防止资源还没有准备完毕就播放音乐，所以要设置准备资源监听器
        //表示当准备资源完成后，调用监听器中onPrepare方法
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //回调onPrepared  播放器准备好
                mediaPlayer.start();//开始播放音乐
            }
        });
        //MediaPlayer实例是由create方法创建的，那么第一次启动播放前不需要再调用prepare()了，因为create方法里已经调用过了。
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * Service被停止后调用
     */
    @Override
    public void onDestroy() {
        mediaPlayer.stop();//停止播放
        mediaPlayer.release();//释放准备的资源，如果还需要用到此对象则可先不销毁
    }
}
