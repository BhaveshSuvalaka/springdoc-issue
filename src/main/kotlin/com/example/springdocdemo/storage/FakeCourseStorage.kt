package com.example.springdocdemo.storage

import com.example.springdocdemo.domain.Course
import com.example.springdocdemo.domain.CourseItemType
import com.example.springdocdemo.domain.EnglishCourse
import com.example.springdocdemo.domain.Folder
import com.example.springdocdemo.domain.Lesson
import com.example.springdocdemo.domain.Test
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class FakeCourseStorage : CourseStorage {
    override fun getCourse(id: UUID): Course {
        return EnglishCourse(
            id = UUID.randomUUID(),
            name = "English Course",
            code = "ENG_001",
            items = listOf(
                Folder(
                    items = listOf(
                        Lesson(
                            name = "Gramer 101",
                            id = UUID.randomUUID(),
                            type = CourseItemType.Lesson
                        ),
                        Test(
                            name = "Gramer 101",
                            id = UUID.randomUUID(),
                            type = CourseItemType.Lesson
                        ),
                        Folder(
                            items = listOf(),
                            id = UUID.randomUUID(),
                            type = CourseItemType.Folder
                        )
                    ),
                    id = UUID.randomUUID(),
                    type = CourseItemType.Folder
                )
            )
        )
    }
}