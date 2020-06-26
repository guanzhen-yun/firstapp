package com.test.firstapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:关震
 * Date:2020/6/26 9:01
 * Description:AsyncTaskActivity 异步任务
 **/
public class AsyncTaskActivity extends Activity {
    @BindView(R.id.btn_load)
    Button mBtnLoad;
    @BindView(R.id.tv_tip)
    TextView mTvTip;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;

    // 线程变量
    private MyTask mTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_load, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_load:
                break;
            case R.id.btn_cancel:
                break;
        }
    }

    /**
     * 步骤1：创建AsyncTask子类
     * 注：
     * a. 继承AsyncTask类
     * b. 为3个泛型参数指定类型；若不使用，可用java.lang.Void类型代替
     * 此处指定为：输入参数 = String类型、执行进度 = Integer类型、执行结果 = String类型
     * c. 根据需求，在AsyncTask子类内实现核心方法
     */
    private class MyTask extends AsyncTask<String, Integer, String> {

        // 方法1：onPreExecute（）
        // 作用：执行 线程任务前的操作
        @Override
        protected void onPreExecute() {
            text.setText("加载中");
            // 执行前显示提示
        }


        // 方法2：doInBackground（）
        // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
        // 此处通过计算从而模拟“加载进度”的情况
        @Override
        protected String doInBackground(String... params) {

            try {
                int count = 0;
                int length = 1;
                while (count < 99) {

                    count += length;
                    // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
                    publishProgress(count);
                    // 模拟耗时任务
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        // 方法3：onProgressUpdate（）
        // 作用：在主线程 显示线程任务执行的进度
        @Override
        protected void onProgressUpdate(Integer... progresses) {

            progressBar.setProgress(progresses[0]);
            text.setText("loading..." + progresses[0] + "%");

        }

        // 方法4：onPostExecute（）
        // 作用：接收线程任务执行结果、将执行结果显示到UI组件
        @Override
        protected void onPostExecute(String result) {
            // 执行完毕后，则更新UI
            text.setText("加载完毕");
        }

        // 方法5：onCancelled()
        // 作用：将异步任务设置为：取消状态
        @Override
        protected void onCancelled() {

            text.setText("已取消");
            progressBar.setProgress(0);

        }
    }
}
