package com.serhiiv.news.data.remote.mapper

interface BaseMapper<out To, in From> {
    fun map(from: From): To

    operator fun invoke(from: From): To = map(from)

    operator fun invoke(list: List<From>): List<To> = list.map(this::map)
}
