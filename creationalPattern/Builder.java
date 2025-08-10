package creationalPattern;

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private User(UserBuilder builder) {
        this.age = builder.age;
        this.name = builder.name;
    }

    // Inner static Builder Class
    public static class UserBuilder{
        private String name;
        private int age;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}



public class Builder {
    public static void main(String[] args) {
        User user = new User.UserBuilder().setAge(12).setName("tikam").build();
        System.out.println(user.getAge() + user.getName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("23").append(1);
        System.out.println(stringBuilder);
    }
}
