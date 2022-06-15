package com.example.reverse_am.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 20)
    private String name;
    @Column(name = "sure_name",length = 25)
    private String sureName;
    @Column(name = "phone_numbr",length = 20)
    private String phoneNumber;
    @Column(name = "email",length = 30)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "rev_coin")
    private Long revCoin;
    @JoinColumn(name = "address_id",nullable = false,foreignKey = @ForeignKey(name = "fk_user_address"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Bag bag;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String name, String sureName, String phoneNumber, String email, String password,
                Long revCoin, Address address) {
        this.name = name;
        this.sureName = sureName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.revCoin = revCoin;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRevCoin(Long revCoin) {
        this.revCoin = revCoin;
    }

    public Long getRevCoin() {
        return revCoin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
