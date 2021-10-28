package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是零钱通各个功能的类
 * 使用OOP
 * 将各个功能对应一个方法
 */

public class SmallChangeSysOOP {

    //1.先完成显示菜单，并可以选择菜单，给出对应提示
    boolean loop = true;    //判断是否退出系统
    Scanner scanner = new Scanner(System.in);
    String key = "";

    //2.完成零钱通明细 拼接字符串
    String details = "------------------------零钱通明细OOP------------------------";

    //3.完成收益入账 定义新变量
    double money = 0;
    double balance = 0;
    Date date = null;   //date是java.util.Date 类型，表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");    //日期格式化

    //4.消费 定义新变量，保存消费原因
    String note = "";

    //菜单
    public  void mainMenu(){

        do {
            System.out.println("\n================零钱通菜单================");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择(1-4):");
            key = scanner.next();

            switch (key){
                case "1" :
                    this.detail();
                    break;
                case "2" :
                    this.income();
                    break;
                case "3" :
                    this.pay();
                    break;
                case "4" :
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while (loop);
        System.out.println("-----退出了零钱通项目-----");
    }

    //显示明细
    public void detail(){
        System.out.println(details);
    }

    //收益入账
    public void income(){
        System.out.print("收益入账金额:");
        money = scanner.nextDouble();
        //money 的值范围应该校验

        if (money <= 0){
            System.out.println("收益入账金额需要大于0！");
            return;
        }

        balance += money;
        //拼接收益入账信息到details
        date = new Date();  //获取当前日期
        details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    //消费
    public void pay(){
        System.out.println("消费金额");
        money = scanner.nextDouble();
        //money的值范围应该校验

        if(money <= 0 || money > balance){
            System.out.println("消费金额应该在 0.0-" + balance + "元之间！");
            return;
        }

        System.out.println("消费说明:");
        note = scanner.next();
        balance -= money;
        //拼接消费信息到details
        date = new Date();  //获取当前日期
        details += "\n" + note + "\t-"+ money + "\t" + sdf.format(date) + "\t" + balance;
    }

    //退出
    public void exit(){
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
    }

}
