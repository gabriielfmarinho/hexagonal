package com.pix.core.fixture

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.pix.core.entities.Account
import com.pix.core.entities.AccountStatus.ACTIVE
import com.pix.core.entities.AccountStatus.BLOCKED
import com.pix.core.entities.AccountStatus.INACTIVE
import com.pix.core.entities.AccountType.CURRENT
import com.pix.core.entities.AccountType.SAVINGS
import com.pix.core.entities.Person

class AccountFactory : TemplateLoader {

    override fun load() {
        Fixture.of(Account::class.java).addTemplate("default", object : Rule() {
            init {
                add("agency", regex("[0-9]{4}"))
                add("number", regex("[0-9]{6}"))
                add("operation", regex("[0-9]{2}"))
                add("status", random(ACTIVE, INACTIVE, BLOCKED))
                add("type", random(CURRENT, SAVINGS))
                add("person", one(Person::class.java, "default"))
            }
        })

        Fixture.of(Account::class.java).addTemplate("active", object : Rule() {
            init {
                add("agency", regex("[0-9]{4}"))
                add("number", regex("[0-9]{6}"))
                add("operation", regex("[0-9]{2}"))
                add("status", ACTIVE)
                add("type", random(CURRENT, SAVINGS))
                add("person", one(Person::class.java, "default"))
            }
        })

        Fixture.of(Account::class.java).addTemplate("inactive", object : Rule() {
            init {
                add("agency", regex("[0-9]{4}"))
                add("number", regex("[0-9]{6}"))
                add("operation", regex("[0-9]{2}"))
                add("status", INACTIVE)
                add("type", random(CURRENT, SAVINGS))
                add("person", one(Person::class.java, "default"))
            }
        })
    }
}