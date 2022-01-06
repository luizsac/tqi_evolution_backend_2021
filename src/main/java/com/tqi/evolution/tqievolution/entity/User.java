package com.tqi.evolution.tqievolution.entity;

import com.tqi.evolution.tqievolution.dto.AuthenticadedUserDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "user")
@NoArgsConstructor @EqualsAndHashCode @Getter @Setter
public class User {

    @Id @GeneratedValue
    private long user_id;

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

    @Column(nullable = false, length = 50)
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    List<LoanRequest> loanRequests;


    public String toString() {
        return "User(user_id=" + this.user_id + ", name=" + this.name + ", email=" + this.email + ", cpf=" + this.cpf + ", rg=" + this.rg + ", address=" + this.address + ", income=" + this.income + ")";
    }


    /*public void updateFields(User other) {
        setName(other.getName());
        setEmail(other.getEmail());
        setCpf(other.getCpf());
        setRg(other.getRg());
        setAddress(other.getAddress());
        setIncome(other.getIncome());
        setPassword(other.getPassword());
    }*/

}
