package com.llh.addrecyclerviewitem;

/**
 * 项目名:    AddRecyclerViewItem
 * 包名:      com.llh.addrecyclerviewitem
 * 文件名:    Checks
 * 创建者:    LLH
 * 创建时间:  2019/8/6 10:28
 * 描述:      TODO
 */
public class Checks {
    //复选框的值
    private Boolean isCheck;
    //文本的值
    private String checkText;
    //构造函数
    public Checks(Boolean isCheck,String checkText){
        this.isCheck = isCheck;
        this.checkText = checkText;
    }
    //外部获取，赋值函数

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public String getCheckText() {
        return checkText;
    }

    public void setCheckText(String checkText) {
        this.checkText = checkText;
    }
}
