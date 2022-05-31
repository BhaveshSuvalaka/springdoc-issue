package com.example.springdocdemo.domain

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes(
    value = [
        JsonSubTypes.Type(value = EnglishCourse::class, name = "EnglishCourse")
    ]
)
abstract class Course {
    abstract val id: UUID
    abstract val name: String
    abstract val code: String
}

class EnglishCourse(
    val items: List<CourseItem>,
    override val id: UUID,
    override val code: String,
    override val name: String,
) : Course()

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes(
    value = [
        JsonSubTypes.Type(value = Folder::class, name = "FOLDER"),
        JsonSubTypes.Type(value = Lesson::class, name = "LESSON"),
        JsonSubTypes.Type(value = Test::class, name = "TEST")
    ]
)
@Schema(discriminatorProperty = "type", allOf = [Folder::class, Lesson::class, Test::class])
interface CourseItem {
    val type: CourseItemType
    val id: UUID
}

@Schema
class Folder(
    val items: List<CourseItem>,
    override val id: UUID,
    override val type: CourseItemType,
) : CourseItem {
    fun items() = println(items)
}

class Lesson(
    val name: String,
    override val id: UUID,
    override val type: CourseItemType,
) : CourseItem

class Test(
    val name: String,
    override val id: UUID,
    override val type: CourseItemType,
) : CourseItem

enum class CourseItemType {
    Folder, Lesson, Test
}
