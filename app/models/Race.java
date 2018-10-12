package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Race
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int raceId;
    private String raceName;
    private int raceStrMod;
    private int raceDexMod;
    private int raceConMod;
    private int raceIntMod;
    private int raceWisMod;
    private int raceChaMod;
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

    public int getRaceId()
    {
        return raceId;
    }

    public String getRaceName()
    {
        return raceName;
    }

    public void setRaceName(String raceName)
    {
        this.raceName = raceName;
    }

    public int getRaceStrMod()
    {
        return raceStrMod;
    }

    public void setRaceStrMod(int raceStrMod)
    {
        this.raceStrMod = raceStrMod;
    }

    public int getRaceDexMod()
    {
        return raceDexMod;
    }

    public void setRaceDexMod(int raceDexMod)
    {
        this.raceDexMod = raceDexMod;
    }

    public int getRaceConMod()
    {
        return raceConMod;
    }

    public void setRaceConMod(int raceConMod)
    {
        this.raceConMod = raceConMod;
    }

    public int getRaceIntMod()
    {
        return raceIntMod;
    }

    public void setRaceIntMod(int raceIntMod)
    {
        this.raceIntMod = raceIntMod;
    }

    public int getRaceWisMod()
    {
        return raceWisMod;
    }

    public void setRaceWisMod(int raceWisMod)
    {
        this.raceWisMod = raceWisMod;
    }

    public int getRaceChaMod()
    {
        return raceChaMod;
    }

    public void setRaceChaMod(int raceChaMod)
    {
        this.raceChaMod = raceChaMod;
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
