package com.example.springdocdemo.usecase

import com.example.springdocdemo.domain.Course
import com.example.springdocdemo.storage.CourseStorage
import java.util.UUID

class GetCourse(private val courseStorage: CourseStorage) {
    operator fun invoke(id: UUID): Course {
        return courseStorage.getCourse(id)
    }
}