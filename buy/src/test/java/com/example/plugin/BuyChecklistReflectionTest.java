package com.example.plugin;

import org.junit.jupiter.api.Test;

class BuyChecklistReflectionTest {
    BuyChecklistPlugin buyChecklistPlugin = new BuyChecklistPlugin();

    @Test
    void pluginTest() {
        buyChecklistPlugin.run();
    }

}