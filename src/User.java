public class User {
        private int id;
        private String name;
        private String email;
        private int age;

        public User(int id,String name,String email,int age){
            this.id =id;
            this.name = name;
            this.email = email;
            this.age = age;
        }
        public int getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getEmail(){
            return email;
        }

        public String toString() {
         return "User{id=" + id + ", name='" + name + "', email='" + email + "', age=" + age + "}";
        }
}

