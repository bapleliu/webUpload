package test;

/**
 * 对象的初始化：
 * 1、静态代码快和静态变量的初始化顺序是 谁先出现加载谁
 * 2、然后再 加载 花括号
 *
 */
public class InitTest {
    public static int num = getNum();
    {
        System.out.println("花括号1");
    }

    static{
        System.out.println("静态代码快");
    }
    public static int num2 = getNum();
    {
        System.out.println("花括号2");
    }

    public static void main(String args[]) {
        new InitTest();
    }

    static int getNum(){
        System.out.println("静态变量");
        return 100;
    }

}
