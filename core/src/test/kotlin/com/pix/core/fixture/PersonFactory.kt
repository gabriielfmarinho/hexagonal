package com.pix.core.fixture

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.pix.core.entities.Person
import com.pix.core.faker.FakerInstance
import io.github.serpro69.kfaker.Faker

class PersonFactory : TemplateLoader {

    private val faker: Faker = FakerInstance.getInstance()

    override fun load() {
        Fixture.of(Person::class.java).addTemplate("default", object : Rule() {
            init {
                add("name", faker.name.name())
                add("document", cnpj())
            }
        })
    }
}