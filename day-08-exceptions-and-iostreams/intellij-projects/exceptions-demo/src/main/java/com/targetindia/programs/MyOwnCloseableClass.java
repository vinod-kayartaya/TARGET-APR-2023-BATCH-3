package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyOwnCloseableClass  implements AutoCloseable{

    public MyOwnCloseableClass() {
        log.trace("MyOwnCloseableClass constructor called");
    }

    public void close() throws Exception {
        log.trace("MyOwnCloseableClass.close() under execution");
    }
}
