package com.example.springdocdemo.storage

import com.example.springdocdemo.domain.Course
import java.util.UUID

interface CourseStorage {
    fun getCourse(id: UUID): Course
}