package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BackgroundAbility
{
    @Id private int backgroundAbilityId;
    private int backgroundId;
    private int abilityId;

    public int getBackgroundAbilityId()
    {
        return backgroundAbilityId;
    }

    public void setBackgroundAbilityId(int backgroundAbilityId)
    {
        this.backgroundAbilityId = backgroundAbilityId;
    }

    public int getBackgroundId()
    {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId)
    {
        this.backgroundId = backgroundId;
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
