public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        // Проверяем, что email соответствует формату
        if (!email.contains("@") && email.contains(".")) {
            throw new IllegalArgumentException("Некорректный email: " + email);
        }

        // Проверяем, что email не совпадает с именем пользователя
        if (email.equalsIgnoreCase(name)) {
            throw new RuntimeException("Email не может совпадать с именем пользователя");
        }

        this.name = name;
        this.email = email;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
