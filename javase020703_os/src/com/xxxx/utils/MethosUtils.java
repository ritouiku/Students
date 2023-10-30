package com.xxxx.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MethosUtils {
    private static final String[] SURNAME = {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
            "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
            "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏",
            "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章",
            "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦",
            "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
            "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
            "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常",
            "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余",
            "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"
    };

    private static final String[] GIVEN_NAME = {
            "伟", "芳", "娜", "秀英", "敏", "静", "丽", "强", "磊", "军",
            "洋", "勇", "艳", "杰", "娟", "涛", "明", "超", "秀兰", "霞",
            "平", "刚", "桂英", "华", "飞", "英", "华", "秀珍", "全", "国",
            "胜", "建国", "玉兰", "成", "红", "长", "欢", "小红", "文", "利",
            "洁", "燕", "华", "彬", "莉", "凤英", "勇", "艳", "杰", "琴",
            "兰", "晓", "军", "秀英", "强", "磊", "丽", "洋", "敏", "静",
            "娟", "涛", "明", "超", "平", "霞", "刚", "桂英", "华", "飞",
            "英", "华", "秀珍", "胜"
    };

    public static String generateChineseName() {
        Random random = new Random();
        String surname = SURNAME[random.nextInt(SURNAME.length)];
        String givenName = GIVEN_NAME[random.nextInt(GIVEN_NAME.length)];
        return surname + givenName;
    }

    public static String generateRandomEthnicity() {
        String[] ethnicities = {
                "汉族", "藏族", "维吾尔族", "苗族", "彝族", "壮族", "朝鲜族",
                "满族", "哈萨克族", "布依族", "瑶族", "白族", "土家族", "哈尼族",
                "侗族", "傣族", "黎族", "傈僳族", "佤族", "畲族", "高山族", "拉祜族",
                "水族", "东乡族", "纳西族", "景颇族", "柯尔克孜族", "土族", "达斡尔族",
                "仫佬族", "羌族", "布朗族", "撒拉族", "毛南族", "仡佬族", "锡伯族",
                "阿昌族", "普米族", "塔吉克族", "怒族", "乌孜别克族", "俄罗斯族", "鄂温克族",
                "德昂族", "保安族", "裕固族", "京族", "塔塔尔族", "独龙族", "鄂伦春族",
                "赫哲族", "门巴族", "珞巴族", "基诺族"
        };

        Random random = new Random();
        int index = random.nextInt(ethnicities.length);
        return ethnicities[index];
    }
    public static String formatDateToEightDigits(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }
}


