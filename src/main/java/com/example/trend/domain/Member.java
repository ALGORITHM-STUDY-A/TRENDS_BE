package com.example.trend.domain;

import com.example.trend.domain.enumClass.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private String name;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Address> address=new ArrayList<>();


    /*--------------------------------기업용--------------------------------------*/
}
