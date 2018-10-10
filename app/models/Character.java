package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Character
{
    @Id private int characterId;
    private String characterName;
    private int level;
    private int proficiencyBonus;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int strengthModifier;
    private int dexterityModifier;
    private int constitutionModifier;
    private int intelligenceModifier;
    private int wisdomModifier;
    private int charismaModifier;
    private int raceId;
    private int backgroundId;
    private int hitDice;
    private int healthTotal;
    private int classTypeId;
    private int acrobatics;
    private int animalHandling;
    private int arcana;
    private int athletics;
    private int deception;
    private int history;
    private int insight;
    private int intimidation;
    private int investigation;
    private int medicine;
    private int perception;
    private int performance;
    private int persuasion;
    private int religion;
    private int sleightOfHand;
    private int stealth;
    private int survival;

    public int getCharacterId()
    {
        return characterId;
    }

    public String getCharacterName()
    {
        return characterName;
    }

    public void setCharacterName(String characterName)
    {
        this.characterName = characterName;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getProficiencyBonus(int level)
    {
        if (level == 5)
        {
            proficiencyBonus = 3;
        }
        else
        {
            proficiencyBonus = 2;
        }

        return proficiencyBonus;
    }

    public int getStrength()
    {
        return strength;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public int getDexterity()
    {
        return dexterity;
    }

    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }

    public int getConstitution()
    {
        return constitution;
    }

    public void setConstitution(int constitution)
    {
        this.constitution = constitution;
    }

    public int getIntelligence()
    {
        return intelligence;
    }

    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }

    public int getWisdom()
    {
        return wisdom;
    }

    public void setWisdom(int wisdom)
    {
        this.wisdom = wisdom;
    }

    public int getCharisma()
    {
        return charisma;
    }

    public void setCharisma(int charisma)
    {
        this.charisma = charisma;
    }

    public int getRaceId()
    {
        return raceId;
    }

    public void setRaceId(int raceId)
    {
        this.raceId = raceId;
    }

    public int getBackgroundId()
    {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId)
    {
        this.backgroundId = backgroundId;
    }

    public int getHitDice()
    {
        return hitDice;
    }

    public void setHitDice(int hitDice)
    {
        this.hitDice = hitDice;
    }

    public int getHealthTotal()
    {
        int averageHP;
        if (hitDice == 12)
        {
            averageHP = 7 + constitutionModifier;
        }
        else if (hitDice == 10)
        {
            averageHP = 6 + constitutionModifier;
        }
        else if (hitDice == 8)
        {
            averageHP = 5 + constitutionModifier;
        }
        else
        {
            averageHP = 4 + constitutionModifier;
        }

        healthTotal = (hitDice + constitutionModifier) + (averageHP * (level - 1));

        return healthTotal;
    }

    public int getClassTypeId()
    {
        return classTypeId;
    }

    public void setClassTypeId(int classTypeId)
    {
        this.classTypeId = classTypeId;
    }

    public int getAcrobatics()
    {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics)
    {
        this.acrobatics = acrobatics;
    }

    public int getAnimalHandling()
    {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling)
    {
        this.animalHandling = animalHandling;
    }

    public int getArcana()
    {
        return arcana;
    }

    public void setArcana(int arcana)
    {
        this.arcana = arcana;
    }

    public int getAthletics()
    {
        return athletics;
    }

    public void setAthletics(int athletics)
    {
        this.athletics = athletics;
    }

    public int getDeception()
    {
        return deception;
    }

    public void setDeception(int deception)
    {
        this.deception = deception;
    }

    public int getHistory()
    {
        return history;
    }

    public void setHistory(int history)
    {
        this.history = history;
    }

    public int getInsight()
    {
        return insight;
    }

    public void setInsight(int insight)
    {
        this.insight = insight;
    }

    public int getIntimidation()
    {
        return intimidation;
    }

    public void setIntimidation(int intimidation)
    {
        this.intimidation = intimidation;
    }

    public int getInvestigation()
    {
        return investigation;
    }

    public void setInvestigation(int investigation)
    {
        this.investigation = investigation;
    }

    public int getMedicine()
    {
        return medicine;
    }

    public void setMedicine(int medicine)
    {
        this.medicine = medicine;
    }

    public int getPerception()
    {
        return perception;
    }

    public void setPerception(int perception)
    {
        this.perception = perception;
    }

    public int getPerformance()
    {
        return performance;
    }

    public void setPerformance(int performance)
    {
        this.performance = performance;
    }

    public int getPersuasion()
    {
        return persuasion;
    }

    public void setPersuasion(int persuasion)
    {
        this.persuasion = persuasion;
    }

    public int getReligion()
    {
        return religion;
    }

    public void setReligion(int religion)
    {
        this.religion = religion;
    }

    public int getSleightOfHand()
    {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand)
    {
        this.sleightOfHand = sleightOfHand;
    }

    public int getStealth()
    {
        return stealth;
    }

    public void setStealth(int stealth)
    {
        this.stealth = stealth;
    }

    public int getSurvival()
    {
        return survival;
    }

    public void setSurvival(int survival)
    {
        this.survival = survival;
    }
}
