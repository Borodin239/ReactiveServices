package com.borodin239.exceptions

import java.util.UUID

class UserNotFoundException(id: UUID): Exception("User with id $id is not found")