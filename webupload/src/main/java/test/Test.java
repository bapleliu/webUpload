package test;

/**
 * 1：一个方法不能改变一个基本类型的参数
 * 2: 一个方法可以改变一个对象参数的属性
 * 3：一个方法不能让一个对象参数引用一个新的对象
 */
public class Test {

    public static void main(String args[]){
        System.out.println("AAA");
        int num = 10;
        System.out.println("开始前："+num);
        setNum(num);
        System.out.println("结束后：" + num);
        System.out.println("***************************************");

        StringBuffer buff =  new StringBuffer("AAA");
        System.out.println("开始前：" + buff.toString());
        setStringBuff(buff);
        System.out.println("结束后：" + buff.toString());

        System.out.println("***************************************");

        User user = new User(1, "张三");
        System.out.println("开始前：" + user.toString());
        setUser(user);
        System.out.println("结束后：" + user.toString());

        System.out.println("***************************************");

        User user2 = new User(1, "张三");
        System.out.println("开始前：" + user2.toString());
        setUser2(user2);
        System.out.println("结束后：" + user2.toString());

    }

    public static void setNum(int num){
        num = num*3;
        System.out.println("endOfMethod："+num);
    }

    public static void setStringBuff(StringBuffer buff) {
        buff.append("追加的字符");
    }

    public static void setUser(User user) {
       user.setName("修改后的");
    }

    public static void setUser2(User user) {
        User user2 = new User(2, "张三2");
        user = user2;
    }

}

class User{
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}




