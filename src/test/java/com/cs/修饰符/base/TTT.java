package com.cs.修饰符.base;


public class TTT extends AccessLimit{
	void betray() {
        AccessLimit stark = new AccessLimit();
         System.out.println(stark.robb); 
         System.out.println(stark.sansa);
//         System.out.println(stark.ned);
         
         TTT tt = new TTT();
         System.out.println(tt.robb); 
         System.out.println(tt.sansa);
        
    }
}
