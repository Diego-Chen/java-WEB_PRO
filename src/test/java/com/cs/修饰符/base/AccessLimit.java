package com.cs.修饰符.base;



//private class AccessLimit 不可以编译器报错  也不能修饰内部类
//protected class AccessLimit 不可以  编译器报错 也不能修饰内部类
//缺省修饰符 只能被同一个包中的类访问或引用。这一访问特性又称为包访问性  在同一个包的不同类中效果和public一样 在不同包的不同类中引用不了该类  无法继承
 public class AccessLimit {
	private boolean ned;
    boolean robb;
    protected boolean sansa;
    public boolean arya;
    
    void howIsNed() {
    	//同一个包下同一个类
        System.out.println(this.ned);
        System.out.println(this.sansa);
    }
    
}


 class Snow {
   void whoseBastard() {
    	AccessLimit stark = new AccessLimit();
    	//同一个包不同的类无法访问private
        // System.out.println(stark.ned); 
         //同一个包不同的类可以访问default
         System.out.println(stark.robb);
         System.out.println(stark.sansa);
    }
}