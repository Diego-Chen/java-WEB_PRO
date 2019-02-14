package com.cs.修饰符.base1;

import com.cs.修饰符.base.AccessLimit;

public class Greyjoy extends AccessLimit {
    void betray() {

//        AccessLimit stark = new AccessLimit();
//        System.out.println(stark.arya);
//        System.out.println(stark.ned);
//         System.out.println(stark.robb);
//         System.out.println(stark.sansa); 
         

        Greyjoy greyjoy = new Greyjoy();
 
        System.out.println(greyjoy.sansa);
        System.out.println(greyjoy.arya);

    }
}
