package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameCharacter
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int characterId;
    private String characterName;
    private int level;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int raceId;
    private int backgroundId;
    private int hitDice;
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
    private int nature;
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

    public int getProficiencyBonus()
    {
        int proficiencyBonus;

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

    public int getNewStrength()
    {
        DieRoll dieRoll = new DieRoll();
        strength = dieRoll.getStrValue();
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

    public int getNewDexterity()
    {
        DieRoll dieRoll = new DieRoll();
        dexterity = dieRoll.getDexValue();
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

    public int getNewConstitution()
    {
        DieRoll dieRoll = new DieRoll();
        constitution = dieRoll.getConValue();
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

    public int getNewIntelligence()
    {
        DieRoll dieRoll = new DieRoll();
        intelligence = dieRoll.getIntValue();
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

    public int getNewWisdom()
    {
        DieRoll dieRoll = new DieRoll();
        wisdom = dieRoll.getWisValue();
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

    public int getNewCharisma()
    {
        DieRoll dieRoll = new DieRoll();
        charisma = dieRoll.getChaValue();
        return charisma;
    }

    public void setCharisma(int charisma)
    {
        this.charisma = charisma;
    }

    public int getStrengthModifier()
    {
        int strengthModifier = (strength - 10) / 2;

        return strengthModifier;
    }

    public int getDexterityModifier()
    {
        int dexterityModifier = (dexterity - 10) / 2;

        return dexterityModifier;
    }

    public int getConstitutionModifier()
    {
        int constitutionModifier = (constitution - 10) / 2;

        return constitutionModifier;
    }

    public int getIntelligenceModifier()
    {
        int intelligenceModifier = (intelligence - 10) / 2;

        return intelligenceModifier;
    }

    public int getWisdomModifier()
    {
        int wisdomModifier = (wisdom - 10) / 2;

        return wisdomModifier;
    }

    public int getCharismaModifier()
    {
        int charismaModifier = (charisma - 10) / 2;

        return charismaModifier;
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
            averageHP = 7 + getConstitutionModifier();
        }
        else if (hitDice == 10)
        {
            averageHP = 6 + getConstitutionModifier();
        }
        else if (hitDice == 8)
        {
            averageHP = 5 + getConstitutionModifier();
        }
        else
        {
            averageHP = 4 + getConstitutionModifier();
        }

        int healthTotal = (hitDice + getConstitutionModifier()) + (averageHP * (level - 1));

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

    public int getNature()
    {
        return nature;
    }

    public void setNature(int nature)
    {
        this.nature = nature;
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
