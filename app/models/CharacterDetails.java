package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CharacterDetails
{
    @Id private int characterId;
    private String characterName;
    private int level;
    private String raceName;
    private String classType;
    private String backgroundName;

    public CharacterDetails(int characterId, String characterName, int level, String raceName, String classType, String backgroundName)
    {
        this.characterId = characterId;
        this.characterName = characterName;
        this.level = level;
        this.raceName = raceName;
        this.classType = classType;
        this.backgroundName = backgroundName;
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public String getCharacterName()
    {
        return characterName;
    }

    public int getLevel()
    {
        return level;
    }

    public String getRaceName()
    {
        return raceName;
    }

    public String getClassType()
    {
        return classType;
    }

    public String getBackgroundName()
    {
        return backgroundName;
    }
}
