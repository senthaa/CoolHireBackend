package com.javainuse.model;


import javax.persistence.*;

@Entity

@Table(name="userlog")
public class Driver {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;


    public Driver(){}

    public Driver(String username, String password) {
        this.username = username;
        this.password = password;
    }
//    @OneToMany(mappedBy = "vehiclenumber", cascade = CascadeType.ALL)
//    private Set<Taxi> vehicles;



    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public void setUsername(String username) {
        this.username=username;
    }
}
