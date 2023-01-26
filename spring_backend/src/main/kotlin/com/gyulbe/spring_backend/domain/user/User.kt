package com.gyulbe.spring_backend.domain.user

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User (

    var email: String,

    var name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,
)
