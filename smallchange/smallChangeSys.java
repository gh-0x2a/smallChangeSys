package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class smallChangeSys {

    public static void main(String[] args) {

        //1.先完成显示菜单，并可以选择菜单，给出对应提示
        boolean loop = true;    //判断是否退出系统
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.完成零钱通明细 拼接字符串
        String details = "------------------------零钱通明细------------------------";

        //3.完成收益入账 定义新变量
        double money = 0;
        double balance = 0;
        Date date = null;   //date是java.util.Date 类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");    //日期格式化

        //4.消费 定义新变量，保存消费原因
        String note = "";

        do{
            System.out.println("\n================零钱通菜单================");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择(1-4):");
            key = scanner.next();

            switch (key){
                case "1" :
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.print("收益入账金额:");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验

                    if (money <= 0){
                        System.out.println("收益入账金额需要大于0！");
                        break;
                    }

                    balance += money;
                    //拼接收益入账信息到details
                    date = new Date();  //获取当前日期
                    details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3" :
                    System.out.println("消费金额");
                    money = scanner.nextDouble();
                    //money的值范围应该校验

                    if(money <= 0 || money > balance){
                        System.out.println("消费金额应该在 0.0-" + balance + "元之间！");
                        break;
                    }

                    System.out.println("消费说明:");
                    note = scanner.next();
                    balance -= money;
                    //拼接消费信息到details
                    date = new Date();  //获取当前日期
                    details += "\n" + note + "\t-"+ money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4" :
                    //5.退出 给出提示“确定要退出吗？y/n”，必须正确输入y/n，否则循环
                    String choice = "";
                    //先判断输入的是不是y或n
                    while (true){
                        System.out.println("你确定要退出吗？y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)){
                            break;
                        }
                    }
                    //再判断是y还是n
                    if (choice.equals("y")){
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while(loop);

        System.out.println("-----退出了零钱通项目-----");
    }
}
