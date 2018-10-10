package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CharacterId
{
    @Id private Integer id;

    public CharacterId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
}
