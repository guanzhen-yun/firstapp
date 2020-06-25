package com.test.firstapp.entity;

/**
 * 数据对象
 */
public class RecyclerDao {
    public String name;//名称
    public String desc;//描述
    public String url;//图片链接 Glide图片设置

    //构造函数 ---- new对象的时候  把值赋值给成员变量name  desc
    public RecyclerDao(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
