package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharacterId
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;

    public CharacterId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
}
