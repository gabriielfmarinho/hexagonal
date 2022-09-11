package com.pix.core.fixture.extensions

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class FixtureExtension : BeforeAllCallback {

    override fun beforeAll(context: ExtensionContext?) {
        FixtureFactoryLoader.loadTemplates(PACKAGE_FIXTURES);
    }

    companion object {
        val PACKAGE_FIXTURES = "com.pix.core.fixture"
    }

}