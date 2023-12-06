package dev.aurelium.auraskills.common.source.type;

import dev.aurelium.auraskills.api.registry.NamespacedId;
import dev.aurelium.auraskills.api.source.type.StatisticXpSource;
import dev.aurelium.auraskills.common.AuraSkillsPlugin;
import dev.aurelium.auraskills.common.source.Source;

public class StatisticSource extends Source implements StatisticXpSource {

    private final String statistic;
    private final double multiplier;
    private final int minimumIncrease;

    public StatisticSource(AuraSkillsPlugin plugin, NamespacedId id, double xp, String displayName, String statistic, double multiplier, int minimumIncrease) {
        super(plugin, id, xp, displayName);
        this.statistic = statistic;
        this.multiplier = multiplier;
        this.minimumIncrease = minimumIncrease;
    }

    @Override
    public String getStatistic() {
        return statistic;
    }

    @Override
    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public int getMinimumIncrease() {
        return minimumIncrease;
    }
}
