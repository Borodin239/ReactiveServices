package com.borodin239.repository

import com.borodin239.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface UserRepository : ReactiveCrudRepository<User, UUID>