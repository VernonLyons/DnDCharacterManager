package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ability
{
    @Id private int abilityId;
    private String abilityName;

    public int getAbilityId()
    {
        return abilityId;
    }

    public void setAbilityId(int abilityId)
    {
        this.abilityId = abilityId;
    }

    public String getAbilityName()
    {
        return abilityName;
    }
}
