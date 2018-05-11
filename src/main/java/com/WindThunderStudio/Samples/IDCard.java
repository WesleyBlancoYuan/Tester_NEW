package com.WindThunderStudio.Samples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class IDCard {
    public static void main(String args[]){
        try{
            while(true){
                System.out.println("请输入身份证号码，以回车结束：");
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String s=br.readLine();
                if(s.length()==15){
                    int total=0;
                    char f;
                    boolean t=checklong(s); 
                    if(t){
                        System.out.println("这是一个旧号码！");
                        StringBuffer s1=new StringBuffer(s).insert(6,"19");
                        StringBuffer s2=new StringBuffer(s1).append("0");
                        for(int i=1;i<=18;i++){
                            char c=s2.charAt(18-i);
                            String s3=String.valueOf(c);
                            int ai=Integer.parseInt(s3);
                            double b=Math.pow(2,(i-1));
                            int wi=(int)(b)%11;
                            System.out.println("i="+i+'\t'+"ai="+ai+'\t'+"wi="+wi);
                            total+=ai*wi;
                        }
                        total=total%11;
                        char Check[]={'1','0','X','9','8','7','6','5','4','3','2'};
                        String str4=String.valueOf(Check[total]);   
                        StringBuffer str5=new StringBuffer(s2).deleteCharAt(17);
                        StringBuffer str6=new StringBuffer(str5).append(str4);
                        System.out.println("转化后的18位新号码为："+str6);
                        break;
                    } else {
                        System.out.println("你输入有误！");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static boolean checklong(String s) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        try {
            long l = nf.parse(s).longValue();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
