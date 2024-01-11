package dev.aurelium.auraskills.api;

import dev.aurelium.auraskills.api.region.Regions;

public interface AuraSkillsBukkit {

    /**
     * Gets the region manager for checking and adding placed blocks.
     *
     * @return the region manager
     */
    Regions getRegions();

    /**
     * Gets the instance of the {@link AuraSkillsBukkit} API,
     * throwing {@link IllegalStateException} if the API is not loaded yet.
     *
     * @return the Bukkit API instance
     * @throws IllegalStateException if the API is not loaded
     */
    static AuraSkillsBukkit get() {
        return AuraSkillsBukkitProvider.getInstance();
    }

}
