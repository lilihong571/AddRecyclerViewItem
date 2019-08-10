package com.llh.addrecyclerviewitem;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明控件
    private Button button;
    private RecyclerView recyclerView;
    //创建链表
    private List<Checks> checksList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定控件
        button = (Button)findViewById(R.id.btn_add);
        //设置监听事件
        button.setOnClickListener(this);
        //获取RecyclerView的实例
        recyclerView = (RecyclerView)findViewById(R.id.rv_main);
        //创建一个LinearLayoutManager对象
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //把layoutManager设置到recyclerView中
        recyclerView.setLayoutManager(layoutManager);//LayoutManager用于指定RecyclerView的布局方式，这里LinearLayoutManager是线性布局的意思
        //创建多选框实例
        initCheck();
        //创建适配器
        CheckAdapter checkAdapter = new CheckAdapter(checksList);
        //设置适配器
        recyclerView.setAdapter(checkAdapter);

    }

    private void initCheck() {
        for (int i=0; i<10;i++){
            //创建一个Checks的实例
            Checks checks = new Checks(false,"这是一个多选框，请选我");
            //将实例添加到列表中
            checksList.add(checks);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                //弹出一个框
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                //弹框布局
                final View dialogView = View.inflate(v.getContext(),R.layout.shift_dialog,null);
                builder.setTitle("添加");
                builder.setNegativeButton("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //点击确定之后的操作
                        EditText editText = dialogView.findViewById(R.id.shift_dialog_content);
                        //Toast.makeText(MainActivity.this,"你输入了文字"+editText.getText(),Toast.LENGTH_SHORT).show();
                        checksList.add(new Checks(false,editText.getText().toString()));
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setView(dialogView);
                dialog.show();
                break;
        }
    }
}
