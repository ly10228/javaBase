package com.ly.collection.dto;

/**
 * @author luoyong
 * @Description: UserDTO
 * @create 2019-06-22 22:59
 * @last modify by [dell 2019-06-22 22:59]
 **/
public class UserDTO implements Comparable {
    private String name;
    private int age;

    public UserDTO() {
    }

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals()....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO user = (UserDTO) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        //return name.hashCode() + age;
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小排列,年龄从小到大排列
    public int compareTo(Object o) {
        if(o instanceof UserDTO){
            UserDTO user = (UserDTO)o;
//            return -this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if(compare != 0){
                return compare;
            }else{
                int compareAge = Integer.compare(this.age, user.age);
                return compareAge;
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}
