package com.zhusr.learnbasequickadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhusr.learnbasequickadapter.adapter.MainAdapter;
import com.zhusr.learnbasequickadapter.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recy)
    RecyclerView recyclerView;

    private List<String> mData = new ArrayList<>();

    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();
    }

    private void initData() {
        mData.add("头部Header + 尾部Footer");
        mData.add("动画展示");
        mData.add("上拉加载下拉刷新");
        mData.add("空布局");
        mData.add("多布局-聊天");
        mData.add("字母导航");
        mData.add("单选");
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(R.layout.rv_item, mData);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(MainActivity.this, HeaderAndFooterActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, AnimationActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, PullRefreshActivity.class);
                        break;
                    case 3:
                        intent.setClass(MainActivity.this, EmptyActivity.class);
                        break;
                    case 4:
                        intent.setClass(MainActivity.this, MultiActivity.class);
                        break;
                    case 5:
                        intent.setClass(MainActivity.this, NavigationActivity.class);
                        break;
                    case 6:
                        intent.setClass(MainActivity.this, SelectActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }
}
