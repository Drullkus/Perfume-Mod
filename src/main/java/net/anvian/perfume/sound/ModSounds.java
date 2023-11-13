package net.anvian.perfume.sound;

import net.anvian.perfume.PerfumeMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent PERFUME_SOUND = registerSoundEvent("perfume_sound");
    public static SoundEvent PIP_SOUND = registerSoundEvent("pip_sound");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(PerfumeMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSound(){
        PerfumeMod.LOGGER.debug("Registering custom sounds from " + PerfumeMod.MOD_ID);
    }
}
