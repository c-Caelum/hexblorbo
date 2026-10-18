package caelum.hexblorbo.neoforge;

import net.neoforged.fml.common.Mod;

import caelum.hexblorbo.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
