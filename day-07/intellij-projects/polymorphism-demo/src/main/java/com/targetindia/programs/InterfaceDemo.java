package com.targetindia.programs;

import com.targetindia.model.Camera;
import com.targetindia.model.Phone;
import com.targetindia.model.SmartPhone;

public class InterfaceDemo {

    public static void main(String[] args) {

        Camera c1;
        // c1 = new Camera(); // error; Camera is abstract
        SmartPhone sm = new SmartPhone();

        c1 = sm;
        // An object of SmartPhone is an instance of:
        // 1. SmartPhone
        // 2. Phone
        // 3. Object
        // 4. Camera

        Phone p = sm; // every SmartPhone is-a Phone
        p.dialNumber();
        p.call();
        p.disconnect();

        // using c1 we can invoke the methods declared in Camera interface and not the ones declared/defined
        // in the object's type (i.e, SmartPhone)
        // For example, using c1 we cannot call c1.dial()
        c1.takePicture();
        c1.zoom();


    }
}
