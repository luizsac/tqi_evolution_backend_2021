package com.tqi.evolution.tqievolution.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "user")
@NoArgsConstructor @Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(length = 15)
    private String rg;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    private BigDecimal income;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    List<LoanRequest> loanRequests;

    public User(String name, String email, String cpf, String rg, String address, BigDecimal income, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.address = address;
        this.income = income;
        this.password = password;
    }


    public String toString() {
        return "User(user_id=" + this.userId + ", name=" + this.name + ", email=" + this.email + ", cpf=" + this.cpf + ", rg=" + this.rg + ", address=" + this.address + ", income=" + this.income + ")";
    }


    /*
    public void updateFields(User other) {
        setName(other.getName());
        setEmail(other.getEmail());
        setCpf(other.getCpf());
        setRg(other.getRg());
        setAddress(other.getAddress());
        setIncome(other.getIncome());
        setPassword(other.getPassword());
    }*/

}
