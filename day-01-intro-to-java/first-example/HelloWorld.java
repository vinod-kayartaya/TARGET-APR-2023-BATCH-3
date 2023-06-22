import java.lang.System; // optional. The member of java.lang package are automatically imported
import java.util.Arrays; // mandatory for all other package member

public class HelloWorld {
    static {
        System.out.println("This is an output from a static block!");
    }

    public static void main(String[] args){
        System.out.println("|-----------------|");
        System.out.println("|  Hello, world!  |");
        System.out.println("|-----------------|");

        if(args.length==0){
            System.exit(45);
        }

        System.out.println("args = " + Arrays.toString(args));
    }

    static {
        System.out.println("This is also an output from a static block!");
    }
}


class Hello {

}

class Welcome {
    int i; // declaration (used during the compilation)
    int j = 20; // here this is more of a declaration with a default value, than the execution
    // i = 10; // executable (used during the execution or runtime)
    /*
    for(int i=0; i<10; i++){
        System.out.println("hello");
    }
    */
}
