package com.archyx.aureliumskills.skills;

import com.archyx.aureliumskills.ability.Ability;
import com.archyx.aureliumskills.lang.Lang;
import com.archyx.aureliumskills.lang.SkillMessage;
import com.archyx.aureliumskills.mana.MAbility;
import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public enum Skills implements Skill {

	FARMING(ImmutableList.of(() -> Ability.BOUNTIFUL_HARVEST, () -> Ability.FARMER, () -> Ability.SCYTHE_MASTER, () -> Ability.GENETICIST, () -> Ability.TRIPLE_HARVEST),
			MAbility.REPLENISH),
	FORAGING(ImmutableList.of(() -> Ability.LUMBERJACK, () -> Ability.FORAGER, () -> Ability.AXE_MASTER, () -> Ability.VALOR, () -> Ability.SHREDDER),
			MAbility.TREECAPITATOR),
	MINING(ImmutableList.of(() -> Ability.LUCKY_MINER, () -> Ability.MINER, () -> Ability.PICK_MASTER, () -> Ability.STAMINA, () -> Ability.HARDENED_ARMOR),
			MAbility.SPEED_MINE),
	FISHING(ImmutableList.of(() -> Ability.LUCKY_CATCH, () -> Ability.FISHER, () -> Ability.TREASURE_HUNTER, () -> Ability.GRAPPLER, () -> Ability.EPIC_CATCH),
			MAbility.SHARP_HOOK),
	EXCAVATION(ImmutableList.of(() -> Ability.METAL_DETECTOR, () -> Ability.EXCAVATOR, () -> Ability.SPADE_MASTER, () -> Ability.BIGGER_SCOOP, () -> Ability.LUCKY_SPADES),
			MAbility.TERRAFORM),
	ARCHERY(ImmutableList.of(() -> Ability.CRIT_CHANCE, () -> Ability.ARCHER, () -> Ability.BOW_MASTER, () -> Ability.PIERCING, () -> Ability.STUN),
			MAbility.CHARGED_SHOT),
	DEFENSE(ImmutableList.of(() -> Ability.SHIELDING, () -> Ability.DEFENDER, () -> Ability.MOB_MASTER, () -> Ability.IMMUNITY, () -> Ability.NO_DEBUFF),
			MAbility.ABSORPTION),
	FIGHTING(ImmutableList.of(() -> Ability.CRIT_DAMAGE, () -> Ability.FIGHTER, () -> Ability.SWORD_MASTER, () -> Ability.FIRST_STRIKE, () -> Ability.BLEED),
			MAbility.LIGHTNING_BLADE),
	ENDURANCE(ImmutableList.of(() -> Ability.ANTI_HUNGER, () -> Ability.RUNNER, () -> Ability.GOLDEN_HEAL, () -> Ability.RECOVERY, () -> Ability.MEAL_STEAL),
			null),
	AGILITY(ImmutableList.of(() -> Ability.LIGHT_FALL, () -> Ability.JUMPER, () -> Ability.SUGAR_RUSH, () -> Ability.FLEETING, () -> Ability.THUNDER_FALL),
			null),
	ALCHEMY(ImmutableList.of(() -> Ability.ALCHEMIST, () -> Ability.BREWER, () -> Ability.SPLASHER, () -> Ability.LINGERING, () -> Ability.WISE_EFFECT),
			null),
	ENCHANTING(ImmutableList.of(() -> Ability.XP_CONVERT, () -> Ability.ENCHANTER, () -> Ability.XP_WARRIOR, () -> Ability.ENCHANTED_STRENGTH, () -> Ability.LUCKY_TABLE),
			null),
	SORCERY(ImmutableList.of(() -> Ability.SORCERER),
			null),
	HEALING(ImmutableList.of(() -> Ability.LIFE_ESSENCE, () -> Ability.HEALER, () -> Ability.LIFE_STEAL, () -> Ability.GOLDEN_HEART, () -> Ability.REVIVAL),
			null),
	FORGING(ImmutableList.of(() -> Ability.DISENCHANTER, () -> Ability.FORGER, () -> Ability.REPAIRING, () -> Ability.ANVIL_MASTER, () -> Ability.SKILL_MENDER),
			null);

	private final ImmutableList<Supplier<Ability>> abilities;
	private final MAbility manaAbility;
	
	Skills(ImmutableList<Supplier<Ability>> abilities, MAbility manaAbility) {
		this.abilities = abilities;
		this.manaAbility = manaAbility;
	}

	@Override
	public ImmutableList<Supplier<Ability>> getAbilities() {
		return abilities;
	}

	@Override
	public String getDescription(Locale locale) {
		return Lang.getMessage(SkillMessage.valueOf(this.name() + "_DESC"), locale);
	}

	@Override
	public String getDisplayName(Locale locale) {
		return Lang.getMessage(SkillMessage.valueOf(this.name().toUpperCase(Locale.ROOT) + "_NAME"), locale);
	}

	@Override
	@Nullable
	public MAbility getManaAbility() {
		return manaAbility;
	}

	@Override
	public Ability getXpMultiplierAbility() {
		if (abilities.size() == 5) {
			return abilities.get(1).get();
		} else {
			return abilities.get(0).get();
		}
	}

	public static List<Skills> getOrderedValues() {
		List<Skills> list = new ArrayList<>();
		list.add(Skills.AGILITY);
		list.add(Skills.ALCHEMY);
		list.add(Skills.ARCHERY);
		list.add(Skills.DEFENSE);
		list.add(Skills.ENCHANTING);
		list.add(Skills.ENDURANCE);
		list.add(Skills.EXCAVATION);
		list.add(Skills.FARMING);
		list.add(Skills.FIGHTING);
		list.add(Skills.FISHING);
		list.add(Skills.FORAGING);
		list.add(Skills.FORGING);
		list.add(Skills.HEALING);
		list.add(Skills.MINING);
		list.add(Skills.SORCERY);
		return list;
	}
	
}
