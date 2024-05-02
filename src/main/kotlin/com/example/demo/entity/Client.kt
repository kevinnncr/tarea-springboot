package com.example.demo.entity

import jakarta.persistence.*

@Entity
@Table( name = "client")
class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var namecli: String? = null
    var address: String? = null

}