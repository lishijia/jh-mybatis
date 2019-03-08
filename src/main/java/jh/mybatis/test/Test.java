package jh.mybatis.test;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0814:22
 **/
public class Test {
    public int id;
    private String name;

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
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
