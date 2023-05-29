package com.targetindia.programs;

import com.targetindia.model.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticDemo {

    public static void main(String[] args) {
        log.trace("Value of Test.num is {}", Test.num);
        Test t1 = new Test();
        log.trace("Value of Test.num is {}", Test.num);
        Test t2 = new Test(999);
        log.trace("Value of Test.num is {}", Test.num);
        Test t3 = new Test(555);
        log.trace("Value of Test.num is {}", Test.num);

        log.trace("t1.num is {}, t2.num is {}, t3.num is {} and Test.num is {}",
                t1.num, t2.num, t3.num, Test.num);
    }
}
