package main.passobject;

class User{
    int id ;
    String name;
    @Override
    public String toString() {
        return "id " + id +  " name "+ name;
    }
}
public class PassByValueTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.id = 10;
        user1.name = "lalit";

        User user2 = new User();
        user2.name = "rahul";
        user2.id = 20;

        System.out.println("before user is : "+ user1.toString() + " user 2 : "+ user2.toString());
        swap(user1, user2);
        System.out.println("now user is : "+ user1.toString() + " user 2 : "+ user2.toString());
                Integer i = 50;
        Integer j = 100;
        swapWrap(i, j);
        System.out.println(i + "  "+ j);

        swap2(12, 13);

    }

    private static void swap2(int i, int i1) {
        int temp = i;
        i = i1;
        i1 = temp;
    }

    private static void swap(User user1, User user2){
        User temp = new User();
        temp.id = user1.id;
        temp.name = user1.name;

        user1.id = user2.id;
        user2.id = temp.id
        ;

    }
    private static void swapWrap(Integer i1, Integer i2){
        Integer temp = i1;
        i1 = i2;
        i2 = temp;
    }
}
