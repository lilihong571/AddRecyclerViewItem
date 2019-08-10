package com.llh.addrecyclerviewitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * 项目名:    AddRecyclerViewItem
 * 包名:      com.llh.addrecyclerviewitem
 * 文件名:    CheckAdapter
 * 创建者:    LLH
 * 创建时间:  2019/8/6 10:30
 * 描述:      TODO
 */
                                //指定泛型为内部类
public class CheckAdapter extends RecyclerView.Adapter<CheckAdapter.MyViewHolder> {
    //声明一个数组
    private List<Checks> checksList;
    //构造函数
    public CheckAdapter(List<Checks> checksList){
        this.checksList = checksList;
    }
    //定义一个内部类,用来声明和绑定   该适配器绑定的布局的控件
    static class MyViewHolder extends RecyclerView.ViewHolder{
        //一个多选框
        CheckBox checkBox;
        //一个文本框
        TextView textView;
        //构造函数中赋值：参数：该适配器绑定的布局
        public MyViewHolder(View view){
            super(view);
            checkBox = view.findViewById(R.id.cb_check);
            textView = view.findViewById(R.id.tv_text);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //适配器绑定哪个布局
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_check,viewGroup,false);
        //用于创建MyViewHolder的实例
        MyViewHolder myViewHolder = new MyViewHolder(view);//调用内部类的构造函数，并把当前绑定的布局传入内部类中
        return myViewHolder;//最后将MyViewHolder的实例返回
    }
    //用于对RecyclerView子项的数据进行赋值//会在每个子项被滚动到屏幕内的时候执行
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //通过i参数得到当前的Checks实例
        Checks checks = checksList.get(i);
        //然后将数据设置到MyViewHolder的CheckBox和TextView当中
        myViewHolder.checkBox.setChecked(checks.getCheck());
        myViewHolder.textView.setText(checks.getCheckText());
    }
    //告诉我们RecyclerView一共有多少子项
    @Override
    public int getItemCount() {
        return checksList.size();
    }
}
