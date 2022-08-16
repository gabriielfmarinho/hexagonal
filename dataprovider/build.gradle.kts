plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("jvm")
}

dependencies {
	implementation(project(":core"))
	implementation("com.amazonaws:aws-java-sdk-dynamodb:1.12.267")
	implementation("org.springframework.data:spring-data-releasetrain:1.4.6.RELEASE")
	implementation("com.github.derjust:spring-data-dynamodb:5.1.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

