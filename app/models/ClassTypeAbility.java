package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassTypeAbility
{
    @Id private int classTypeAbilityId;
    private int classTypeId;
    private int abilityId;
    private int minLevel;

    public int getClassTypeAbilityId()
    {
        return classTypeAbilityId;
    }

    public int getClassTypeId()
    {
        return classTypeId;
    }

    public void setClassTypeId(int classTypeId)
    {
        this.classTypeId = classTypeId;
    }

    public int getAbilityId()
    {
        return abilityId;
    }

    public void setAbilityId(int abilityId)
    {
        this.abilityId = abilityId;
    }

    public int getMinLevel()
    {
        return minLevel;
    }

    public void setMinLevel(int minLevel)
    {
        this.minLevel = minLevel;
    }
}
