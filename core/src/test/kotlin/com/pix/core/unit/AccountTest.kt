package com.pix.core.unit

import br.com.six2six.fixturefactory.Fixture
import com.pix.core.entities.Account
import com.pix.core.unit.config.UnitTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test

@UnitTest
internal class AccountTest {

    @Test
    internal fun shouldAccountBeActive() {
        val account = Fixture.from(Account::class.java).gimme<Account>("active")
        assertTrue(account.accountIsActive())
    }

    @Test
    internal fun shouldAccountNotBeActive() {
        val account = Fixture.from(Account::class.java).gimme<Account>("inactive")
        assertFalse(account.accountIsActive())
    }
}