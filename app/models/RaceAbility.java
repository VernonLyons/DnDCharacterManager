package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RaceAbility
{
    @Id private int raceAbilityId;
    private int raceId;
    private int abilityId;

    public int getRaceAbilityId()
    {
        return raceAbilityId;
    }

    public int getRaceId()
    {
        return raceId;
    }

    public void setRaceId(int raceId)
    {
        this.raceId = raceId;
    }

    public int getAbilityId()
    {
        return abilityId;
    }

    public void setAbilityId(int abilityId)
    {
        this.abilityId = abilityId;
    }
}
