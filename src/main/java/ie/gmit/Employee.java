package ie.gmit;

public class Employee {

    private String title;
    private String name;
    private String id;
    private String phoneNo;
    private int age;
    public Employee(String title, String name, String id, String phoneNo, int age) {
        if (title == "Mr" || title == "Mrs" || title == "Ms")
            this.title = title;
        else
            throw new IllegalArgumentException("Title must be Mr, Mrs, or Ms");

        if (name.length() >= 3)
            this.name = name;
        else
            throw new IllegalArgumentException("Name must be at least three characters in length");

        if(id.length() >= 10)
            this.id = id;
        else
            throw new IllegalArgumentException("ID must be at least ten characters in length");

        if(phoneNo.length() >= 10)
            this.phoneNo = phoneNo;
        else
            throw new IllegalArgumentException("Phone number must be at least ten digits in length");

        if(age > 16)
            this.age = age;
        else
            throw new IllegalArgumentException("You must be older than 16");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

