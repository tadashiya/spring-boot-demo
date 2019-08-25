package com.haitekuya.demo

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller

/**
 * 1. Just Use huge Memory
 * 2. Remove Memory
 */
@Controller
class DemoController {

    private val logger = LoggerFactory.getLogger(DemoController::class.java)

    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    @Scheduled(fixedDelay = 10_000L)
    fun copyFileBatchTest1() {
        val values = MutableList(1_000_000) {
            (1..33)
                .map { kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")
        }
        logger.info(values[0].toString())
//        values.clear()
    }

}

