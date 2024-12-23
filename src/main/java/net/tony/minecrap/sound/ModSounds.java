package net.tony.minecrap.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.tony.minecrap.Minecrap;

public class ModSounds {

    public static final SoundEvent HOOK_USE = registerSoundEvent("hook_use");
    //public static final SoundEvent VILLAGER_TRADE = registerSoundEvent("villager_trade");
    //public static final SoundEvent AMOGUS_BLOCK_PLACE = registerSoundEvent("amogus_place");
    public static final SoundEvent LEGACY = registerSoundEvent("legacy");
    public static final RegistryKey<JukeboxSong> LEGACY_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Minecrap.MOD_ID, "legacy"));
    //helper
    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(Minecrap.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static  void  registerSounds(){
        Minecrap.LOGGER.info("Registering Mod Sounds for " + Minecrap.MOD_ID);
    }

}
