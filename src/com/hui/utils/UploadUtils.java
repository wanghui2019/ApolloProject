package com.hui.utils;

import org.junit.Test;

import java.util.UUID;

public class UploadUtils {
    //获取一个唯一标识的uuid值
    public static String getUUID(String oldName){
        /*
        思路：
        截取oldName的后缀名
        获取一个32位的随机的uuid值，将-用空格替换掉
        将二者拼接
         */
        int index = oldName.lastIndexOf(".");
        String substring = oldName.substring(index);
        String uuid=UUID.randomUUID().toString().replace("-","");
        return uuid+substring;
    }

    //获取8个目录的文件夹
    public static String getDirs(String name){
        int i = name.hashCode();
        //返回一个16进制的字符串
        String hex = Integer.toHexString(i);
        int j=hex.length();
        //防止生成的hex不够8位
        for (int k=0;k<8-j;k++){
            hex="0"+hex;
        }
        String str="";
        for (int m=0;m<hex.length();m++){
            str+="/"+hex.charAt(m);
        }
        return str;
    }


    //获取一个
    @Test
    public void DemoTest(){
        String newName = UploadUtils.getUUID("aaa.txt");
        //获取文件夹的字符串
        String dirs = UploadUtils.getDirs(newName);
        //拼接一个到本地计算机的字符串路径
        String root="/Users/wanghui/Desktop/file";
        String url=root+dirs;
        System.out.println(url);
    }
}
