package test01;

public class test01 {
    public static void main(String[] args) {
        name n1 = new name();
        n1.setName("小");
        System.out.println(n1.getName());
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}

class name {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

