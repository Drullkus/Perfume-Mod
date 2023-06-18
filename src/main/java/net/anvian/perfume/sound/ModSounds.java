package net.anvian.perfume.sound;

import net.anvian.perfume.PerfumeMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent PERFUME_SOUND = registerSoundEvent("perfume_sound");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(PerfumeMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerModSound(){
        PerfumeMod.LOGGER.debug("Registering custom sounds from " + PerfumeMod.MOD_ID);
    }
}
