
plugins {
	kotlin("jvm")
	id("org.jetbrains.kotlin.plugin.noarg")
}

noArg {
	annotation("com.pix.core.annotations.NoArgs")
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("javax.inject:javax.inject:1")
	implementation("org.junit.jupiter:junit-jupiter:5.8.1")
	implementation("br.com.six2six:fixture-factory:3.1.0")
	implementation("io.github.serpro69:kotlin-faker:1.11.0")
}
