package com.example.springdocdemo.controller

import com.example.springdocdemo.domain.Course
import com.example.springdocdemo.storage.CourseStorage
import com.example.springdocdemo.usecase.GetCourse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/courses")
class CourseController(
    val courseStorage: CourseStorage,
) {
    val getCourseQuery = GetCourse(courseStorage)

    @GetMapping("/{id}")
    suspend fun getCourse(@PathVariable id: UUID): Course {
        return getCourseQuery(id)
    }
}