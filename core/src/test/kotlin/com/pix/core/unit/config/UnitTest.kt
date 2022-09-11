package com.pix.core.unit.config

import com.pix.core.fixture.extensions.FixtureExtension
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(FixtureExtension::class)
@Target(AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class UnitTest()
